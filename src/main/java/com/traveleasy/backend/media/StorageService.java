package com.traveleasy.backend.media;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    /** Uploads a file and returns its public URL */
    String upload(MultipartFile file, String folder) throws Exception;

    /** Deletes an object (optional use) */
    void delete(String objectKey) throws Exception;
}
