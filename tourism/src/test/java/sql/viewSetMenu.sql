USE traveling;
DROP TABLE IF EXISTS t_viewsetmenu;
CREATE TABLE IF NOT EXISTS t_viewsetmenu(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*套餐名*/
menuName VARCHAR(40) NOT NULL UNIQUE,
/*套餐描述*/
menuDesc TEXT ,
/*景区id*/
viewId VARCHAR(32),
/*订单总次数*/
orderNum INT DEFAULT 0,
/*套餐价*/
orderPrice NUMERIC(7,2) NOT NULL,
/*折扣*/
rebate NUMERIC(3,2) NOT NULL DEFAULT 1.00,
/*旅游天数*/
days INT NOT NULL DEFAULT 1,
/*游客上限人数*/
visitors INT DEFAULT 60,
/*景票类型*/
ticketTypeId VARCHAR(32),
/*费用清单*/
expenseInvoices VARCHAR(255),
/*使用方法*/
usageMethod TEXT,
/*预约生效时间*/
activeDate VARCHAR(60),
/*退改规则*/
backRule VARCHAR(128) DEFAULT '请于 个人中心-->订单详情 进行相应操作',
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_ViewSetMenu FOREIGN KEY(viewId) REFERENCES t_view(id),
CONSTRAINT fk_tivketType FOREIGN KEY(ticketTypeId) REFERENCES t_ticket_type(id)
);