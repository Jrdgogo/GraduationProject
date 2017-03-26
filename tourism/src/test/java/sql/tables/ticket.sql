USE traveling;
DROP TABLE IF EXISTS t_ticket_?Day;
CREATE TABLE IF NOT EXISTS t_ticket_?Day(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*套餐id*/
setMenuId VARCHAR(32),
/*票号*/
number TINYINT NOT NULL,
/*状态  0未出售   1已出售 */
status BIT NOT NULL DEFAULT 0,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
FOREIGN KEY(setMenuId) REFERENCES t_viewsetmenu(id)
);