package com.traveleasy.backend.catalog.api;

import com.traveleasy.backend.admin.model.SiteSettingsDto;
import com.traveleasy.backend.admin.service.SiteSettingsService;
import com.traveleasy.backend.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Публічний контролер для отримання налаштувань сайту (без авторизації)
 */
@RestController
@RequestMapping("/api/settings")
public class PublicSettingsController {

    private final SiteSettingsService settingsService;

    public PublicSettingsController(SiteSettingsService settingsService) {
        this.settingsService = settingsService;
    }

    /**
     * Отримати публічні налаштування сайту
     */
    @GetMapping
    public ResponseEntity<ApiResponse<SiteSettingsDto>> getPublicSettings() {
        SiteSettingsDto settings = settingsService.getSettings();
        return ResponseEntity.ok(ApiResponse.of(settings));
    }
}
