USE traveling;
DROP TABLE IF EXISTS t_users;
CREATE TABLE IF NOT EXISTS t_users(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*用户名*/
userName VARCHAR(40) NOT NULL UNIQUE,
/*密码*/
password VARCHAR(32) NOT NULL,
/*真实姓名*/
realName VARCHAR (60),
/*用户状态 0未激活    1激活   2注销*/
status TINYINT UNSIGNED NOT NULL DEFAULT 0,
/*联系号码*/
phone VARCHAR (60),
/*邮箱*/
email VARCHAR (90) NOT NULL,
/*性别*/
sex ENUM('man','woman'),
/*生日*/
birth DATE,
/*居住地址*/
address VARCHAR (240),
/*照片*/
photo BLOB ,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更改时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);
