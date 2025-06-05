CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE mission (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    drone_id UUID REFERENCES drone(id),
    type VARCHAR(50), -- MONITORING, COMBAT, TEST
    status VARCHAR(50), -- IN_PROGRESS, COMPLETED, FAILED
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    description TEXT
);