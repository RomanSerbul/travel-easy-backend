package com.traveleasy.backend.admin.api;

import com.traveleasy.backend.admin.model.SiteSettingsDto;
import com.traveleasy.backend.admin.service.SiteSettingsService;
import com.traveleasy.backend.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/settings")
public class AdminSettingsController {

    private final SiteSettingsService settingsService;

    public AdminSettingsController(SiteSettingsService settingsService) {
        this.settingsService = settingsService;
    }

    /**
     * Отримати всі налаштування сайту
     */
    @GetMapping
    public ResponseEntity<ApiResponse<SiteSettingsDto>> getSettings() {
        SiteSettingsDto settings = settingsService.getSettings();
        return ResponseEntity.ok(ApiResponse.of(settings));
    }

    /**
     * Оновити налаштування сайту
     */
    @PutMapping
    public ResponseEntity<ApiResponse<SiteSettingsDto>> updateSettings(@RequestBody SiteSettingsDto dto) {
        SiteSettingsDto updated = settingsService.updateSettings(dto);
        return ResponseEntity.ok(ApiResponse.of(updated));
    }
}
