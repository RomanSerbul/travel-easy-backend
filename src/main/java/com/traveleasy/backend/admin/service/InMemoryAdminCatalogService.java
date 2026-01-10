package com.traveleasy.backend.admin.service;

import com.traveleasy.backend.admin.model.ProposalDraft;
import com.traveleasy.backend.catalog.domain.ProposalStatus;
import com.traveleasy.backend.catalog.model.TourProposalSummary;
import com.traveleasy.backend.catalog.service.CatalogService;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Locale;
import java.util.UUID;

@Service
public class InMemoryAdminCatalogService implements AdminCatalogService {

    private final CatalogService catalogService;

    public InMemoryAdminCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    public TourProposalSummary createProposal(ProposalDraft draft) {
        var slug = generateSlug(draft.title());
        var summary = new TourProposalSummary(
                slug,
                slug,
                draft.title(),
                draft.headline(),
                draft.headline(),
                draft.city(),
                draft.country(),
                draft.durationDays(),
                draft.priceFrom(),
                draft.tags(),
            draft.heroImageUrl(),
            draft.hot() != null && draft.hot(),
            ProposalStatus.PLANNED,
            draft.departureDate(),
            draft.returnDate(),
            draft.minGuests() != null ? draft.minGuests() : 1,
            draft.maxGuests() != null ? draft.maxGuests() : 20
        );
        return catalogService.addProposal(summary);
    }

    @Override
    public java.util.List<TourProposalSummary> listProposals() {
        return catalogService.getHighlightedProposals();
    }

    @Override
    public com.traveleasy.backend.catalog.model.TourProposalDetail getProposalDetail(String slug) {
        return catalogService.getProposalDetail(slug);
    }

    @Override
    public TourProposalSummary updateProposal(String slug, ProposalDraft draft) {
        throw new UnsupportedOperationException("Update not supported in in-memory mode");
    }

    @Override
    public void deleteProposal(String slug) {
        throw new UnsupportedOperationException("Delete not supported in in-memory mode");
    }

    private String generateSlug(String input) {
        var normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
            .replaceAll("[^\\p{ASCII}]", "")
            .replaceAll("[^a-zA-Z0-9]+", "-")
            .replaceAll("(^-|-$)", "")
                .toLowerCase(Locale.ROOT);
        if (normalized.isBlank()) {
            return "proposal-" + UUID.randomUUID();
        }
        return normalized;
    }
}
