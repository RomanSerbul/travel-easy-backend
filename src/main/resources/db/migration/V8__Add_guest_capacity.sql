-- Add minimum and maximum guest capacity fields to tour proposals
ALTER TABLE tour_proposals 
ADD COLUMN min_guests INTEGER DEFAULT 1,
ADD COLUMN max_guests INTEGER DEFAULT 20;

-- Update existing proposals with reasonable defaults
UPDATE tour_proposals SET min_guests = 2, max_guests = 15 WHERE slug = 'carpathian-peaks';
UPDATE tour_proposals SET min_guests = 1, max_guests = 50 WHERE slug = 'bukovel-winter';
UPDATE tour_proposals SET min_guests = 1, max_guests = 30 WHERE slug = 'carpathian-wellness';
UPDATE tour_proposals SET min_guests = 4, max_guests = 12 WHERE slug = 'carpathian-adventure';
UPDATE tour_proposals SET min_guests = 4, max_guests = 20 WHERE slug = 'carpathian-culture';
