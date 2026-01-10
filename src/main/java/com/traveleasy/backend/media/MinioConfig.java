package com.traveleasy.backend.media;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "app.storage.minio", name = "enabled", havingValue = "true", matchIfMissing = true)
public class MinioConfig {

    @Bean
    public MinioClient minioClient(
            @Value("${app.storage.minio.private-endpoint}") String endpoint,
            @Value("${app.storage.minio.access-key}") String accessKey,
            @Value("${app.storage.minio.secret-key}") String secretKey
    ) {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    @Bean
    public StorageSettings storageSettings(
            @Value("${app.storage.minio.bucket}") String bucket,
            @Value("${app.storage.minio.public-endpoint}") String publicEndpoint
    ) {
        return new StorageSettings(bucket, publicEndpoint);
    }
}
