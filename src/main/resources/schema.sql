CREATE SEQUENCE IF NOT EXISTS PUBLIC.TASK_SEQ;

CREATE TABLE IF NOT EXISTS PUBLIC.Task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_on TIMESTAMP NOT NULL,
    updated_on TIMESTAMP,
    completed boolean
);