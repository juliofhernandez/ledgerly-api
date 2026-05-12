CREATE TABLE transactions (
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    category VARCHAR(100) NOT NULL,
    description TEXT,
    transaction_date DATE NOT NULL
);