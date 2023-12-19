DROP TABLE IF EXISTS `chart_user`;
CREATE TABLE `chart_user` (
  `uid` tinyint(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `chart_user` VALUES ('1', 'aa', '1');
INSERT INTO `chart_user` VALUES ('2', 'bb', '1');
INSERT INTO `chart_user` VALUES ('3', 'cc', '1');