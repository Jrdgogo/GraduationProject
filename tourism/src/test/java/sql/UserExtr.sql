USE traveling;
DROP TABLE IF EXISTS t_userExtr;
CREATE TABLE IF NOT EXISTS t_userExtr(
id VARCHAR(32) PRIMARY KEY,
activecode VARCHAR(40),
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp
);
