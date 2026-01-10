package com.traveleasy.backend.media;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String upload(MultipartFile file, String folder) throws Exception;
    void delete(String objectKey) throws Exception;
    void deleteByUrl(String url) throws Exception;
}