-- Seed initial tour proposals - Карпатські тури
INSERT INTO tour_proposals (slug, title, tagline, city, country, duration_days, price_from, hero_image_url, created_at, updated_at)
VALUES
    ('carpathian-peaks', 'Вершини Карпат', 'Підкорення найвищих гір України', 'Яремче', 'Україна', 5, 3200.00, 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4', NOW(), NOW()),
    ('bukovel-winter', 'Зимова казка Буковелю', 'Гірськолижний рай у серці Карпат', 'Буковель', 'Україна', 4, 5800.00, 'https://images.unsplash.com/photo-1551698618-1dfe5d97d256', NOW(), NOW()),
    ('carpathian-wellness', 'Карпатська оздоровча відпустка', 'Термальні джерела та гірське повітря', 'Закарпаття', 'Україна', 6, 4500.00, 'https://images.unsplash.com/photo-1540555700478-4be289fbecef', NOW(), NOW()),
    ('carpathian-adventure', 'Екстрим у Карпатах', 'Рафтінг, скелелазіння та зіплайн', 'Мукачево', 'Україна', 3, 2900.00, 'https://images.unsplash.com/photo-1533130061792-64b345e4a833', NOW(), NOW()),
    ('carpathian-culture', 'Гуцульська спадщина', 'Традиції, ремесла та автентична кухня', 'Косів', 'Україна', 5, 3500.00, 'https://images.unsplash.com/photo-1464207687429-7505649dae38', NOW(), NOW());

-- Seed tags for tour proposals
INSERT INTO tour_proposal_tags (tour_proposal_id, tag)
SELECT id, 'Гори' FROM tour_proposals WHERE slug = 'carpathian-peaks'
UNION ALL
SELECT id, 'Треккінг' FROM tour_proposals WHERE slug = 'carpathian-peaks'
UNION ALL
SELECT id, 'Природа' FROM tour_proposals WHERE slug = 'carpathian-peaks'
UNION ALL
SELECT id, 'Зима' FROM tour_proposals WHERE slug = 'bukovel-winter'
UNION ALL
SELECT id, 'Лижі' FROM tour_proposals WHERE slug = 'bukovel-winter'
UNION ALL
SELECT id, 'Сімейний' FROM tour_proposals WHERE slug = 'bukovel-winter'
UNION ALL
SELECT id, 'Wellness' FROM tour_proposals WHERE slug = 'carpathian-wellness'
UNION ALL
SELECT id, 'Релакс' FROM tour_proposals WHERE slug = 'carpathian-wellness'
UNION ALL
SELECT id, 'Здоров''я' FROM tour_proposals WHERE slug = 'carpathian-wellness'
UNION ALL
SELECT id, 'Екстрим' FROM tour_proposals WHERE slug = 'carpathian-adventure'
UNION ALL
SELECT id, 'Адреналін' FROM tour_proposals WHERE slug = 'carpathian-adventure'
UNION ALL
SELECT id, 'Активний' FROM tour_proposals WHERE slug = 'carpathian-adventure'
UNION ALL
SELECT id, 'Культура' FROM tour_proposals WHERE slug = 'carpathian-culture'
UNION ALL
SELECT id, 'Гастро' FROM tour_proposals WHERE slug = 'carpathian-culture'
UNION ALL
SELECT id, 'Автентика' FROM tour_proposals WHERE slug = 'carpathian-culture';
