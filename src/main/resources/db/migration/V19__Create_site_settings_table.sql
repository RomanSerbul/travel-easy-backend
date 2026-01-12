-- Site Settings Table
-- Таблиця для зберігання загальних налаштувань сайту

CREATE TABLE site_settings (
    id BIGSERIAL PRIMARY KEY,
    setting_key VARCHAR(100) UNIQUE NOT NULL,
    
    -- Контактна інформація
    company_name VARCHAR(255),
    email VARCHAR(255),
    secondary_email VARCHAR(255),
    
    -- Адреса
    address_street VARCHAR(255),
    address_city VARCHAR(100),
    address_region VARCHAR(100),
    address_postal_code VARCHAR(20),
    address_country VARCHAR(100),
    address_map_url TEXT,
    
    -- Телефони (зберігаємо як JSON масив)
    phone_numbers JSONB DEFAULT '[]',
    
    -- Соціальні мережі
    social_facebook VARCHAR(500),
    social_instagram VARCHAR(500),
    social_telegram VARCHAR(500),
    social_viber VARCHAR(500),
    social_youtube VARCHAR(500),
    social_tiktok VARCHAR(500),
    
    -- Робочі години
    working_hours_weekdays VARCHAR(100),
    working_hours_saturday VARCHAR(100),
    working_hours_sunday VARCHAR(100),
    working_hours_holidays VARCHAR(100),
    
    -- SEO налаштування
    seo_title VARCHAR(255),
    seo_description TEXT,
    seo_keywords TEXT,
    seo_og_image VARCHAR(500),
    
    -- Загальні налаштування
    currency VARCHAR(10) DEFAULT 'UAH',
    currency_symbol VARCHAR(5) DEFAULT '₴',
    default_language VARCHAR(10) DEFAULT 'uk',
    timezone VARCHAR(50) DEFAULT 'Europe/Kyiv',
    
    -- Функціональні налаштування
    booking_enabled BOOLEAN DEFAULT TRUE,
    show_prices BOOLEAN DEFAULT TRUE,
    require_phone_verification BOOLEAN DEFAULT FALSE,
    min_booking_advance_days INTEGER DEFAULT 1,
    max_booking_advance_days INTEGER DEFAULT 365,
    
    -- Юридична інформація
    legal_company_name VARCHAR(255),
    legal_code VARCHAR(50),
    legal_vat_number VARCHAR(50),
    
    -- Брендинг
    logo_url VARCHAR(500),
    favicon_url VARCHAR(500),
    primary_color VARCHAR(20) DEFAULT '#5BC5FF',
    
    -- Мета-дані
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

-- Створюємо запис за замовчуванням
INSERT INTO site_settings (
    setting_key,
    company_name,
    email,
    secondary_email,
    address_street,
    address_city,
    address_region,
    address_postal_code,
    address_country,
    address_map_url,
    phone_numbers,
    social_facebook,
    social_instagram,
    social_telegram,
    social_viber,
    working_hours_weekdays,
    working_hours_saturday,
    working_hours_sunday,
    working_hours_holidays,
    currency,
    currency_symbol,
    seo_title,
    seo_description,
    seo_keywords,
    booking_enabled,
    show_prices
) VALUES (
    'main',
    'Travel Easy',
    'info@easy-travel.com.ua',
    'support@easy-travel.com.ua',
    'вул. Хрещатик, 1, офіс 501',
    'Київ',
    'Метро Хрещатик, 5 хв пішки',
    '01001',
    'Україна',
    'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2540.5768893565746!2d30.52194731573085!3d50.44966897947464!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4ce50f8b6e3c3%3A0xb528dc4d6dadc4f8!2z0YPQuy4g0KXRgNC10YnQsNGC0LjQuiwgMSwg0JrQuNC10LIsIDAyMDAw!5e0!3m2!1suk!2sua!4v1650000000000!5m2!2suk!1sua',
    '["+380 44 123-45-67", "+380 67 123-45-67"]',
    'https://facebook.com/traveleasyua',
    'https://instagram.com/traveleasy.ua',
    'https://t.me/traveleasy_ua',
    'viber://chat?number=380671234567',
    '09:00 - 18:00',
    '10:00 - 16:00',
    'Вихідний',
    'Вихідний',
    'UAH',
    '₴',
    'Travel Easy - Подорожуй легко | Тури по Україні та за кордон',
    'Туристичне агентство Travel Easy. Найкращі групові та індивідуальні тури по Карпатах, Україні та за кордон. Бронюйте онлайн!',
    'тури, подорожі, відпочинок, карпати, україна, групові тури, екскурсії, туристичне агентство',
    TRUE,
    TRUE
);

-- Індекс для швидкого пошуку
CREATE INDEX idx_site_settings_key ON site_settings(setting_key);

-- Тригер для оновлення updated_at
CREATE OR REPLACE FUNCTION update_site_settings_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_site_settings_updated_at
    BEFORE UPDATE ON site_settings
    FOR EACH ROW
    EXECUTE FUNCTION update_site_settings_updated_at();
