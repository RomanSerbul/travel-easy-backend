-- Seed initial tour proposals
INSERT INTO tour_proposals (slug, title, tagline, city, country, duration_days, price_from, hero_image_url, created_at, updated_at)
VALUES
    ('lisbon-weekend', 'Weekend у Лісабоні', 'Сонячний втеча до Атлантики', 'Лісабон', 'Португалія', 4, 480.00, 'https://images.unsplash.com/photo-1467269204594-9661b134dd2b', NOW(), NOW()),
    ('copenhagen-hygge', 'Фйорди та хюґе', 'Скандинавський комфорт та гастрономія', 'Копенгаген', 'Данія', 5, 640.00, 'https://images.unsplash.com/photo-1512453979798-5ea266f8880c', NOW(), NOW()),
    ('istanbul-senses', 'Стамбул: смак Сходу', 'Культури, спеції та ринки', 'Стамбул', 'Туреччина', 6, 520.00, 'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee', NOW(), NOW());

-- Seed tags for tour proposals
INSERT INTO tour_proposal_tags (tour_proposal_id, tag)
SELECT id, 'Море' FROM tour_proposals WHERE slug = 'lisbon-weekend'
UNION ALL
SELECT id, 'Сонце' FROM tour_proposals WHERE slug = 'lisbon-weekend'
UNION ALL
SELECT id, 'Бар' FROM tour_proposals WHERE slug = 'lisbon-weekend'
UNION ALL
SELECT id, 'Північ' FROM tour_proposals WHERE slug = 'copenhagen-hygge'
UNION ALL
SELECT id, 'Гастро' FROM tour_proposals WHERE slug = 'copenhagen-hygge'
UNION ALL
SELECT id, 'Гастро' FROM tour_proposals WHERE slug = 'istanbul-senses'
UNION ALL
SELECT id, 'Прогулянки' FROM tour_proposals WHERE slug = 'istanbul-senses';
