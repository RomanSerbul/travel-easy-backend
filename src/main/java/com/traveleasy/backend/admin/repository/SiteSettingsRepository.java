package com.traveleasy.backend.admin.repository;

import com.traveleasy.backend.admin.model.SiteSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteSettingsRepository extends JpaRepository<SiteSettings, Long> {
    
    Optional<SiteSettings> findBySettingKey(String settingKey);
    
    default Optional<SiteSettings> findMain() {
        return findBySettingKey("main");
    }
}
