package com.traveleasy.backend.admin.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "site_settings")
public class SiteSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "setting_key", unique = true, nullable = false)
    private String settingKey = "main";

    // Контактна інформація
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "email")
    private String email;

    @Column(name = "secondary_email")
    private String secondaryEmail;

    // Адреса
    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_region")
    private String addressRegion;

    @Column(name = "address_postal_code")
    private String addressPostalCode;

    @Column(name = "address_country")
    private String addressCountry;

    @Column(name = "address_map_url", columnDefinition = "TEXT")
    private String addressMapUrl;

    // Телефони
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "phone_numbers", columnDefinition = "jsonb")
    private List<String> phoneNumbers = new ArrayList<>();

    // Соціальні мережі
    @Column(name = "social_facebook")
    private String socialFacebook;

    @Column(name = "social_instagram")
    private String socialInstagram;

    @Column(name = "social_telegram")
    private String socialTelegram;

    @Column(name = "social_viber")
    private String socialViber;

    @Column(name = "social_youtube")
    private String socialYoutube;

    @Column(name = "social_tiktok")
    private String socialTiktok;

    // Робочі години
    @Column(name = "working_hours_weekdays")
    private String workingHoursWeekdays;

    @Column(name = "working_hours_saturday")
    private String workingHoursSaturday;

    @Column(name = "working_hours_sunday")
    private String workingHoursSunday;

    @Column(name = "working_hours_holidays")
    private String workingHoursHolidays;

    // SEO налаштування
    @Column(name = "seo_title")
    private String seoTitle;

    @Column(name = "seo_description", columnDefinition = "TEXT")
    private String seoDescription;

    @Column(name = "seo_keywords", columnDefinition = "TEXT")
    private String seoKeywords;

    @Column(name = "seo_og_image")
    private String seoOgImage;

    // Загальні налаштування
    @Column(name = "currency")
    private String currency = "UAH";

    @Column(name = "currency_symbol")
    private String currencySymbol = "₴";

    @Column(name = "default_language")
    private String defaultLanguage = "uk";

    @Column(name = "timezone")
    private String timezone = "Europe/Kyiv";

    // Функціональні налаштування
    @Column(name = "booking_enabled")
    private Boolean bookingEnabled = true;

    @Column(name = "show_prices")
    private Boolean showPrices = true;

    @Column(name = "require_phone_verification")
    private Boolean requirePhoneVerification = false;

    @Column(name = "min_booking_advance_days")
    private Integer minBookingAdvanceDays = 1;

    @Column(name = "max_booking_advance_days")
    private Integer maxBookingAdvanceDays = 365;

    // Юридична інформація
    @Column(name = "legal_company_name")
    private String legalCompanyName;

    @Column(name = "legal_code")
    private String legalCode;

    @Column(name = "legal_vat_number")
    private String legalVatNumber;

    // Брендинг
    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "favicon_url")
    private String faviconUrl;

    @Column(name = "primary_color")
    private String primaryColor = "#5BC5FF";

    // Мета-дані
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressMapUrl() {
        return addressMapUrl;
    }

    public void setAddressMapUrl(String addressMapUrl) {
        this.addressMapUrl = addressMapUrl;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getSocialFacebook() {
        return socialFacebook;
    }

    public void setSocialFacebook(String socialFacebook) {
        this.socialFacebook = socialFacebook;
    }

    public String getSocialInstagram() {
        return socialInstagram;
    }

    public void setSocialInstagram(String socialInstagram) {
        this.socialInstagram = socialInstagram;
    }

    public String getSocialTelegram() {
        return socialTelegram;
    }

    public void setSocialTelegram(String socialTelegram) {
        this.socialTelegram = socialTelegram;
    }

    public String getSocialViber() {
        return socialViber;
    }

    public void setSocialViber(String socialViber) {
        this.socialViber = socialViber;
    }

    public String getSocialYoutube() {
        return socialYoutube;
    }

    public void setSocialYoutube(String socialYoutube) {
        this.socialYoutube = socialYoutube;
    }

    public String getSocialTiktok() {
        return socialTiktok;
    }

    public void setSocialTiktok(String socialTiktok) {
        this.socialTiktok = socialTiktok;
    }

    public String getWorkingHoursWeekdays() {
        return workingHoursWeekdays;
    }

    public void setWorkingHoursWeekdays(String workingHoursWeekdays) {
        this.workingHoursWeekdays = workingHoursWeekdays;
    }

    public String getWorkingHoursSaturday() {
        return workingHoursSaturday;
    }

    public void setWorkingHoursSaturday(String workingHoursSaturday) {
        this.workingHoursSaturday = workingHoursSaturday;
    }

    public String getWorkingHoursSunday() {
        return workingHoursSunday;
    }

    public void setWorkingHoursSunday(String workingHoursSunday) {
        this.workingHoursSunday = workingHoursSunday;
    }

    public String getWorkingHoursHolidays() {
        return workingHoursHolidays;
    }

    public void setWorkingHoursHolidays(String workingHoursHolidays) {
        this.workingHoursHolidays = workingHoursHolidays;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoOgImage() {
        return seoOgImage;
    }

    public void setSeoOgImage(String seoOgImage) {
        this.seoOgImage = seoOgImage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Boolean getBookingEnabled() {
        return bookingEnabled;
    }

    public void setBookingEnabled(Boolean bookingEnabled) {
        this.bookingEnabled = bookingEnabled;
    }

    public Boolean getShowPrices() {
        return showPrices;
    }

    public void setShowPrices(Boolean showPrices) {
        this.showPrices = showPrices;
    }

    public Boolean getRequirePhoneVerification() {
        return requirePhoneVerification;
    }

    public void setRequirePhoneVerification(Boolean requirePhoneVerification) {
        this.requirePhoneVerification = requirePhoneVerification;
    }

    public Integer getMinBookingAdvanceDays() {
        return minBookingAdvanceDays;
    }

    public void setMinBookingAdvanceDays(Integer minBookingAdvanceDays) {
        this.minBookingAdvanceDays = minBookingAdvanceDays;
    }

    public Integer getMaxBookingAdvanceDays() {
        return maxBookingAdvanceDays;
    }

    public void setMaxBookingAdvanceDays(Integer maxBookingAdvanceDays) {
        this.maxBookingAdvanceDays = maxBookingAdvanceDays;
    }

    public String getLegalCompanyName() {
        return legalCompanyName;
    }

    public void setLegalCompanyName(String legalCompanyName) {
        this.legalCompanyName = legalCompanyName;
    }

    public String getLegalCode() {
        return legalCode;
    }

    public void setLegalCode(String legalCode) {
        this.legalCode = legalCode;
    }

    public String getLegalVatNumber() {
        return legalVatNumber;
    }

    public void setLegalVatNumber(String legalVatNumber) {
        this.legalVatNumber = legalVatNumber;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(String faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
