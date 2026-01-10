-- Add detailed tour program fields
ALTER TABLE tour_proposals
ADD COLUMN program_details TEXT,
ADD COLUMN difficulty_level VARCHAR(50),
ADD COLUMN target_audience TEXT;

-- Create tables for attractions, activities, and highlights
CREATE TABLE tour_proposal_attractions (
    tour_proposal_id BIGINT NOT NULL,
    attraction VARCHAR(500) NOT NULL,
    CONSTRAINT fk_tour_proposal_attractions FOREIGN KEY (tour_proposal_id) REFERENCES tour_proposals(id) ON DELETE CASCADE
);

CREATE TABLE tour_proposal_activities (
    tour_proposal_id BIGINT NOT NULL,
    activity VARCHAR(500) NOT NULL,
    CONSTRAINT fk_tour_proposal_activities FOREIGN KEY (tour_proposal_id) REFERENCES tour_proposals(id) ON DELETE CASCADE
);

CREATE TABLE tour_proposal_highlights (
    tour_proposal_id BIGINT NOT NULL,
    highlight VARCHAR(500) NOT NULL,
    CONSTRAINT fk_tour_proposal_highlights FOREIGN KEY (tour_proposal_id) REFERENCES tour_proposals(id) ON DELETE CASCADE
);

CREATE INDEX idx_tour_proposal_attractions_id ON tour_proposal_attractions(tour_proposal_id);
CREATE INDEX idx_tour_proposal_activities_id ON tour_proposal_activities(tour_proposal_id);
CREATE INDEX idx_tour_proposal_highlights_id ON tour_proposal_highlights(tour_proposal_id);
