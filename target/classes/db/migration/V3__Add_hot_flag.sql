ALTER TABLE tour_proposals
    ADD COLUMN hot BOOLEAN NOT NULL DEFAULT false;

-- Mark initial hot offers
UPDATE tour_proposals
SET hot = true
WHERE slug IN ('lisbon-weekend', 'copenhagen-hygge');
