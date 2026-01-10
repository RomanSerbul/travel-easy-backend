-- Seed new Carpathian group tours (Mikulichin, Vorokhta, Yaremche, Synevyrska Polyana)

-- Mikulichin
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    program_details, difficulty_level, target_audience,
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
    'День 1: Приїзд у Микуличин, знайомство з селом і його мешканцями. День 2: Екскурсії до водоспадів, похід на гору, відвідування музею. День 3: Активні розваги, вільний час, від''їзд.',
    'Легкий',
    'Сім''ї з дітьми, туристи будь-якого віку, люди, що бажають познайомитися з гуцульською культурою',
    NULL,
    NULL,
    15,
    20,
    false,
    'PLANNED',
    NOW(),
    NOW()
);

-- Vorokhta
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    program_details, difficulty_level, target_audience,
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
    'День 1: Приїзд, знайомство з віадуками та трамплін. День 2: Джип-тури, посещення музею «Феєрія», майстер-класи. День 3: Природні маршрути, вільний час, від''їзд.',
    'Легкий',
    'Туристи будь-якого віку, любителі історії та архітектури, шукачі адреналіну',
    NULL,
    NULL,
    15,
    20,
    false,
    'PLANNED',
    NOW(),
    NOW()
);

-- Yaremche
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    program_details, difficulty_level, target_audience,
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
    'День 1: Приїзд, гойдалка над Пробоєм, ринок. День 2: Стежка Довбуша, музей Карпат, дегустації. День 3: Активні розваги, природні локації, від''їзд.',
    'Легкий',
    'Сім''ї, любителі природи, фотографи, шукачі адреналіну',
    NULL,
    NULL,
    15,
    20,
    false,
    'PLANNED',
    NOW(),
    NOW()
);

-- Synevyrska Polyana
INSERT INTO tour_proposals (
    slug, title, tagline, city, country, duration_days, price_from,
    hero_image_url, description, includes, exclusions, policy,
    program_details, difficulty_level, target_audience,
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
    'День 1: Приїзд, озеро Синевир, прогулянка. День 2: Ведмежий центр, Шипіт, екостежки. День 3: Підйоми на гори, дегустації, від''їзд.',
    'Легкий',
    'Любителі природи, сім''ї, защитники тварин, шукачі спокою',
    NULL,
    NULL,
    15,
    20,
    false,
    'PLANNED',
    NOW(),
    NOW()
);

-- Tags
INSERT INTO tour_proposal_tags (tour_proposal_id, tag)
SELECT id, 'Карпати' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Група' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Активний відпочинок' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Культура' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Природа' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Карпати' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Група' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Віадуки' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Активний відпочинок' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Культура' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Карпати' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Група' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Водоспад' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Гойдалка' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Культура' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Карпати' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Група' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Озеро' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Природа' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Еко' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';

-- Images
INSERT INTO tour_proposal_images (tour_proposal_id, image_url)
SELECT id, 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1470246973918-29a93221c455?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1470246973918-29a93221c455?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500534314209-a25ddb2bd429?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1469474968028-56623f02e42e?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1470246973918-29a93221c455?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';

-- Attractions for Mikulichin
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Водоспад Женецький Гук' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Водоспад Капливець' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Озеро Несамовите' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Гора Маковиця' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Стежка Довбуша' FROM tour_proposals WHERE slug = 'mikulichin-group-tour';

-- Activities for Mikulichin
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Кінні прогулянки' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Джип-тури в гори' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Риболовля' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Квадроцикли' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Піші маршрути з гідом' FROM tour_proposals WHERE slug = 'mikulichin-group-tour';

-- Highlights for Mikulichin
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Автентична атмосфера карпатського села' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Захопливі панорами гір' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Можливість дегустувати місцеві продукти' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Спілкування з гідом про гуцульські легенди' FROM tour_proposals WHERE slug = 'mikulichin-group-tour';

-- Attractions for Vorokhta
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Австрійські віадуки' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Ворохтянський трамплін' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Карпатський нацпарк' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Дерев''яна церква Різдва Богородиці XVII ст.' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Музей «Феєрія карпатського духу»' FROM tour_proposals WHERE slug = 'vorokhta-group-tour';

-- Activities for Vorokhta
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Кінні прогулянки' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Джип-тури' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Квадроцикли' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Риболовля' FROM tour_proposals WHERE slug = 'vorokhta-group-tour';

-- Highlights for Vorokhta
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Інженерна архітектура віадуків' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Інтерактивна культурна програма' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Панорамні види Карпат' FROM tour_proposals WHERE slug = 'vorokhta-group-tour';

-- Attractions for Yaremche
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Водоспад Пробій' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Гойдалка над водоспадом' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Стежка Довбуша' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Сувенірний ринок' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Музей «Карпати в мініатюрі»' FROM tour_proposals WHERE slug = 'yaremche-group-tour';

-- Activities for Yaremche
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Кінні прогулянки' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Джип-тури' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Піші маршрути' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Фотосесії' FROM tour_proposals WHERE slug = 'yaremche-group-tour';

-- Highlights for Yaremche
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Найпотужніший водоспад Карпат' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Інста-гідна локація (гойдалка)' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Поєднання природи та активностей' FROM tour_proposals WHERE slug = 'yaremche-group-tour';

-- Attractions for Synevyrska Polyana
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Озеро Синевир' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Реабілітаційний центр бурого ведмедя' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Водоспад Шипіт' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Гора Гимба' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Гора Босничка' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';

-- Activities for Synevyrska Polyana
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Екостежки' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Прогулянки нацпарком' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Спостереження за дикою природою' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Дегустація закарпатських страв' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';

-- Highlights for Synevyrska Polyana
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Найбільше високогірне озеро України' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Програма захисту дикої природи' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Атмосфера спокою та гармонії' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';
