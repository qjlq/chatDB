INSERT INTO `product` (`pid`, `product_name`, `description`, `picture`, `quantity`, `price`) VALUES ('1', 'omni-Orxnge', '8V714kK2KS', 'computer.jpg', 564, 123);

INSERT INTO `link` (`lid`, `pid`, `sell_uid`) VALUES ('1', '1', 'visitor1');

INSERT INTO `order` (`oid`, `lid`, `buy_uid`, `Oquantity`, `total`, `Otime`, `Status`, `Lnumber`) VALUES ('1', '1', 'admin1', 605, 5, '09:41:07', 'unreceived', 'QRPpbzbXra');
INSERT INTO `order` (`oid`, `lid`, `buy_uid`, `Oquantity`, `total`, `Otime`, `Status`, `Lnumber`) VALUES ('2', '1', 'admin1', 605, 5, '09:41:07', 'unsent', 'QRPpbzbXra');
INSERT INTO `order` (`oid`, `lid`, `buy_uid`, `Oquantity`, `total`, `Otime`, `Status`, `Lnumber`) VALUES ('3', '1', 'admin1', 605, 5, '09:41:07', 'received', 'QRPpbzbXra');
