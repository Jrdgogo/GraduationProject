USE traveling;
DROP TABLE IF EXISTS t_hotel;
CREATE TABLE IF NOT EXISTS t_hotel(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*酒店名称*/
hotelName VARCHAR(40),
/*酒店号码*/
hotelPhone VARCHAR(20),
/*酒店代码*/
code VARCHAR(20) NOT NULL UNIQUE,
/*景区id*/
viewId VARCHAR(32),
/*酒店详述*/
hotelDesc TEXT,
/*酒店类别*/
hotelCategory VARCHAR(20),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_ViewHotel FOREIGN KEY(viewId) REFERENCES t_view(id)
);