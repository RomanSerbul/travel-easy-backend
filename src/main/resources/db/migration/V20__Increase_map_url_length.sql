-- Збільшуємо довжину поля address_map_url для довгих Google Maps embed URL
ALTER TABLE site_settings ALTER COLUMN address_map_url TYPE TEXT;
