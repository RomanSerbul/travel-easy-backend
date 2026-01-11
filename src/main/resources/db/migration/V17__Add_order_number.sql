-- Create sequence for order numbers
CREATE SEQUENCE booking_order_number_seq START WITH 1001 INCREMENT BY 1;

-- Add order_number column to booking_orders table with default sequence value
ALTER TABLE booking_orders
ADD COLUMN order_number BIGINT UNIQUE DEFAULT nextval('booking_order_number_seq');

-- Update existing records with order numbers (if table already has data)
WITH numbered_orders AS (
  SELECT id, ROW_NUMBER() OVER (ORDER BY created_at ASC) + 1000 as num
  FROM booking_orders
  WHERE order_number IS NULL
)
UPDATE booking_orders
SET order_number = numbered_orders.num
FROM numbered_orders
WHERE booking_orders.id = numbered_orders.id;

-- Make order_number NOT NULL
ALTER TABLE booking_orders
ALTER COLUMN order_number SET NOT NULL;

-- Create index on order_number
CREATE INDEX idx_booking_orders_order_number ON booking_orders(order_number);
