USE traveling;
DROP TABLE IF EXISTS t_news;
CREATE TABLE IF NOT EXISTS t_news(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*新闻标题*/
title VARCHAR(40) NOT NULL,
/*景区外键*/
viewId VARCHAR(32),
/*新闻链接*/
newsUrl VARCHAR(80),
/*新闻详述*/
newsContext TEXT,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更新时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_viewNews FOREIGN KEY(viewId) REFERENCES t_view(id)
);