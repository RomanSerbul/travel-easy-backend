package com.traveleasy.backend.admin.api;

import com.traveleasy.backend.admin.model.ProposalDraft;
import com.traveleasy.backend.admin.service.AdminCatalogService;
import com.traveleasy.backend.catalog.model.TourProposalSummary;
import com.traveleasy.backend.common.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/catalog")
public class AdminCatalogController {

    private final AdminCatalogService adminCatalogService;

    public AdminCatalogController(AdminCatalogService adminCatalogService) {
        this.adminCatalogService = adminCatalogService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TourProposalSummary>> createProposal(@Valid @RequestBody ProposalDraft draft) {
        var summary = adminCatalogService.createProposal(draft);
        return ResponseEntity.ok(ApiResponse.of(summary));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TourProposalSummary>>> listProposals() {
        return ResponseEntity.ok(ApiResponse.of(adminCatalogService.listProposals()));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ApiResponse<com.traveleasy.backend.catalog.model.TourProposalDetail>> getProposal(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.of(adminCatalogService.getProposalDetail(slug)));
    }

    @PutMapping("/{slug}")
    public ResponseEntity<ApiResponse<TourProposalSummary>> updateProposal(@PathVariable String slug, @Valid @RequestBody ProposalDraft draft) {
        return ResponseEntity.ok(ApiResponse.of(adminCatalogService.updateProposal(slug, draft)));
    }

    @DeleteMapping("/{slug}")
    public ResponseEntity<ApiResponse<Void>> deleteProposal(@PathVariable String slug) {
        adminCatalogService.deleteProposal(slug);
        return ResponseEntity.ok(ApiResponse.of(null));
    }

    @PostMapping("/{slug}/activate")
    public ResponseEntity<ApiResponse<Void>> activateProposal(@PathVariable String slug) {
        ((com.traveleasy.backend.admin.service.JpaAdminCatalogService) adminCatalogService).activateProposal(slug);
        return ResponseEntity.ok(ApiResponse.of(null));
    }

    @PostMapping("/{slug}/archive")
    public ResponseEntity<ApiResponse<Void>> archiveProposal(@PathVariable String slug) {
        ((com.traveleasy.backend.admin.service.JpaAdminCatalogService) adminCatalogService).archiveProposal(slug);
        return ResponseEntity.ok(ApiResponse.of(null));
    }

    // Images management
    @PostMapping(path = "/{slug}/images", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<String>> uploadImage(@PathVariable String slug,
                                                           @RequestPart("file") MultipartFile file) throws Exception {
        var url = ((com.traveleasy.backend.admin.service.JpaAdminCatalogService) adminCatalogService)
                .uploadImage(slug, file);
        return ResponseEntity.ok(ApiResponse.of(url));
    }

    @DeleteMapping(path = "/{slug}/images")
    public ResponseEntity<ApiResponse<Void>> deleteImage(@PathVariable String slug,
                                                         @RequestBody java.util.Map<String, String> body) throws Exception {
        var imageUrl = body.get("imageUrl");
        ((com.traveleasy.backend.admin.service.JpaAdminCatalogService) adminCatalogService)
                .deleteImage(slug, imageUrl);
        return ResponseEntity.ok(ApiResponse.of(null));
    }

    @PutMapping(path = "/{slug}/images/reorder")
    public ResponseEntity<ApiResponse<Void>> reorderImages(@PathVariable String slug,
                                                           @RequestBody java.util.Map<String, java.util.List<String>> body) {
        var images = body.getOrDefault("images", java.util.List.of());
        ((com.traveleasy.backend.admin.service.JpaAdminCatalogService) adminCatalogService)
                .reorderImages(slug, images);
        return ResponseEntity.ok(ApiResponse.of(null));
    }
}
