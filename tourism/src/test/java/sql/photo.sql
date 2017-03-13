USE traveling;
DROP TABLE IF EXISTS t_photo;
CREATE TABLE IF NOT EXISTS t_photo(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*景区、景点代码、网站代码jiangnan、酒店代码、餐馆代码*/
code VARCHAR(30) NOT NULL DEFAULT 'jiangnan',
/*照片  根据code不同存取各类图片*/
photo LONGBLOB
);