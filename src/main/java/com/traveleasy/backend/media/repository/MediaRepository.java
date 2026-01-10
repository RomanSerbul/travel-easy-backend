package com.traveleasy.backend.media.repository;

import com.traveleasy.backend.media.entity.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<MediaEntity, String> {
    Optional<MediaEntity> findByUrl(String url);
    Optional<MediaEntity> findByObjectKey(String objectKey);
}
