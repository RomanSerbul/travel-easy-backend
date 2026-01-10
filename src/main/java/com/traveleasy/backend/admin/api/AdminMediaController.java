package com.traveleasy.backend.admin.api;

import com.traveleasy.backend.common.dto.ApiResponse;
import com.traveleasy.backend.media.StorageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/media")
public class AdminMediaController {

    private final StorageService storageService;

    public AdminMediaController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Map<String, String>>> upload(
            @RequestPart("file") MultipartFile file,
            @RequestParam(value = "folder", required = false) String folder
    ) throws Exception {
        String url = storageService.upload(file, folder != null ? folder : "uploads");
        return ResponseEntity.ok(ApiResponse.of(Map.of(
                "url", url
        )));
    }
}
