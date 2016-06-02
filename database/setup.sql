CREATE DATABASE jsontest;
-- CONNECT jsontest;
-- DROP SCHEMA jsontest;
-- DROP TABLE jsontest.report;
CREATE SCHEMA jsontest;
CREATE TABLE jsontest.report (
  report_id SERIAL PRIMARY KEY NOT NULL,
  name  TEXT  NOT NUll,
  parameters json
);

select * FROM jsontest.report;

-- Inserts into the table fine
INSERT INTO jsontest.report (name, parameters)
VALUES ('Test 1', '{"param1" : "ABBA"}') ;