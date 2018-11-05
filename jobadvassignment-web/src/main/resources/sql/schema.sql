CREATE SCHEMA IF NOT EXISTS test_schema;

CREATE TABLE IF NOT EXISTS test_schema.Applicant
(
    id VARCHAR(50) PRIMARY KEY NOT NULL
);

INSERT INTO test_schema.Applicant VALUES ('10000');