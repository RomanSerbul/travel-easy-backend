CREATE TABLE tour_proposal_images (
    tour_proposal_id BIGINT NOT NULL,
    image_url VARCHAR(1024) NOT NULL,
    FOREIGN KEY (tour_proposal_id) REFERENCES tour_proposals(id) ON DELETE CASCADE
);

CREATE INDEX idx_tour_proposal_images_proposal_id ON tour_proposal_images(tour_proposal_id);
