-- Ensure sequence exists
CREATE SEQUENCE IF NOT EXISTS booking_order_number_seq START WITH 1001 INCREMENT BY 1;

-- Drop existing default if any
ALTER TABLE booking_orders
ALTER COLUMN order_number DROP DEFAULT;

-- Set default to use sequence
ALTER TABLE booking_orders
ALTER COLUMN order_number SET DEFAULT nextval('booking_order_number_seq');

-- Verify sequence ownership
ALTER SEQUENCE booking_order_number_seq OWNED BY booking_orders.order_number;
