DROP TABLE IF EXISTS `t_visitdate`;
CREATE TABLE IF NOT EXISTS `t_visitdate` (

  `id` varchar(32) PRIMARY KEY,
  `code` varchar(20) NOT NULL,
  `visitDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
