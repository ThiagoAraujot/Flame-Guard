CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE alert (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    image_id UUID REFERENCES image(id),
    danger_level VARCHAR(50), -- LOW, MEDIUM, HIGH
    confirmed BOOLEAN DEFAULT FALSE,
    reported_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);