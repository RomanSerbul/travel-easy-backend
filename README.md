# Travel Easy Backend

Spring Boot 3.3 сервіс для Travel Easy. Надає публічні ендпоїнти каталогу, обробляє заявки, шле нотифікації та підтримує адмін-панель.

## Стек
- Java 21, Spring Boot 3.3 (Web MVC + WebFlux ready)
- PostgreSQL (Railway managed), Redis (кеш/стан візарду)
- Thymeleaf email шаблони, Spring Mail, WebClient інтеграції (Telegram/Viber)

## Запуск локально
```bash
mvn spring-boot:run
```
Env-параметри в `.env` або змінних середовища:

| Назва | Призначення | Значення за замовчуванням |
|-------|-------------|---------------------------|
| `DATABASE_URL` | JDBC URI | `jdbc:postgresql://localhost:5432/travel_easy` |
| `DATABASE_USERNAME` | Користувач Postgres | `postgres` |
| `DATABASE_PASSWORD` | Пароль Postgres | `password` |
| `MAIL_HOST` | SMTP сервер | `localhost` |
| `MAIL_PORT` | SMTP порт | `1025` |
| `TELEGRAM_BOT_TOKEN` | токен бота | пусто |
| `TELEGRAM_CHAT_ID` | chat id каналу/юзера | пусто |
| `VIBER_AUTH_TOKEN` | токен Public Account | пусто |

## Railway деплой
1. Прив'яжіть репозиторій до Railway.
2. Railway автоматично побудує Docker через `Dockerfile` або Spring Boot buildpack (`./mvnw spring-boot:build-image`).
3. Додайте Railway Postgres/Redis аддони; змінні `DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`, `REDIS_URL` зчитуються автоматично.
4. Налаштуйте секректи `MAIL_*`, `TELEGRAM_*`, `VIBER_*` у Dashboard → Variables.
5. Health-check → `/actuator/health`. Railway PORT надається через `PORT` env (Spring вже читає).

### Зберігання медіа (MinIO)
- Увімкнення: `MINIO_ENABLED=true` (за замовчуванням вимкнено в проді).
- Обов'язкові змінні:
  - `MINIO_PRIVATE_ENDPOINT` — приватний SDK endpoint (наприклад, `https://minio.example.com`).
  - `MINIO_PUBLIC_ENDPOINT` — публічний CDN/endpoint для формування URL.
  - `MINIO_BUCKET` — назва бакету, напр. `media`.
  - `MINIO_ROOT_USER` — access key.
  - `MINIO_ROOT_PASSWORD` — secret key.
  - `MINIO_REGION` — (опційно) регіон.
- Ендпоїнти:
  - `POST /api/admin/media/upload` — multipart `file`, опційно `folder`; повертає `{ url }`.
  - `DELETE /api/admin/media/delete` — `key` або `url`.
- Примітка: якщо `MINIO_ENABLED=false` або креденшли відсутні — стартує DisabledStorageService, і медіа-операції повернуть 500.

## Модулі
- `/api/catalog` — публічний каталог (ін меморі stub, готовий до JPA).
- `/api/orders` — створення wizard-сесії та підтвердження бронювання (генерує нотифікації).
- `/api/auth` — тимчасовий логін (static admin пароль з `app.admin.password`).
- `/api/admin/catalog` — додавання/перелік пропозицій (доповнює каталог).

## Роадмап
- [x] Перенести InMemory сервіси на JPA/PostgreSQL.
- [ ] Реалізувати JWT та рольову модель для `/api/admin/**`.
- [ ] Додати Webhook інтеграції з CRM / платежами.
- [ ] Створити Testcontainers сценарії (Postgres + Redis) для інтеграційних тестів.