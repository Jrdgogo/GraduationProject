USE traveling;
DROP TABLE IF EXISTS t_hotelroom;
CREATE TABLE IF NOT EXISTS t_hotelroom(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*房间名称*/
roomName VARCHAR(20),
/*房间号*/
roomNo VARCHAR(10),
/*房间描述*/
roomDesc TEXT,
/*房间价格（一晚）*/
roomPrice TINYINT,
/*关联外键*/
hotelId VARCHAR(32),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_t_hotelroom FOREIGN KEY(hotelId) REFERENCES t_hotel(id)
);