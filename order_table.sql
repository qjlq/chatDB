CREATE TABLE chat(
	cid VARCHAR(40) PRIMARY KEY,
	uid VARCHAR(40),
	chat_data VARCHAR(300),
	chat_time VARCHAR(32),
	FOREIGN KEY (uid) REFERENCES `user`(uid)
)CHARSET=utf8;

CREATE TABLE product(
	pid VARCHAR(40) PRIMARY KEY,
	product_name VARCHAR(50) NOT NULL,
	description VARCHAR(80),
	picture VARCHAR(80),
	quantity INT CHECK(quantity >= 0),
	price DECIMAL CHECK(price >= 0)
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
