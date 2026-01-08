package com.traveleasy.backend.catalog.api;

import com.traveleasy.backend.catalog.model.TourProposalSummary;
import com.traveleasy.backend.catalog.model.TourProposalDetail;
import com.traveleasy.backend.catalog.service.CatalogService;
import com.traveleasy.backend.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/highlighted")
    public ResponseEntity<ApiResponse<List<TourProposalSummary>>> getHighlighted() {
        return ResponseEntity.ok(ApiResponse.of(catalogService.getHighlightedProposals()));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ApiResponse<TourProposalDetail>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.of(catalogService.getProposalDetail(slug)));
    }
}
