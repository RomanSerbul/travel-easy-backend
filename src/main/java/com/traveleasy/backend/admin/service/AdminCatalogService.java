package com.traveleasy.backend.admin.service;

import com.traveleasy.backend.admin.model.ProposalDraft;
import com.traveleasy.backend.catalog.model.TourProposalSummary;

import java.util.List;

public interface AdminCatalogService {
    TourProposalSummary createProposal(ProposalDraft draft);

    List<TourProposalSummary> listProposals();

    TourProposalSummary updateProposal(String slug, ProposalDraft draft);

    void deleteProposal(String slug);
}
