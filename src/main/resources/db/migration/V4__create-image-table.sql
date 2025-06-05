CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE image (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    location_id UUID REFERENCES location(id),
    url TEXT,
    type VARCHAR(50), -- PHOTO, THERMAL
    captured_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);