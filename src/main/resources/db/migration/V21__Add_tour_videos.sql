-- Add videos collection table for tour proposals
CREATE TABLE IF NOT EXISTS tour_proposal_videos (
    tour_proposal_id BIGINT NOT NULL REFERENCES tour_proposals(id) ON DELETE CASCADE,
    video_url VARCHAR(1024) NOT NULL
);

CREATE INDEX idx_tour_proposal_videos_proposal_id ON tour_proposal_videos(tour_proposal_id);
