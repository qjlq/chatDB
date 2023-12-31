DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	`uid` varchar(40) PRIMARY KEY,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
	`sex` char(1) CHECK((sex='男') OR (sex='女')) NOT NULL,
	`phone` varchar(20) NOT NULL UNIQUE,
	`is_admin` int,
	`is_delete` int,
	`create_time` VARCHAR(32)
)CHARSET=utf8;

INSERT INTO `user` (`uid`, `username`, `password`, `sex`, `phone`, `is_admin`, `is_delete`, `create_time`) VALUES
('admin1', 'admin', 'admin', '男', '13709620408', 1, 0, NULL),
('visitor1', 'visitor','visitor', '男', '18858362363', 0, 1, NULL);

