package com.traveleasy.backend.admin.api;

import com.traveleasy.backend.common.dto.ApiResponse;
import com.traveleasy.backend.media.dto.MediaItemDto;
import com.traveleasy.backend.media.service.MediaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/media")
public class AdminMediaController {

    private final MediaService mediaService;

    public AdminMediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MediaItemDto>>> listMedia() {
        List<MediaItemDto> items = mediaService.listAll();
        return ResponseEntity.ok(ApiResponse.of(items));
    }

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<MediaItemDto>> upload(
            @RequestPart("file") MultipartFile file,
            @RequestParam(value = "folder", required = false) String folder
    ) throws Exception {
        MediaItemDto item = mediaService.upload(file, folder != null ? folder : "gallery");
        return ResponseEntity.ok(ApiResponse.of(item));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<Map<String, String>>> delete(
            @RequestBody Map<String, String> body
    ) throws Exception {
        String url = body.get("url");
        if (url != null && !url.isBlank()) {
            mediaService.deleteByUrl(url);
        }
        return ResponseEntity.ok(ApiResponse.of(Map.of("status", "ok")));
    }
}
