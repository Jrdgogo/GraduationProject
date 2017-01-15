USE traveling;
DROP TABLE IF EXISTS t_users;
CREATE TABLE IF NOT EXISTS t_users(
id VARCHAR(32) PRIMARY KEY,
username VARCHAR(40),
password VARCHAR(32),
realName VARCHAR (60),
/*0未激活    1激活   2注销*/
status TINYINT UNSIGNED DEFAULT 0,
phone VARCHAR (60),
email VARCHAR (90) NOT NULL,
sex ENUM('man','woman'),
birth DATE,
address VARCHAR (240),
photo BLOB ,
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp
);
INSERT INTO t_users(id,username,password,email) VALUES('U001','Jack','123','1477450172@qq.com');
