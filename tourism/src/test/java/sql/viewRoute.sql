USE traveling;
DROP TABLE IF EXISTS t_viewroute;
CREATE TABLE IF NOT EXISTS t_viewroute(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*景区id*/
viewId VARCHAR(32),
/*景点线路*/
routes VARCHAR(400) NOT NULL,
/*线路估算价*/
routePrice INT NOT NULL,
/*订单总次数*/
orderNum INT DEFAULT 0,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_ViewRoute FOREIGN KEY(viewId) REFERENCES t_view(id)
);