USE traveling;
DROP TABLE IF EXISTS t_comment;
CREATE TABLE IF NOT EXISTS t_comment(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*景区、景点代码 、网站代码jiangnan、酒店代码、餐馆代码*/
code VARCHAR(30) NOT NULL DEFAULT 'jiangnan',
/*评论  根据code不同存取各类评论*/
viewDesc VARCHAR(800),
/*评论用户id*/
userId VARCHAR(32),
/*状态   0删除*/
status BIT DEFAULT 1,
/*点赞数*/
argueNum INT DEFAULT 0,
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
CONSTRAINT fk_userComment FOREIGN KEY(userId) REFERENCES t_users(id)
);