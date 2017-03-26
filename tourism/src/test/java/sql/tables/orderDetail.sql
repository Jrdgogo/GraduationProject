USE traveling;
DROP TABLE IF EXISTS t_orderdetail;
CREATE TABLE IF NOT EXISTS t_orderdetail(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*订单id*/
orderId VARCHAR(32),
/*票号id*/
ticketId VARCHAR(32) NOT NULL,
/*游客id*/
visitorId VARCHAR(32),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_order FOREIGN KEY(orderId) REFERENCES t_order(id),
CONSTRAINT fk_visitor FOREIGN KEY(visitorId) REFERENCES t_visitors(id)
);