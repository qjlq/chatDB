DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	`uid` varchar(40) PRIMARY KEY,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
	`sex` char(1) CHECK((sex='男') OR (sex='女')) NOT NULL,
	`phone` varchar(20) NOT NULL UNIQUE,
	`is_admin` int,
	`is_delete` int,
	`create_time` VARCHAR(32),
	`money` DECIMAL CHECK(money >= 0)
	
)CHARSET=utf8;

INSERT INTO `user` (`uid`, `username`, `password`, `sex`, `phone`, `is_admin`, `is_delete`, `create_time`) VALUES
('admin1', 'admin', 'admin', '男', '13709620408', 1, 0, NULL),
('visitor1', 'visitor','visitor', '男', '18858362354', 0, 0, NULL),
('visitor2', 'visitor2','visitor2', '男', '18858361263', 0, 1, NULL);

CREATE TABLE chat(
	cid VARCHAR(40) PRIMARY KEY,
	uid VARCHAR(40),
	chat_data VARCHAR(300),
	chat_time VARCHAR(32),
-- 	FOREIGN KEY (uid) REFERENCES `user`(uid)
)CHARSET=utf8;

CREATE TABLE product(
	pid VARCHAR(40) PRIMARY KEY,
	product_name VARCHAR(50) NOT NULL,
	description VARCHAR(80),
	picture VARCHAR(80),
	quantity INT CHECK(quantity >= 0),
	price DECIMAL CHECK(price >= 0),
	addres  VARCHAR(80)
	Statust char(1) CHECK((Statust='Y') OR (Statust='N')) NOT NULL,
)CHARSET=utf8;

CREATE TABLE link(
	lid VARCHAR(40) PRIMARY KEY,
	pid VARCHAR(40),
	FOREIGN KEY (pid) REFERENCES product(pid),
	sell_uid VARCHAR(40),
	FOREIGN KEY (sell_uid) REFERENCES `user`(uid)
) CHARSET=utf8;

CREATE TABLE `order`(
	oid VARCHAR(40) PRIMARY KEY,
	lid VARCHAR(40),
	FOREIGN KEY (lid) REFERENCES link(lid),
	buy_uid VARCHAR(40),
	FOREIGN KEY (buy_uid) REFERENCES `user`(uid),
	Oquantity int CHECK(Oquantity >= 0),
	total DECIMAL CHECK(total >= 0), 
	Otime VARCHAR(32),
	`Status` VARCHAR(20) NOT NULL,
	Lnumber VARCHAR(40) NOT NULL
)CHARSET=utf8;