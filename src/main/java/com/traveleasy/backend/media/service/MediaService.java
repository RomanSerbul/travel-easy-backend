package com.traveleasy.backend.media.service;

import com.traveleasy.backend.media.StorageService;
import com.traveleasy.backend.media.dto.MediaItemDto;
import com.traveleasy.backend.media.entity.MediaEntity;
import com.traveleasy.backend.media.repository.MediaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaService {
    private final StorageService storageService;
    private final MediaRepository mediaRepository;

    public MediaService(StorageService storageService, MediaRepository mediaRepository) {
        this.storageService = storageService;
        this.mediaRepository = mediaRepository;
    }

    @Transactional(readOnly = true)
    public List<MediaItemDto> listAll() {
        return mediaRepository.findAll().stream()
                .map(entity -> new MediaItemDto(
                        entity.getId(),
                        entity.getUrl(),
                        entity.getFileName(),
                        entity.getUploadedAt(),
                    entity.getSize(),
                    null,
                    null
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public MediaItemDto upload(MultipartFile file, String folder) throws Exception {
        String url = storageService.upload(file, folder);
        String objectKey = extractObjectKeyFromUrl(url, folder);
        
        MediaEntity entity = new MediaEntity(
                url,
                file.getOriginalFilename(),
                objectKey,
                file.getSize()
        );
        entity = mediaRepository.save(entity);

        return new MediaItemDto(
                entity.getId(),
                entity.getUrl(),
                entity.getFileName(),
                entity.getUploadedAt(),
            entity.getSize(),
            null,
            null
        );
    }

    @Transactional
    public void deleteByUrl(String url) throws Exception {
        storageService.deleteByUrl(url);
        mediaRepository.findByUrl(url).ifPresent(mediaRepository::delete);
    }

    private String extractObjectKeyFromUrl(String url, String folder) {
        // Extract object key from URL - simple extraction after bucket name
        int lastSlash = url.lastIndexOf('/');
        if (lastSlash >= 0) {
            return url.substring(lastSlash + 1);
        }
        return url;
    }
}
