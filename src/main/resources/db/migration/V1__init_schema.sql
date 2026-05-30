CREATE TABLE "users"
(
    "id"               bigserial PRIMARY KEY,
    "first_name"       varchar,
    "last_name"        varchar,
    "email"            varchar UNIQUE NOT NULL,
    "password"         varchar        NOT NULL,
    "default_currency" char(3)        NOT NULL,
    "timezone"         varchar,
    "created_at"       timestamp,
    "updated_at"       timestamp
);

CREATE TABLE "transactions"
(
    "id"               bigserial PRIMARY KEY,
    "user_id"          bigint NOT NULL,
    "category_id"      bigint,
    "type"             varchar,
    "amount"           numeric(10, 2),
    "description"      text,
    "transaction_date" date   NOT NULL,
    "created_at"       timestamp,
    "updated_at"       timestamp
);

CREATE TABLE "categories"
(
    "id"          bigserial PRIMARY KEY,
    "user_id"     bigint  NOT NULL,
    "name"        varchar NOT NULL,
    "description" text,
    "color"       varchar,
    "active"      bool,
    "created_at"  timestamp,
    "updated_at"  timestamp
);

CREATE TABLE "budgets"
(
    "id"           bigserial PRIMARY KEY,
    "category_id"  bigint NOT NULL,
    "user_id"      bigint NOT NULL,
    "amount_limit" numeric(10, 2),
    "month"        int    NOT NULL,
    "year"         int    NOT NULL,
    "created_at"   timestamp,
    "updated_at"   timestamp
);

CREATE UNIQUE INDEX ON "categories" ("user_id", "name");

CREATE UNIQUE INDEX ON "budgets" ("user_id", "category_id", "month", "year");

ALTER TABLE "categories"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "transactions"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "budgets"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "transactions"
    ADD FOREIGN KEY ("category_id") REFERENCES "categories" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "budgets"
    ADD FOREIGN KEY ("category_id") REFERENCES "categories" ("id") DEFERRABLE INITIALLY IMMEDIATE;
