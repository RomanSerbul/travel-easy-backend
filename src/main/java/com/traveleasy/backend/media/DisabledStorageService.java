package com.traveleasy.backend.media;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Primary
@ConditionalOnProperty(prefix = "app.storage.minio", name = "enabled", havingValue = "false", matchIfMissing = true)
public class DisabledStorageService implements StorageService {
    private IllegalStateException notEnabled() {
        return new IllegalStateException("Storage is disabled. Set MINIO_ENABLED=true and configure MINIO_* env vars.");
    }

    @Override
    public String upload(MultipartFile file, String folder) throws Exception {
        throw notEnabled();
    }

    @Override
    public void delete(String objectKey) throws Exception {
        throw notEnabled();
    }

    @Override
    public void deleteByUrl(String url) throws Exception {
        throw notEnabled();
    }
}
