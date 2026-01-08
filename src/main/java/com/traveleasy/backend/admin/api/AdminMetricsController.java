package com.traveleasy.backend.admin.api;

import com.traveleasy.backend.admin.model.AdminMetrics;
import com.traveleasy.backend.admin.service.AdminMetricsService;
import com.traveleasy.backend.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/metrics")
public class AdminMetricsController {

    private final AdminMetricsService adminMetricsService;

    public AdminMetricsController(AdminMetricsService adminMetricsService) {
        this.adminMetricsService = adminMetricsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<AdminMetrics>> getMetrics() {
        return ResponseEntity.ok(ApiResponse.of(adminMetricsService.calculateMetrics()));
    }
}
