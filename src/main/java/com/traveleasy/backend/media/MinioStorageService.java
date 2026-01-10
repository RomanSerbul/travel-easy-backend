package com.traveleasy.backend.media;

import io.minio.*;
import io.minio.http.Method;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.Duration;
import java.util.UUID;

@Service
@ConditionalOnProperty(prefix = "app.storage.minio", name = "enabled", havingValue = "true")
public class MinioStorageService implements StorageService {
    private final MinioClient client;
    private final StorageSettings settings;

    public MinioStorageService(MinioClient client, StorageSettings settings) {
        this.client = client;
        this.settings = settings;
    }

    @Override
    public String upload(MultipartFile file, String folder) throws Exception {
        ensureBucket();
        String ext = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String key = (folder != null && !folder.isBlank() ? folder.replaceAll("^/+|/+$", "") + "/" : "")
                + UUID.randomUUID() + (ext != null ? "." + ext.toLowerCase() : "");
        try (InputStream is = file.getInputStream()) {
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(settings.bucket())
                    .object(key)
                    .contentType(detectContentType(file))
                    .stream(is, file.getSize(), -1)
                    .build();
            client.putObject(args);
        }
        return publicUrl(key);
    }

    @Override
    public void delete(String objectKey) throws Exception {
        RemoveObjectArgs args = RemoveObjectArgs.builder()
                .bucket(settings.bucket())
                .object(objectKey)
                .build();
        client.removeObject(args);
    }

    @Override
    public void deleteByUrl(String url) throws Exception {
        if (url == null || url.isBlank()) return;
        String base = settings.publicEndpoint() != null ? settings.publicEndpoint().replaceAll("/$", "") : null;
        String prefix = base != null ? (base + "/" + settings.bucket() + "/") : null;
        if (prefix != null && url.startsWith(prefix)) {
            String key = url.substring(prefix.length());
            delete(key);
        }
        // If not matched, silently ignore (it might be an external URL)
    }

    private void ensureBucket() throws Exception {
        boolean exists = client.bucketExists(BucketExistsArgs.builder().bucket(settings.bucket()).build());
        if (!exists) {
            client.makeBucket(MakeBucketArgs.builder().bucket(settings.bucket()).build());
        }
    }

    private String publicUrl(String key) {
        // If public endpoint is provided, build a static URL
        if (settings.publicEndpoint() != null && !settings.publicEndpoint().isBlank()) {
            String base = settings.publicEndpoint().replaceAll("/$", "");
            return base + "/" + settings.bucket() + "/" + key;
        }
        // Fallback to presigned URL valid for 24h
        try {
            return client.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(settings.bucket())
                            .object(key)
                            .method(Method.GET)
                            .expiry((int) Duration.ofHours(24).toSeconds())
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate public URL", e);
        }
    }

    private String detectContentType(MultipartFile file) {
        String ct = file.getContentType();
        if (ct == null || ct.isBlank()) {
            String name = file.getOriginalFilename();
            if (name != null) {
                String lower = name.toLowerCase();
                if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return MediaType.IMAGE_JPEG_VALUE;
                if (lower.endsWith(".png")) return MediaType.IMAGE_PNG_VALUE;
                if (lower.endsWith(".webp")) return "image/webp";
            }
            return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ct;
    }
}
