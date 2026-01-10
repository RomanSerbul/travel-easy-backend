package com.traveleasy.backend.catalog.service;

import com.traveleasy.backend.catalog.domain.TourProposal;
import com.traveleasy.backend.catalog.domain.ProposalStatus;
import com.traveleasy.backend.catalog.model.TourProposalDetail;
import com.traveleasy.backend.catalog.model.TourProposalSummary;
import com.traveleasy.backend.catalog.repository.TourProposalRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class JpaCatalogService implements CatalogService {

    private final TourProposalRepository tourProposalRepository;

    public JpaCatalogService(TourProposalRepository tourProposalRepository) {
        this.tourProposalRepository = tourProposalRepository;
    }

    @Override
    @Cacheable("highlightedProposals")
    @Transactional(readOnly = true)
    public List<TourProposalSummary> getHighlightedProposals() {
        return tourProposalRepository.findAll().stream()
                .filter(p -> p.getStatus() == ProposalStatus.ACTIVE)
                .map(this::toSummary)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TourProposalSummary getProposalBySlug(String slug) {
        return tourProposalRepository.findBySlug(slug)
                .map(this::toSummary)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));
    }

        @Override
        @Transactional(readOnly = true)
        public TourProposalDetail getProposalDetail(String slug) {
            var proposal = tourProposalRepository.findBySlug(slug)
                    .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));

            return new TourProposalDetail(
                    proposal.getSlug(),
                    proposal.getTitle(),
                    proposal.getTagline(),
                    proposal.getCity(),
                    proposal.getCountry(),
                    proposal.getDurationDays(),
                    proposal.getPriceFrom(),
                    proposal.getTags(),
                    proposal.getHeroImageUrl(),
                    proposal.isHot(),
                    valueOrFallback(proposal.getDescription(), proposal.getTagline(), proposal.getTitle()),
                    splitList(proposal.getIncludes()),
                    splitList(proposal.getExclusions()),
                    firstNonBlank(proposal.getPolicy(), "Безкоштовне скасування за 7 днів"),
                    proposal.getDepartureDate(),
                    proposal.getReturnDate(),
                    proposal.getImages() != null ? proposal.getImages() : java.util.List.of(),
                    proposal.getMinGuests(),
                    proposal.getMaxGuests(),
                    proposal.getProgramDetails(),
                    proposal.getDifficultyLevel(),
                    proposal.getTargetAudience(),
                    proposal.getAttractions() != null ? proposal.getAttractions() : java.util.List.of(),
                    proposal.getActivities() != null ? proposal.getActivities() : java.util.List.of(),
                    proposal.getHighlights() != null ? proposal.getHighlights() : java.util.List.of(),
                    proposal.getDepartureLocations()
            );
        }

    @Override
    @Transactional
        @CacheEvict(value = "highlightedProposals", allEntries = true)
    public TourProposalSummary addProposal(TourProposalSummary summary) {
        var defaultDescription = summary.tagline() != null ? summary.tagline() : summary.title();
        var defaultIncludes = "Проживання\nПереліт\nСніданки\nПідтримка 24/7";
        var defaultExclusions = "Віза\nОсобисті витрати\nДодаткові екскурсії";
        var defaultPolicy = "Безкоштовне скасування за 7 днів";
        var proposal = new TourProposal(
                summary.id(),
                summary.title(),
                summary.tagline(),
                summary.city(),
                summary.country(),
                summary.durationDays(),
                summary.priceFrom(),
                summary.tags(),
                summary.heroImageUrl(),
            summary.hot(),
            defaultDescription,
            defaultIncludes,
            defaultExclusions,
            defaultPolicy,
            null,
            null,
            null,
            new java.util.ArrayList<>(),
            summary.minGuests(),
            summary.maxGuests()
        );
        var saved = tourProposalRepository.save(proposal);
        return toSummary(saved);
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
                proposal.getReturnDate(),
                proposal.getMinGuests(),
                proposal.getMaxGuests()
        );
    }

    private List<String> splitList(String raw) {
        if (raw == null || raw.isBlank()) return List.of();
        return java.util.Arrays.stream(raw.split("\\n"))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();
    }

    private String valueOrFallback(String primary, String secondary, String fallback) {
        if (primary != null && !primary.isBlank()) return primary;
        if (secondary != null && !secondary.isBlank()) return secondary;
        return fallback;
    }

    private String firstNonBlank(String primary, String fallback) {
        if (primary != null && !primary.isBlank()) return primary;
        return fallback;
    }
}
