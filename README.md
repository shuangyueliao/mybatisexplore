// 初始化数据库  
CREATE DATABASE test default charset=utf8;

CREATE TABLE `user` (
  `name` varchar(64) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;