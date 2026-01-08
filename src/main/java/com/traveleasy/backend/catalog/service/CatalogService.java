package com.traveleasy.backend.catalog.service;

import com.traveleasy.backend.catalog.model.TourProposalSummary;
import com.traveleasy.backend.catalog.model.TourProposalDetail;

import java.util.List;

public interface CatalogService {
    List<TourProposalSummary> getHighlightedProposals();

    TourProposalSummary getProposalBySlug(String slug);

    TourProposalDetail getProposalDetail(String slug);

    TourProposalSummary addProposal(TourProposalSummary summary);
}
