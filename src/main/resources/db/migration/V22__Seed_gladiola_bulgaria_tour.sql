-- Seed: Болгарія, Gladiola молодіжний центр, Золоті Піски, All Inclusive

INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    program_details, difficulty_level, target_audience,
    departure_locations,
    departure_date, return_date, min_guests, max_guests, hot, status,
    created_at, updated_at
) VALUES (
    'gladiola-golden-sands-bulgaria',
    'Болгарія – Gladiola, Золоті Піски',
    'Молодіжний центр на першій лінії, All Inclusive, анімація та пляж',
    'Золоті Піски',
    'Болгарія',
    12,
    395.00,
    'https://images.unsplash.com/photo-1568702846914-96b305d2aaeb?auto=format&fit=crop&w=1600&q=80',
    'Молодіжний центр Gladiola у Золотих Пісках, Болгарія — готель на першій лінії від моря, всього 50 м до пляжу! Сучасні 3-місні номери з телевізором, санвузлом, балконом та кондиціонером. Чотириразове харчування за системою All Inclusive (шведський стіл) — сніданок, обід, вечеря та снеки. Безалкогольні напої для дітей на Pool-барі з 10:30 до 18:00. Для дорослих безалкогольні та алкогольні напої з 10:30 до 22:30 в Лоббі барі. Ресторан з відкритою терасою — страви болгарської та європейської кухні. Цілоденна анімаційна програма для дітей різного віку: розваги на басейні, пляжі, тихі ігри та заняття в конференц-залі, вечірні дискотеки. Можливе розміщення дітей разом з батьками — батьки та дорослі у підрахунок не входять. Тривалість відпочинку можна обрати за запитом — 7, 9, 10 або 12 ночей. Безкоштовне місце для керівника надається при супроводі групи дітей.',
    'Проїзд з України до табору та назад (через Одесу або Чернівці, є варіанти виїзду з різних міст)
Проживання в комфортабельних номерах по 3 особи
Різноманітне харчування All Inclusive (сніданок, обід, вечеря та снеки, алкогольні напої для дорослих)
Анімаційна програма протягом дня
Басейни із шезлонгами
Безкоштовний сейф для керівника
24-х годинне медичне обслуговування лікарем (при наявності туристичного страхування)
Цілодобове відеоспостереження комплексу
Конференс зал для проведення занять
Курортний збір
Комплексна підтримка наших менеджерів',
    'Медичне туристичне страхування
Депозит (повертається при відсутності пошкоджень майна)
Екскурсії та додаткові заходи
Трансфер по курорту до табору (якщо в групі менше ніж 16 осіб)
Додатковий сніданок у день приїзду / ланч бокс у день від''їзду — 6 євро
Додатковий обід у день від''їзду — 10 євро',
    'Пропозиція дійсна за умови внесення першого платіжу протягом 14 днів після підтвердження заявки
Завдаток 50 € з особи
Тривалість відпочинку можна обрати за запитом — 7, 9, 10 або 12 ночей
Ціни вказані в євро на людину
Безкоштовне місце для керівника при супроводі групи дітей (15+1 або 15+2 / 10+1)',
    'День 1: Виїзд з України, комфортний переїзд автобусом через Одесу або Чернівці. День 2: Прибуття до Золотих Пісків, заселення в молодіжний центр Gladiola, знайомство з територією, басейн. День 3–11: Повноцінний відпочинок — All Inclusive харчування, щоденна анімаційна програма (басейн, пляж, танці, тихі ігри, конкурси), вільний час для екскурсій та прогулянок по курорту Золоті Піски. День 12: Виселення, від''їзд, повернення в Україну.',
    'Легкий',
    'Діти та підлітки, молодіжні групи, сім''ї з дітьми (можливе розміщення батьків разом із дітьми), керівники груп',
    'Виїзд з різних міст України — через Одесу або Чернівці',
    '2026-06-02',
    '2026-06-13',
    10,
    30,
    true,
    'ACTIVE',
    NOW(),
    NOW()
);

-- Tags
INSERT INTO tour_proposal_tags (tour_proposal_id, tag)
SELECT id, 'Болгарія' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Море' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'All Inclusive' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Група' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Анімація' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Діти' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Пляж' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria';

-- Images (placeholder — замінити на реальні через адмін-панель)
INSERT INTO tour_proposal_images (tour_proposal_id, image_url)
SELECT id, 'https://images.unsplash.com/photo-1568702846914-96b305d2aaeb?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1507525428034-b723cf961d3e?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1540541338287-41700207dee6?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1571896349842-33c89424de2d?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria';

-- Attractions
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Пляж Золоті Піски (50 м від готелю)' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Курорт Золоті Піски' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Відкриті басейни з дитячою секцією' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Ресторан з відкритою терасою' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Конференс зал та лоббі бар' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria';

-- Activities
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Анімаційна програма на пляжі та басейні' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Вечірні дискотеки' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Тихі ігри та заняття в конференц-залі' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Купання в басейнах та на морі' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Екскурсії по курорту (додатково)' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria';

-- Highlights
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Готель на першій лінії — 50 м до пляжу' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'All Inclusive: 4-разове харчування + напої' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Цілоденна анімація для дітей будь-якого віку' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Можливе розміщення дітей разом з батьками' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria'
UNION ALL SELECT id, 'Безкоштовне місце для керівника групи' FROM tour_proposals WHERE slug = 'gladiola-golden-sands-bulgaria';
