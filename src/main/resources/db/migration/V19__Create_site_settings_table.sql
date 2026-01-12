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
    address_city,
    address_country,
    phone_numbers,
    social_instagram,
    social_telegram,
    working_hours_weekdays,
    working_hours_saturday,
    working_hours_sunday,
    currency,
    currency_symbol,
    seo_title,
    seo_description
) VALUES (
    'main',
    'Travel Easy',
    'info@easy-travel.com.ua',
    'Київ',
    'Україна',
    '[]',
    'https://instagram.com/traveleasy',
    'https://t.me/traveleasy',
    '09:00 - 18:00',
    '10:00 - 16:00',
    'Вихідний',
    'UAH',
    '₴',
    'Travel Easy - Подорожуй легко',
    'Туристичне агентство Travel Easy. Найкращі тури по Україні та за кордон.'
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
