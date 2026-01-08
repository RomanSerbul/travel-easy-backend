-- Create tour_proposals table
CREATE TABLE tour_proposals (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(255) UNIQUE NOT NULL,
    title VARCHAR(255) NOT NULL,
    tagline VARCHAR(500),
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    duration_days INTEGER NOT NULL,
    price_from DECIMAL(10, 2) NOT NULL,
    hero_image_url VARCHAR(500),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Create tour_proposal_tags table
CREATE TABLE tour_proposal_tags (
    tour_proposal_id BIGINT NOT NULL,
    tag VARCHAR(100) NOT NULL,
    CONSTRAINT fk_tour_proposal_tags FOREIGN KEY (tour_proposal_id) REFERENCES tour_proposals(id) ON DELETE CASCADE
);

CREATE INDEX idx_tour_proposal_tags_proposal_id ON tour_proposal_tags(tour_proposal_id);

-- Create booking_orders table
CREATE TABLE booking_orders (
    id UUID PRIMARY KEY,
    proposal_id VARCHAR(255) NOT NULL,
    customer_name VARCHAR(255) NOT NULL,
    customer_email VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(50) NOT NULL,
    start_date DATE NOT NULL,
    nights INTEGER NOT NULL,
    guests INTEGER NOT NULL,
    notes TEXT,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Create booking_order_addons table
CREATE TABLE booking_order_addons (
    booking_order_id UUID NOT NULL,
    addon VARCHAR(255) NOT NULL,
    CONSTRAINT fk_booking_order_addons FOREIGN KEY (booking_order_id) REFERENCES booking_orders(id) ON DELETE CASCADE
);

CREATE INDEX idx_booking_order_addons_order_id ON booking_order_addons(booking_order_id);
CREATE INDEX idx_booking_orders_status ON booking_orders(status);
CREATE INDEX idx_booking_orders_created_at ON booking_orders(created_at DESC);
