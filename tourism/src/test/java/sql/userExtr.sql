USE traveling;
DROP TABLE IF EXISTS t_userExtr;
CREATE TABLE IF NOT EXISTS t_userExtr(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*激活码*/
activeCode VARCHAR(40) NOT NULL,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
CONSTRAINT fk_userExtr FOREIGN KEY(id) REFERENCES t_users(id)
);
