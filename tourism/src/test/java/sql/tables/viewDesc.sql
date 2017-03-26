USE traveling;
DROP TABLE IF EXISTS t_view_desc;
CREATE TABLE IF NOT EXISTS t_view_desc(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*村情概况*/
viewDesc TEXT,
/*历史传承*/
viewHistory TEXT,
/*位置信息*/
positionMsg TEXT,
/*门票信息*/
ticketMsg TEXT,
/*开放时间  */
openTime VARCHAR(60),
/*用时参考  */
palyTime VARCHAR(60),
/*气候  */
weather TEXT,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_viewDesc FOREIGN KEY(id) REFERENCES t_view(id)
);