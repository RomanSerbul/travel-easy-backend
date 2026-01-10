package com.traveleasy.backend.catalog.repository;

import com.traveleasy.backend.catalog.domain.TourProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TourProposalRepository extends JpaRepository<TourProposal, Long> {

    Optional<TourProposal> findBySlug(String slug);

    boolean existsBySlug(String slug);

    @Query("select distinct p from TourProposal p left join fetch p.images")
    List<TourProposal> findAllWithImages();
}
