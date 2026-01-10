-- Create media table for tracking uploaded files
CREATE TABLE media (
    id VARCHAR(36) PRIMARY KEY,
    url TEXT NOT NULL UNIQUE,
    file_name VARCHAR(255) NOT NULL,
    object_key TEXT NOT NULL,
    size BIGINT NOT NULL,
    uploaded_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_media_uploaded_at ON media(uploaded_at DESC);
