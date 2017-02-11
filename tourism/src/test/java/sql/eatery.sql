USE traveling;
DROP TABLE IF EXISTS t_eatery;
CREATE TABLE IF NOT EXISTS t_eatery(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*餐馆名称*/
eateryName VARCHAR(40),
/*餐馆代码*/
code VARCHAR(20) NOT NULL UNIQUE,
/*景区id*/
viewId VARCHAR(32),
/*餐馆详述*/
eateryDesc TEXT,
/*餐馆类别*/
eateryCategory VARCHAR(20),
/*人均消费*/
consume TINYINT,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_ViewEatery FOREIGN KEY(viewId) REFERENCES t_view(id)
);