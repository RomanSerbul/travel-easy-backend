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
    private final com.traveleasy.backend.media.StorageService storageService;

    public JpaAdminCatalogService(TourProposalRepository tourProposalRepository,
                                  com.traveleasy.backend.media.StorageService storageService) {
        this.tourProposalRepository = tourProposalRepository;
        this.storageService = storageService;
    }

    @Override
    @Transactional
    @CacheEvict(value = "highlightedProposals", allEntries = true)
    public TourProposalSummary createProposal(ProposalDraft draft) {
        var slug = generateUniqueSlug(draft.title());
        var description = draft.description() != null && !draft.description().isBlank() 
            ? draft.description() 
            : (draft.headline() != null ? draft.headline() : draft.title());
        var includes = draft.includes() != null && !draft.includes().isBlank()
            ? draft.includes()
            : "Проживання\\n Переліт\\n Сніданки\\n Підтримка 24/7";
        var exclusions = draft.exclusions() != null && !draft.exclusions().isBlank()
            ? draft.exclusions()
            : "Віза\\n Особисті витрати\\n Додаткові екскурсії";
        var policy = draft.policy() != null && !draft.policy().isBlank()
            ? draft.policy()
            : "Безкоштовне скасування за 7 днів";

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
                description,
                includes,
                exclusions,
                policy,
                draft.departureDate(),
                draft.returnDate(),
                ProposalStatus.PLANNED,
                draft.images(),
                draft.minGuests() != null ? draft.minGuests() : 1,
                draft.maxGuests() != null ? draft.maxGuests() : 20
        );
        proposal.setProgramDetails(draft.programDetails());
        proposal.setDifficultyLevel(draft.difficultyLevel());
        proposal.setTargetAudience(draft.targetAudience());
        proposal.setAttractions(draft.attractions());
        proposal.setActivities(draft.activities());
        proposal.setHighlights(draft.highlights());
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
    @Transactional(readOnly = true)
    public com.traveleasy.backend.catalog.model.TourProposalDetail getProposalDetail(String slug) {
        var proposal = tourProposalRepository.findBySlug(slug)
                .orElseThrow(() -> new DomainException("Proposal not found"));
        
        return new com.traveleasy.backend.catalog.model.TourProposalDetail(
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
                proposal.getDescription() != null ? proposal.getDescription() : proposal.getTagline(),
                proposal.getIncludes() != null ? java.util.Arrays.asList(proposal.getIncludes().split("\\n")) : java.util.List.of(),
                proposal.getExclusions() != null ? java.util.Arrays.asList(proposal.getExclusions().split("\\n")) : java.util.List.of(),
                proposal.getPolicy() != null ? proposal.getPolicy() : "Безкоштовне скасування за 7 днів",
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
    public TourProposalSummary updateProposal(String slug, ProposalDraft draft) {
        var proposal = tourProposalRepository.findBySlug(slug)
                .orElseThrow(() -> new DomainException("Proposal not found"));
        // Keep old media refs for cleanup
        var oldHero = proposal.getHeroImageUrl();
        var oldImages = proposal.getImages();
        
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
        
        // Update new fields
        if (draft.description() != null) {
            proposal.setDescription(draft.description());
        }
        if (draft.includes() != null) {
            proposal.setIncludes(draft.includes());
        }
        if (draft.exclusions() != null) {
            proposal.setExclusions(draft.exclusions());
        }
        if (draft.policy() != null) {
            proposal.setPolicy(draft.policy());
        }
        if (draft.images() != null) {
            proposal.setImages(draft.images());
        }
        if (draft.minGuests() != null) {
            proposal.setMinGuests(draft.minGuests());
        }
        if (draft.maxGuests() != null) {
            proposal.setMaxGuests(draft.maxGuests());
        }
        
        // Update new program detail fields
        if (draft.programDetails() != null) {
            proposal.setProgramDetails(draft.programDetails());
        }
        if (draft.difficultyLevel() != null) {
            proposal.setDifficultyLevel(draft.difficultyLevel());
        }
        if (draft.targetAudience() != null) {
            proposal.setTargetAudience(draft.targetAudience());
        }
        if (draft.attractions() != null) {
            proposal.setAttractions(draft.attractions());
        }
        if (draft.activities() != null) {
            proposal.setActivities(draft.activities());
        }
        if (draft.highlights() != null) {
            proposal.setHighlights(draft.highlights());
        }
        if (draft.departureLocations() != null) {
            proposal.setDepartureLocations(draft.departureLocations());
        }
        
        var saved = tourProposalRepository.save(proposal);
        // Cleanup removed media
        try {
            if (oldHero != null && !oldHero.isBlank()
                    && draft.heroImageUrl() != null
                    && !oldHero.equals(draft.heroImageUrl())) {
                storageService.deleteByUrl(oldHero);
            }
            if (oldImages != null && !oldImages.isEmpty() && draft.images() != null) {
                var newSet = new java.util.HashSet<>(draft.images());
                for (var url : oldImages) {
                    if (!newSet.contains(url)) {
                        storageService.deleteByUrl(url);
                    }
                }
            }
        } catch (Exception ignore) {}
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
        // Cleanup all media
        try {
            if (proposal.getHeroImageUrl() != null) {
                storageService.deleteByUrl(proposal.getHeroImageUrl());
            }
            if (proposal.getImages() != null) {
                for (var url : proposal.getImages()) {
                    storageService.deleteByUrl(url);
                }
            }
        } catch (Exception ignore) {}
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
                proposal.getReturnDate(),
                proposal.getMinGuests(),
                proposal.getMaxGuests()
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
