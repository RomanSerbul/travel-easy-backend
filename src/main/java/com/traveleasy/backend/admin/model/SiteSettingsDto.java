package com.traveleasy.backend.admin.model;

import java.util.List;

/**
 * DTO для передачі налаштувань сайту
 */
public record SiteSettingsDto(
    Long id,
    
    // Контактна інформація
    String companyName,
    String email,
    String secondaryEmail,
    
    // Адреса
    AddressDto address,
    
    // Телефони
    List<String> phoneNumbers,
    
    // Соціальні мережі
    SocialLinksDto socialLinks,
    
    // Робочі години
    WorkingHoursDto workingHours,
    
    // SEO налаштування
    SeoSettingsDto seo,
    
    // Загальні налаштування
    GeneralSettingsDto general,
    
    // Функціональні налаштування
    FunctionalSettingsDto functional,
    
    // Юридична інформація
    LegalInfoDto legal,
    
    // Брендинг
    BrandingDto branding
) {
    public record AddressDto(
        String street,
        String city,
        String region,
        String postalCode,
        String country,
        String mapUrl
    ) {}

    public record SocialLinksDto(
        String facebook,
        String instagram,
        String telegram,
        String viber,
        String youtube,
        String tiktok
    ) {}

    public record WorkingHoursDto(
        String weekdays,
        String saturday,
        String sunday,
        String holidays
    ) {}

    public record SeoSettingsDto(
        String title,
        String description,
        String keywords,
        String ogImage
    ) {}

    public record GeneralSettingsDto(
        String currency,
        String currencySymbol,
        String defaultLanguage,
        String timezone
    ) {}

    public record FunctionalSettingsDto(
        Boolean bookingEnabled,
        Boolean showPrices,
        Boolean requirePhoneVerification,
        Integer minBookingAdvanceDays,
        Integer maxBookingAdvanceDays
    ) {}

    public record LegalInfoDto(
        String companyName,
        String code,
        String vatNumber
    ) {}

    public record BrandingDto(
        String logoUrl,
        String faviconUrl,
        String primaryColor
    ) {}

    /**
     * Конвертує Entity в DTO
     */
    public static SiteSettingsDto fromEntity(SiteSettings entity) {
        return new SiteSettingsDto(
            entity.getId(),
            entity.getCompanyName(),
            entity.getEmail(),
            entity.getSecondaryEmail(),
            new AddressDto(
                entity.getAddressStreet(),
                entity.getAddressCity(),
                entity.getAddressRegion(),
                entity.getAddressPostalCode(),
                entity.getAddressCountry(),
                entity.getAddressMapUrl()
            ),
            entity.getPhoneNumbers(),
            new SocialLinksDto(
                entity.getSocialFacebook(),
                entity.getSocialInstagram(),
                entity.getSocialTelegram(),
                entity.getSocialViber(),
                entity.getSocialYoutube(),
                entity.getSocialTiktok()
            ),
            new WorkingHoursDto(
                entity.getWorkingHoursWeekdays(),
                entity.getWorkingHoursSaturday(),
                entity.getWorkingHoursSunday(),
                entity.getWorkingHoursHolidays()
            ),
            new SeoSettingsDto(
                entity.getSeoTitle(),
                entity.getSeoDescription(),
                entity.getSeoKeywords(),
                entity.getSeoOgImage()
            ),
            new GeneralSettingsDto(
                entity.getCurrency(),
                entity.getCurrencySymbol(),
                entity.getDefaultLanguage(),
                entity.getTimezone()
            ),
            new FunctionalSettingsDto(
                entity.getBookingEnabled(),
                entity.getShowPrices(),
                entity.getRequirePhoneVerification(),
                entity.getMinBookingAdvanceDays(),
                entity.getMaxBookingAdvanceDays()
            ),
            new LegalInfoDto(
                entity.getLegalCompanyName(),
                entity.getLegalCode(),
                entity.getLegalVatNumber()
            ),
            new BrandingDto(
                entity.getLogoUrl(),
                entity.getFaviconUrl(),
                entity.getPrimaryColor()
            )
        );
    }

    /**
     * Оновлює Entity з DTO
     */
    public void applyToEntity(SiteSettings entity) {
        entity.setCompanyName(this.companyName);
        entity.setEmail(this.email);
        entity.setSecondaryEmail(this.secondaryEmail);
        
        if (this.address != null) {
            entity.setAddressStreet(this.address.street);
            entity.setAddressCity(this.address.city);
            entity.setAddressRegion(this.address.region);
            entity.setAddressPostalCode(this.address.postalCode);
            entity.setAddressCountry(this.address.country);
            entity.setAddressMapUrl(this.address.mapUrl);
        }
        
        entity.setPhoneNumbers(this.phoneNumbers != null ? this.phoneNumbers : List.of());
        
        if (this.socialLinks != null) {
            entity.setSocialFacebook(this.socialLinks.facebook);
            entity.setSocialInstagram(this.socialLinks.instagram);
            entity.setSocialTelegram(this.socialLinks.telegram);
            entity.setSocialViber(this.socialLinks.viber);
            entity.setSocialYoutube(this.socialLinks.youtube);
            entity.setSocialTiktok(this.socialLinks.tiktok);
        }
        
        if (this.workingHours != null) {
            entity.setWorkingHoursWeekdays(this.workingHours.weekdays);
            entity.setWorkingHoursSaturday(this.workingHours.saturday);
            entity.setWorkingHoursSunday(this.workingHours.sunday);
            entity.setWorkingHoursHolidays(this.workingHours.holidays);
        }
        
        if (this.seo != null) {
            entity.setSeoTitle(this.seo.title);
            entity.setSeoDescription(this.seo.description);
            entity.setSeoKeywords(this.seo.keywords);
            entity.setSeoOgImage(this.seo.ogImage);
        }
        
        if (this.general != null) {
            entity.setCurrency(this.general.currency);
            entity.setCurrencySymbol(this.general.currencySymbol);
            entity.setDefaultLanguage(this.general.defaultLanguage);
            entity.setTimezone(this.general.timezone);
        }
        
        if (this.functional != null) {
            entity.setBookingEnabled(this.functional.bookingEnabled);
            entity.setShowPrices(this.functional.showPrices);
            entity.setRequirePhoneVerification(this.functional.requirePhoneVerification);
            entity.setMinBookingAdvanceDays(this.functional.minBookingAdvanceDays);
            entity.setMaxBookingAdvanceDays(this.functional.maxBookingAdvanceDays);
        }
        
        if (this.legal != null) {
            entity.setLegalCompanyName(this.legal.companyName);
            entity.setLegalCode(this.legal.code);
            entity.setLegalVatNumber(this.legal.vatNumber);
        }
        
        if (this.branding != null) {
            entity.setLogoUrl(this.branding.logoUrl);
            entity.setFaviconUrl(this.branding.faviconUrl);
            entity.setPrimaryColor(this.branding.primaryColor);
        }
    }
}
