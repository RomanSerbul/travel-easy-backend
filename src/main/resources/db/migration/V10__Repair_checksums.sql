-- Repair migration: This migration does nothing but forces Flyway to continue
-- The actual data updates were already applied in V9
-- This is a placeholder to fix any checksum issues

-- No-op migration to ensure Flyway can proceed
SELECT 1;
