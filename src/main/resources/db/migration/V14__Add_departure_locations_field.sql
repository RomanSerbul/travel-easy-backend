-- Add departure locations field to tour proposals
ALTER TABLE tour_proposals
ADD COLUMN departure_locations TEXT;

-- Update all tours with departure location information
UPDATE tour_proposals
SET departure_locations = 'Виїзд із м. Київ (ст. метро Теремки), м. Васильків. Можливий трансфер із сусідніх міст (Б. Церква, Фастів) – за домовленістю'
WHERE slug IN ('mikulichin-group-tour', 'vorokhta-group-tour', 'yaremche-group-tour', 'synevyrska-polyana-group-tour');
