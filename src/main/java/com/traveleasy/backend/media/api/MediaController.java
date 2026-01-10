package com.traveleasy.backend.media.api;

import com.traveleasy.backend.common.dto.ApiResponse;
import com.traveleasy.backend.media.dto.MediaItemDto;
import com.traveleasy.backend.media.service.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MediaItemDto>>> listMedia() {
        List<MediaItemDto> items = mediaService.listAll();
        return ResponseEntity.ok(ApiResponse.of(items));
    }
}
