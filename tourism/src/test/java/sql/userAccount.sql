USE traveling;
DROP TABLE IF EXISTS t_user_account;
CREATE TABLE IF NOT EXISTS t_user_account(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*用户名*/
userId VARCHAR(32),
/*支付密码*/
password VARCHAR(32) NOT NULL,
/*账户余额*/
money NUMERIC(11,2) NOT NULL DEFAULT 0.00,
/*账户状态  0冻结    1正常   */
status BIT NOT NULL DEFAULT 1,
/*信誉点*/
credit NUMERIC(4,2) DEFAULT 50.00,
/*支付卡号*/
defrayNo VARCHAR (90),
/*创建时间*/
createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,
/*更改时间*/
updateDate TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
CONSTRAINT fk_userAccount FOREIGN KEY(userId) REFERENCES t_users(id)
);
