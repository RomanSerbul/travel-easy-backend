-- Додаємо поле валюти до tour_proposals (дефолт ₴ для існуючих турів)
ALTER TABLE tour_proposals ADD COLUMN currency VARCHAR(10) NOT NULL DEFAULT '₴';

-- Болгарський тур — ціна в євро
UPDATE tour_proposals SET currency = '€' WHERE slug = 'gladiola-golden-sands-bulgaria';
