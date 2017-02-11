USE traveling;
DROP TABLE IF EXISTS t_viewsetmenu;
CREATE TABLE IF NOT EXISTS t_viewsetmenu(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*景区id*/
viewId VARCHAR(32),
/*景点线路组合*/
setMenus VARCHAR(400) NOT NULL,
/*订单总次数*/
orderNum INT DEFAULT 0,
/*套餐价*/
orderPrice INT NOT NULL,
/*旅游天数*/
days INT NOT NULL DEFAULT 1,
/*游客上限人数*/
visitors INT,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_ViewSetMenu FOREIGN KEY(viewId) REFERENCES t_view(id)
);