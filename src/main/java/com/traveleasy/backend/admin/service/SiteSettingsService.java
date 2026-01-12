package com.traveleasy.backend.admin.service;

import com.traveleasy.backend.admin.model.SiteSettings;
import com.traveleasy.backend.admin.model.SiteSettingsDto;
import com.traveleasy.backend.admin.repository.SiteSettingsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SiteSettingsService {

    private final SiteSettingsRepository repository;

    public SiteSettingsService(SiteSettingsRepository repository) {
        this.repository = repository;
    }

    /**
     * Отримує основні налаштування сайту
     */
    @Transactional(readOnly = true)
    public SiteSettingsDto getSettings() {
        SiteSettings settings = repository.findMain()
            .orElseGet(this::createDefaultSettings);
        return SiteSettingsDto.fromEntity(settings);
    }

    /**
     * Оновлює налаштування сайту
     */
    @Transactional
    public SiteSettingsDto updateSettings(SiteSettingsDto dto) {
        SiteSettings settings = repository.findMain()
            .orElseGet(this::createDefaultSettings);
        
        dto.applyToEntity(settings);
        SiteSettings saved = repository.save(settings);
        
        return SiteSettingsDto.fromEntity(saved);
    }

    /**
     * Створює налаштування за замовчуванням, якщо вони не існують
     */
    private SiteSettings createDefaultSettings() {
        SiteSettings settings = new SiteSettings();
        settings.setSettingKey("main");
        settings.setCompanyName("Travel Easy");
        settings.setEmail("info@easy-travel.com.ua");
        settings.setAddressCity("Київ");
        settings.setAddressCountry("Україна");
        settings.setCurrency("UAH");
        settings.setCurrencySymbol("₴");
        settings.setDefaultLanguage("uk");
        settings.setTimezone("Europe/Kyiv");
        settings.setBookingEnabled(true);
        settings.setShowPrices(true);
        return repository.save(settings);
    }
}
