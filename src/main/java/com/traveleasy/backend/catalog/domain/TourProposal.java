package com.traveleasy.backend.catalog.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour_proposals")
public class TourProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(nullable = false)
    private String title;

    private String tagline;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(name = "duration_days", nullable = false)
    private int durationDays;

    @Column(name = "price_from", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceFrom;

    @ElementCollection
    @CollectionTable(name = "tour_proposal_tags", joinColumns = @JoinColumn(name = "tour_proposal_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();

    @Column(name = "hero_image_url")
    private String heroImageUrl;

    @ElementCollection
    @CollectionTable(name = "tour_proposal_images", joinColumns = @JoinColumn(name = "tour_proposal_id"))
    @Column(name = "image_url")
    private List<String> images = new ArrayList<>();

    @Column(name = "hot", nullable = false)
    private boolean hot = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProposalStatus status = ProposalStatus.PLANNED;

    private LocalDate departureDate;

    private LocalDate returnDate;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description = "";

    @Column(name = "includes", columnDefinition = "TEXT", nullable = false)
    private String includes = "";

    @Column(name = "exclusions", columnDefinition = "TEXT", nullable = false)
    private String exclusions = "";

    @Column(name = "policy", columnDefinition = "TEXT", nullable = false)
    private String policy = "";

    @Column(name = "program_details", columnDefinition = "TEXT")
    private String programDetails = "";

    @ElementCollection
    @CollectionTable(name = "tour_proposal_attractions", joinColumns = @JoinColumn(name = "tour_proposal_id"))
    @Column(name = "attraction")
    private List<String> attractions = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tour_proposal_activities", joinColumns = @JoinColumn(name = "tour_proposal_id"))
    @Column(name = "activity")
    private List<String> activities = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tour_proposal_highlights", joinColumns = @JoinColumn(name = "tour_proposal_id"))
    @Column(name = "highlight")
    private List<String> highlights = new ArrayList<>();

    @Column(name = "difficulty_level")
    private String difficultyLevel = "";

    @Column(name = "target_audience", columnDefinition = "TEXT")
    private String targetAudience = "";

    @Column(name = "departure_locations", columnDefinition = "TEXT")
    private String departureLocations = "";

    @Column(name = "min_guests")
    private int minGuests = 1;

    @Column(name = "max_guests")
    private int maxGuests = 20;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    protected TourProposal() {
    }

    public TourProposal(String slug, String title, String tagline, String city, String country,
                        int durationDays, BigDecimal priceFrom, List<String> tags, String heroImageUrl,
                        boolean hot, String description, String includes, String exclusions, String policy,
                        LocalDate departureDate, LocalDate returnDate, ProposalStatus status, List<String> images,
                        int minGuests, int maxGuests) {
        this.slug = slug;
        this.title = title;
        this.tagline = tagline;
        this.city = city;
        this.country = country;
        this.durationDays = durationDays;
        this.priceFrom = priceFrom;
        this.tags = tags != null ? new ArrayList<>(tags) : new ArrayList<>();
        this.heroImageUrl = heroImageUrl;
        this.hot = hot;
        this.description = description;
        this.includes = includes;
        this.exclusions = exclusions;
        this.policy = policy;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.status = status != null ? status : ProposalStatus.PLANNED;
        this.images = images != null ? new ArrayList<>(images) : new ArrayList<>();
        this.minGuests = minGuests;
        this.maxGuests = maxGuests;
    }

    public Long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public String getTagline() {
        return tagline;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public List<String> getTags() {
        return new ArrayList<>(tags);
    }

    public String getHeroImageUrl() {
        return heroImageUrl;
    }

    public boolean isHot() {
        return hot;
    }

    public String getDescription() {
        return description;
    }

    public String getIncludes() {
        return includes;
    }

    public String getExclusions() {
        return exclusions;
    }

    public String getPolicy() {
        return policy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    // Setters for updates
    public void setTitle(String title) {
        this.title = title;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setTags(List<String> tags) {
        this.tags = tags != null ? new ArrayList<>(tags) : new ArrayList<>();
    }

    public void setHeroImageUrl(String heroImageUrl) {
        this.heroImageUrl = heroImageUrl;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public ProposalStatus getStatus() {
        return status;
    }

    public void setStatus(ProposalStatus status) {
        this.status = status;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public List<String> getImages() {
        return new ArrayList<>(images);
    }

    public void setImages(List<String> images) {
        this.images = images != null ? new ArrayList<>(images) : new ArrayList<>();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIncludes(String includes) {
        this.includes = includes;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getProgramDetails() {
        return programDetails;
    }

    public void setProgramDetails(String programDetails) {
        this.programDetails = programDetails;
    }

    public List<String> getAttractions() {
        return new ArrayList<>(attractions);
    }

    public void setAttractions(List<String> attractions) {
        this.attractions = attractions != null ? new ArrayList<>(attractions) : new ArrayList<>();
    }

    public List<String> getActivities() {
        return new ArrayList<>(activities);
    }

    public void setActivities(List<String> activities) {
        this.activities = activities != null ? new ArrayList<>(activities) : new ArrayList<>();
    }

    public List<String> getHighlights() {
        return new ArrayList<>(highlights);
    }

    public void setHighlights(List<String> highlights) {
        this.highlights = highlights != null ? new ArrayList<>(highlights) : new ArrayList<>();
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getDepartureLocations() {
        return departureLocations;
    }

    public void setDepartureLocations(String departureLocations) {
        this.departureLocations = departureLocations;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public int getMinGuests() {
        return minGuests;
    }

    public void setMinGuests(int minGuests) {
        this.minGuests = minGuests;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }
}
