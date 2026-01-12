-- Збільшуємо довжину поля map_url для довгих Google Maps embed URL
ALTER TABLE site_settings ALTER COLUMN map_url TYPE TEXT;
