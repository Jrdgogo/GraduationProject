USE traveling;
DROP TABLE IF EXISTS t_ticket_type;
CREATE TABLE IF NOT EXISTS t_ticket_type(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*类型*/
code VARCHAR(32) NOT NULL,
/*名称*/
typeDesc VARCHAR(32) NOT NULL
);