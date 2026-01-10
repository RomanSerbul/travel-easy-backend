package com.traveleasy.backend.media.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "media")
public class MediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String url;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "object_key", nullable = false)
    private String objectKey;

    @Column(nullable = false)
    private Long size;

    @Column(name = "uploaded_at", nullable = false)
    private Instant uploadedAt;

    public MediaEntity() {
    }

    public MediaEntity(String url, String fileName, String objectKey, Long size) {
        this.url = url;
        this.fileName = fileName;
        this.objectKey = objectKey;
        this.size = size;
        this.uploadedAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getObjectKey() {
        return objectKey;
    }

    public void setObjectKey(String objectKey) {
        this.objectKey = objectKey;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Instant getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Instant uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
