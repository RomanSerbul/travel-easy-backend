package com.traveleasy.backend.admin.service;

import com.traveleasy.backend.admin.model.ProposalDraft;
import com.traveleasy.backend.catalog.domain.ProposalStatus;
import com.traveleasy.backend.catalog.domain.TourProposal;
import com.traveleasy.backend.catalog.model.TourProposalSummary;
import com.traveleasy.backend.catalog.repository.TourProposalRepository;
import com.traveleasy.backend.common.exception.DomainException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Primary
public class JpaAdminCatalogService implements AdminCatalogService {

    private final TourProposalRepository tourProposalRepository;

    public JpaAdminCatalogService(TourProposalRepository tourProposalRepository) {
        this.tourProposalRepository = tourProposalRepository;
    }

    @Override
    @Transactional
    @CacheEvict(value = "highlightedProposals", allEntries = true)
    public TourProposalSummary createProposal(ProposalDraft draft) {
        var slug = generateUniqueSlug(draft.title());
        var defaultDescription = draft.headline() != null ? draft.headline() : draft.title();
        var defaultIncludes = "Проживання\\nПереліт\\nСніданки\\nПідтримка 24/7";
        var defaultExclusions = "Віза\\nОсобисті витрати\\nДодаткові екскурсії";
        var defaultPolicy = "Безкоштовне скасування за 7 днів";

        var proposal = new TourProposal(
                slug,
                draft.title(),
                draft.headline(),
                draft.city(),
                draft.country(),
                draft.durationDays(),
                draft.priceFrom(),
                draft.tags(),
                draft.heroImageUrl(),
                draft.hot() != null && draft.hot(),
                defaultDescription,
                defaultIncludes,
                defaultExclusions,
                defaultPolicy,
                draft.departureDate(),
                draft.returnDate(),
                ProposalStatus.PLANNED
        );
        var saved = tourProposalRepository.save(proposal);
        return toSummary(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TourProposalSummary> listProposals() {
        return tourProposalRepository.findAll().stream()
                .map(this::toSummary)
                .toList();
    }

    @Override
    @Transactional
    @CacheEvict(value = "highlightedProposals", allEntries = true)
    public TourProposalSummary updateProposal(String slug, ProposalDraft draft) {
        var proposal = tourProposalRepository.findBySlug(slug)
                .orElseThrow(() -> new DomainException("Proposal not found"));
        
        // Update fields directly using setters
        proposal.setTitle(draft.title());
        proposal.setTagline(draft.headline());
        proposal.setCity(draft.city());
        proposal.setCountry(draft.country());
        proposal.setDurationDays(draft.durationDays());
        proposal.setPriceFrom(draft.priceFrom());
        proposal.setTags(draft.tags());
        proposal.setHeroImageUrl(draft.heroImageUrl());
        proposal.setHot(draft.hot() != null && draft.hot());
        proposal.setDepartureDate(draft.departureDate());
        proposal.setReturnDate(draft.returnDate());
        
        var saved = tourProposalRepository.save(proposal);
        return toSummary(saved);
    }

    @Transactional
    @CacheEvict(value = "highlightedProposals", allEntries = true)
    public void activateProposal(String slug) {
        var proposal = tourProposalRepository.findBySlug(slug)
                .orElseThrow(() -> new DomainException("Proposal not found"));
        proposal.setStatus(ProposalStatus.ACTIVE);
        tourProposalRepository.save(proposal);
    }

    @Transactional
    @CacheEvict(value = "highlightedProposals", allEntries = true)
    public void archiveProposal(String slug) {
        var proposal = tourProposalRepository.findBySlug(slug)
                .orElseThrow(() -> new DomainException("Proposal not found"));
        proposal.setStatus(ProposalStatus.ARCHIVED);
        tourProposalRepository.save(proposal);
    }

    @Override
    @Transactional
    @CacheEvict(value = "highlightedProposals", allEntries = true)
    public void deleteProposal(String slug) {
        var proposal = tourProposalRepository.findBySlug(slug)
                .orElseThrow(() -> new DomainException("Proposal not found"));
        tourProposalRepository.delete(proposal);
    }

    private TourProposalSummary toSummary(TourProposal proposal) {
        return new TourProposalSummary(
                proposal.getSlug(),
                proposal.getSlug(),
                proposal.getTitle(),
                proposal.getTagline(),
                proposal.getTagline(),
                proposal.getCity(),
                proposal.getCountry(),
                proposal.getDurationDays(),
                proposal.getPriceFrom(),
                proposal.getTags(),
                proposal.getHeroImageUrl(),
                proposal.isHot(),
                proposal.getStatus(),
                proposal.getDepartureDate(),
                proposal.getReturnDate()
        );
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

    private String generateUniqueSlug(String input) {
        var baseSlug = generateSlug(input);
        var slug = baseSlug;
        var counter = 2;
        
        while (tourProposalRepository.existsBySlug(slug)) {
            slug = baseSlug + "-" + counter;
            counter++;
        }
        
        return slug;
    }
}
