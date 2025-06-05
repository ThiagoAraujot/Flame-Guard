CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE drone (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    identifier VARCHAR(100) NOT NULL,
    model VARCHAR(100),
    status VARCHAR(50), -- ACTIVE, MAINTENANCE, UNAVAILABLE
    autonomy_minutes INTEGER,
    water_capacity_ml INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);