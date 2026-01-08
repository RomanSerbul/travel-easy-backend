ALTER TABLE tour_proposals
    ADD COLUMN description TEXT DEFAULT '' NOT NULL,
    ADD COLUMN includes TEXT DEFAULT '' NOT NULL,
    ADD COLUMN exclusions TEXT DEFAULT '' NOT NULL,
    ADD COLUMN policy TEXT DEFAULT '' NOT NULL;

-- Seed richer descriptions for existing tours
UPDATE tour_proposals SET
    description = 'Яскравий вікенд із прогулянками трамваями, океанськими видами та пастейш де ната.',
    includes = 'Переліт туди/назад\n4 ночі готелю в центрі\nСніданки\nТрансфер аеропорт-готель\nПідтримка 24/7',
    exclusions = 'Віза\nОсобисті витрати\nДодаткові екскурсії',
    policy = 'Безкоштовне скасування за 7 днів до виїзду'
WHERE slug = 'lisbon-weekend';

UPDATE tour_proposals SET
    description = 'Скандинавський хюґе з каналами, кавою та дизайном.',
    includes = 'Переліт туди/назад\n5 ночей готелю у Нюгауні\nСніданки\nТрансфер\nПідтримка 24/7',
    exclusions = 'Віза\nОсобисті витрати\nДодаткові екскурсії',
    policy = 'Безкоштовне скасування за 10 днів'
WHERE slug = 'copenhagen-hygge';

UPDATE tour_proposals SET
    description = 'Східні базари, спеції, прогулянки Босфором і кавові ритуали.',
    includes = 'Переліт туди/назад\n6 ночей готелю у Султанахметі\nСніданки\nТрансфер\nПідтримка 24/7',
    exclusions = 'Віза (якщо потрібна)\nОсобисті витрати\nПлатні вхідні квитки',
    policy = 'Безкоштовне скасування за 5 днів'
WHERE slug = 'istanbul-senses';
