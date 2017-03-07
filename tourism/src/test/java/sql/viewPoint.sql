USE traveling;
DROP TABLE IF EXISTS t_viewpoint;
CREATE TABLE IF NOT EXISTS t_viewpoint(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*景点名称*/
viewPointName VARCHAR(40) NOT NULL,
/*景点代码*/
code VARCHAR(30) NOT NULL,
/*景点概述*/
viewPointSummary VARCHAR(30),
/*景点详述*/
viewPointDesc TEXT,
/*景点门票 单位（￥）*/
viewTicket TINYINT NOT NULL DEFAULT 0,
/*欢迎度*/
visitNum INT DEFAULT 0,
/*景区id 关联外键*/
viewId VARCHAR(32),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更改时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,

CONSTRAINT fk_View FOREIGN KEY(viewId) REFERENCES t_view(id)
);