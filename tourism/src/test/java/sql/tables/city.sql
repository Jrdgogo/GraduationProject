USE traveling;
DROP TABLE IF EXISTS t_city;
CREATE TABLE IF NOT EXISTS t_city(
/*城市名称*/
name VARCHAR(40) NOT NULL,
/*城市代码 主键*/
code VARCHAR(10) PRIMARY KEY,
/*省份代码  关联外键*/
provinceCode VARCHAR(10),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更改时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_provCity FOREIGN KEY(provinceCode) REFERENCES t_province(nameCode)
);