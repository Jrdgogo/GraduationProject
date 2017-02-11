USE traveling;
DROP TABLE IF EXISTS t_order;
CREATE TABLE IF NOT EXISTS t_order(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*套餐id*/
setMenuId VARCHAR(32),
/*订单人id*/
userId VARCHAR(32),
/*状态   0预付  1支付   2改签   3预约  4取消  */
status BIT DEFAULT 0,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_setMenuOrder FOREIGN KEY(setMenuId) REFERENCES t_viewsetmenu(id),
CONSTRAINT fk_userOrder FOREIGN KEY(userId) REFERENCES t_users(id)
);