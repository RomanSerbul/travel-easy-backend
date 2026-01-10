-- Seed new Carpathian group tours (Mikulichin, Vorokhta, Yaremche, Synevyrska Polyana)

-- Mikulichin
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    departure_date, return_date, min_guests, max_guests, hot, status,
    created_at, updated_at
) VALUES (
    'mikulichin-group-tour',
    'Групова екскурсія в Микуличин',
    'Автентичне карпатське село, природа та гуцульські традиції',
    'Микуличин',
    'Україна',
    3,
    6000.00,
    'https://images.unsplash.com/photo-1501785888041-af3ef285b470?auto=format&fit=crop&w=1600&q=80',
    'Микуличин — мальовниче карпатське село в долині Пруту. Ви зануритесь у гуцульські традиції, побачите водоспади й панорами, відчуєте атмосферу сільського життя та активного відпочинку.',
    'Проживання у комфортних номерах зручностей
Три сніданки, дві вечері
Проїзд комфортабельним автобусом
Трансфер по маршруту
Супровід професійного гіда
Насичена екскурсійна програма
Організаційний супровід групи',
    'Вхідні квитки
Майстер-класи
Джипи, коні, чани
Дегустації
Особисті витрати',
    'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    NULL,
    NULL,
    15,
    20,
    FALSE,
    'PLANNED',
    NOW(),
    NOW()
);

-- Vorokhta
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    departure_date, return_date, min_guests, max_guests, hot, status,
    created_at, updated_at
) VALUES (
    'vorokhta-group-tour',
    'Групова екскурсія у Ворохту',
    'Віадуки, панорами та гуцульська атмосфера',
    'Ворохта',
    'Україна',
    3,
    6000.00,
    'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1600&q=80',
    'Ворохта — серце Гуцульщини з віадуками, гірськими пейзажами та легендами. Активи, кінні прогулянки, джип-тури, нова локація «Феєрія карпатського духу» й насичена культурна програма.',
    'Комфортне проживання
Гуцульська кухня (сніданки/вечері)
Екскурсії Ворохтою, віадуки, трамплін
Відвідування приватного музею «Феєрія карпатського духу»
Трансфер по маршруту та супровід гіда
Організаційний супровід групи',
    'Вхідні квитки
Майстер-класи
Джипи, чани, коні, квадроцикли
Дегустації
Особисті витрати',
    'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    NULL,
    NULL,
    15,
    20,
    FALSE,
    'PLANNED',
    NOW(),
    NOW()
);

-- Yaremche
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    departure_date, return_date, min_guests, max_guests, hot, status,
    created_at, updated_at
) VALUES (
    'yaremche-group-tour',
    'Групова подорож до Яремче',
    'Водоспад Пробій, стежка Довбуша та гуцульський колорит',
    'Яремче',
    'Україна',
    3,
    6000.00,
    'https://images.unsplash.com/photo-1470246973918-29a93221c455?auto=format&fit=crop&w=1600&q=80',
    'Яремче — перлина Карпат: водоспад Пробій, сувенірний ринок, стежка Довбуша, нова гойдалка над Пробоєм та природа поруч із Буковелем. Поєднання активностей, культури та гастрономії.',
    'Проживання у комфортних номерах
Гуцульська кухня (сніданки/вечері)
Екскурсії: Пробій, стежка Довбуша, музей «Карпати в мініатюрі»
Відвідування гойдалки над водоспадом Пробій
Трансфер по маршруту; супровід гіда
Організаційний супровід групи',
    'Вхідні квитки
Майстер-класи
Джипи, чани, коні, дегустації
Особисті витрати',
    'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    NULL,
    NULL,
    15,
    20,
    FALSE,
    'PLANNED',
    NOW(),
    NOW()
);

-- Synevyrska Polyana
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    departure_date, return_date, min_guests, max_guests, hot, status,
    created_at, updated_at
) VALUES (
    'synevyrska-polyana-group-tour',
    'Групова подорож до Синевирської Поляни',
    'Озеро Синевир, ведмежий центр та екостежки',
    'Синевирська Поляна',
    'Україна',
    3,
    6000.00,
    'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1600&q=80',
    'Синевирська Поляна — серце Нацпарку «Синевир»: озеро Синевир, реабілітаційний центр бурого ведмедя, Шипіт, підйоми на Гимбу і Босничку, дегустації закарпатських страв.',
    'Проживання у комфортних номерах
Гуцульська/закарпатська кухня (сніданки/вечері)
Екскурсії: озеро Синевир, ведмежий центр, Шипіт, підйом на Гимбу
Екостежки та прогулянки нацпарком
Трансфер по маршруту; супровід гіда
Організаційний супровід групи',
    'Вхідні квитки
Майстер-класи
Джипи, чани, коні, дегустації
Особисті витрати',
    'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    NULL,
    NULL,
    15,
    20,
    FALSE,
    'PLANNED',
    NOW(),
    NOW()
);

-- Tags
INSERT INTO tour_proposal_tags (tour_proposal_id, tag)
SELECT id, t.tag FROM tour_proposals tp
JOIN (
    VALUES
        ('mikulichin-group-tour', 'Карпати'),
        ('mikulichin-group-tour', 'Група'),
        ('mikulichin-group-tour', 'Активний відпочинок'),
        ('mikulichin-group-tour', 'Культура'),
        ('mikulichin-group-tour', 'Природа'),
        ('vorokhta-group-tour', 'Карпати'),
        ('vorokhta-group-tour', 'Група'),
        ('vorokhta-group-tour', 'Віадуки'),
        ('vorokhta-group-tour', 'Активний відпочинок'),
        ('vorokhta-group-tour', 'Культура'),
        ('yaremche-group-tour', 'Карпати'),
        ('yaremche-group-tour', 'Група'),
        ('yaremche-group-tour', 'Водоспад'),
        ('yaremche-group-tour', 'Гойдалка'),
        ('yaremche-group-tour', 'Культура'),
        ('synevyrska-polyana-group-tour', 'Карпати'),
        ('synevyrska-polyana-group-tour', 'Група'),
        ('synevyrska-polyana-group-tour', 'Озеро'),
        ('synevyrska-polyana-group-tour', 'Природа'),
        ('synevyrska-polyana-group-tour', 'Еко')
) AS t(slug, tag) ON tp.slug = t.slug;

-- Images
INSERT INTO tour_proposal_images (tour_proposal_id, image_url)
SELECT id, img.url FROM tour_proposals tp
JOIN (
    VALUES
        ('mikulichin-group-tour', 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80'),
        ('mikulichin-group-tour', 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80'),
        ('mikulichin-group-tour', 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80'),
        ('mikulichin-group-tour', 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80'),
        ('vorokhta-group-tour', 'https://images.unsplash.com/photo-1470246973918-29a93221c455?auto=format&fit=crop&w=1200&q=80'),
        ('vorokhta-group-tour', 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80'),
        ('vorokhta-group-tour', 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80'),
        ('vorokhta-group-tour', 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80'),
        ('yaremche-group-tour', 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80'),
        ('yaremche-group-tour', 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80'),
        ('yaremche-group-tour', 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80'),
        ('yaremche-group-tour', 'https://images.unsplash.com/photo-1470246973918-29a93221c455?auto=format&fit=crop&w=1200&q=80'),
        ('synevyrska-polyana-group-tour', 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80'),
        ('synevyrska-polyana-group-tour', 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80'),
        ('synevyrska-polyana-group-tour', 'https://images.unsplash.com/photo-1470246973918-29a93221c455?auto=format&fit=crop&w=1200&q=80'),
        ('synevyrska-polyana-group-tour', 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80')
) AS img(slug, url) ON tp.slug = img.slug;
