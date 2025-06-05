CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE location (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    mission_id UUID REFERENCES mission(id),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6),
    captured_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);