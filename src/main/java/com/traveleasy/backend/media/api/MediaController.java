package com.traveleasy.backend.media.api;

import com.traveleasy.backend.common.dto.ApiResponse;
import com.traveleasy.backend.media.dto.MediaItemDto;
import com.traveleasy.backend.media.service.MediaService;
import com.traveleasy.backend.catalog.repository.TourProposalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final MediaService mediaService;
    private final TourProposalRepository tourProposalRepository;

    public MediaController(MediaService mediaService, TourProposalRepository tourProposalRepository) {
        this.mediaService = mediaService;
        this.tourProposalRepository = tourProposalRepository;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<List<MediaItemDto>>> listMedia() {
        // Aggregate from tour proposals (images and videos)
        var proposals = tourProposalRepository.findAllWithMedia();
        var items = new java.util.ArrayList<MediaItemDto>();
        
        // Add images
        proposals.forEach(p -> 
            p.getImages().forEach(url -> items.add(toDto(url, p.getSlug(), p.getTitle())))
        );
        
        // Add videos
        proposals.forEach(p -> 
            p.getVideos().forEach(url -> items.add(toDto(url, p.getSlug(), p.getTitle())))
        );
        
        return ResponseEntity.ok(ApiResponse.of(items));
    }

    private MediaItemDto toDto(String url, String tourSlug, String tourTitle) {
        String fileName = url;
        int idx = url.lastIndexOf('/');
        if (idx >= 0 && idx + 1 < url.length()) fileName = url.substring(idx + 1);
        return new MediaItemDto(null, url, fileName, java.time.Instant.now(), null, tourSlug, tourTitle);
    }
}
