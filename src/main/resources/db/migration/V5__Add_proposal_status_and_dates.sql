-- Add status, departure_date, and return_date to tour_proposals
ALTER TABLE tour_proposals
ADD COLUMN status VARCHAR(20) NOT NULL DEFAULT 'PLANNED',
ADD COLUMN departure_date DATE,
ADD COLUMN return_date DATE;

-- Create index for status queries
CREATE INDEX idx_tour_proposals_status ON tour_proposals(status);

-- Update existing proposals to ACTIVE status
UPDATE tour_proposals SET status = 'ACTIVE' WHERE hot = true;
