USE traveling;
DROP TABLE IF EXISTS t_visitdate;
CREATE TABLE IF NOT EXISTS t_visitdate(
/*主键*/
id VARCHAR(32) PRIMARY KEY,
/*景区、景点代码 */
code VARCHAR(20) NOT NULL,
/*游玩时间*/
visitDate TIMESTAMP NOT NULL
);