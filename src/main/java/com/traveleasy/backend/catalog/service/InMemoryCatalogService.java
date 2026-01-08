package com.traveleasy.backend.catalog.service;

import com.traveleasy.backend.catalog.domain.ProposalStatus;
import com.traveleasy.backend.catalog.model.TourProposalSummary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class InMemoryCatalogService implements CatalogService {

    private final CopyOnWriteArrayList<TourProposalSummary> proposals = new CopyOnWriteArrayList<>(List.of(
            new TourProposalSummary(
                    "lisbon-weekend",
                    "lisbon-weekend",
                    "Weekend у Лісабоні",
                    "Сонячний втеча до Атлантики",
                    "Сонячний втеча до Атлантики",
                    "Лісабон",
                    "Португалія",
                    4,
                    BigDecimal.valueOf(480),
                    List.of("Море", "Сонце", "Бар"),
                    "https://images.unsplash.com/photo-1467269204594-9661b134dd2b",
                    true,
                    ProposalStatus.ACTIVE,
                    LocalDate.of(2026, 3, 15),
                    LocalDate.of(2026, 3, 19)
            ),
            new TourProposalSummary(
                    "copenhagen-hygge",
                    "copenhagen-hygge",
                    "Фйорди та хюґе",
                    "Скандинавський комфорт та гастрономія",
                    "Скандинавський комфорт та гастрономія",
                    "Копенгаген",
                    "Данія",
                    5,
                    BigDecimal.valueOf(640),
                    List.of("Північ", "Гастро"),
                    "https://images.unsplash.com/photo-1512453979798-5ea266f8880c",
                    true,
                    ProposalStatus.ACTIVE,
                    LocalDate.of(2026, 4, 1),
                    LocalDate.of(2026, 4, 6)
            ),
            new TourProposalSummary(
                    "istanbul-senses",
                    "istanbul-senses",
                    "Стамбул: смак Сходу",
                    "Культури, спеції та ринки",
                    "Культури, спеції та ринки",
                    "Стамбул",
                    "Туреччина",
                    6,
                    BigDecimal.valueOf(520),
                    List.of("Гастро", "Прогулянки"),
                    "https://images.unsplash.com/photo-1500530855697-b586d89ba3ee",
                    false,
                    ProposalStatus.PLANNED,
                    LocalDate.of(2026, 5, 10),
                    LocalDate.of(2026, 5, 16)
            )
    ));

    @Override
    public List<TourProposalSummary> getHighlightedProposals() {
        return proposals.stream().toList();
    }

        @Override
        public TourProposalSummary getProposalBySlug(String slug) {
                return proposals.stream()
                                .filter(p -> p.slug().equals(slug))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));
        }

    @Override
    public TourProposalSummary addProposal(TourProposalSummary summary) {
        proposals.add(summary);
        return summary;
    }

        @Override
        public com.traveleasy.backend.catalog.model.TourProposalDetail getProposalDetail(String slug) {
                var summary = getProposalBySlug(slug);
                return new com.traveleasy.backend.catalog.model.TourProposalDetail(
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
                                summary.tagline() != null ? summary.tagline() : summary.title(),
                                java.util.List.of("Проживання", "Страхування", "Підтримка 24/7"),
                                java.util.List.of("Віза", "Харчування", "Особисті витрати"),
                                "Безкоштовне скасування за 7 днів"
                );
        }
}
