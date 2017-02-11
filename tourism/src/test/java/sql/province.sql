USE traveling;
DROP TABLE IF EXISTS t_province;
CREATE TABLE IF NOT EXISTS t_province(
/*省份名称*/
name VARCHAR(40) NOT NULL UNIQUE,
/*省份代码 主键*/
nameCode VARCHAR(10) PRIMARY KEY ,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);