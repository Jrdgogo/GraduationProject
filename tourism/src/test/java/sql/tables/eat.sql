USE traveling;
DROP TABLE IF EXISTS t_eat;
CREATE TABLE IF NOT EXISTS t_eat(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*美食名称*/
eatName VARCHAR(40),
/*美食代码*/
code VARCHAR(30) NOT NULL UNIQUE,
/*景区id*/
viewId VARCHAR(32),
/*美食详述*/
eatDesc TEXT,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_ViewEat FOREIGN KEY(viewId) REFERENCES t_view(id)
);