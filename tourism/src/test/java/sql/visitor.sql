USE traveling;
DROP TABLE IF EXISTS t_visitors;
CREATE TABLE IF NOT EXISTS t_visitors(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*用户id*/
userId VARCHAR(32),
/*真实姓名*/
realName VARCHAR (20) NOT NULL,
/*身份证号码*/
idcardNo VARCHAR (20) NOT NULL,
/*联系号码*/
phone VARCHAR (60),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更改时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_userVisitor FOREIGN KEY(userId) REFERENCES t_users(id)
);
