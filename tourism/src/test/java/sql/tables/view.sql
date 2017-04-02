USE traveling;
DROP TABLE IF EXISTS t_view;
CREATE TABLE IF NOT EXISTS t_view(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*景区名称*/
viewName VARCHAR(40) NOT NULL,
/*景区代码*/
code VARCHAR(20) NOT NULL,
/*城市代码*/
cityCode VARCHAR(10),
/*景区关键字*/
viewKewWords VARCHAR(100),
/*景区概述*/
viewSummary VARCHAR(30),
/*景区详述*/
viewDesc TEXT,
/*景区季节  'Spring'-->1000,'Summer'-->0100,'Autumn'-->0010,'Winter'-->0001*/
viewSeason TINYINT,
/*折扣*/
rebate NUMERIC(3,2) NOT NULL DEFAULT 1.00,
/*欢迎度*/
visitNum INT DEFAULT 0,
/*地图x坐标*/
poisitX varchar(20),
/*地图y坐标*/
poisitY varchar(20),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_cityView FOREIGN KEY(cityCode) REFERENCES t_city(code)
);