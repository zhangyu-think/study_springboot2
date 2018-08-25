SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `addtime` datetime DEFAULT NULL COMMENT '建立时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', '王译晨', '18', '女', null);
INSERT INTO `user` VALUES ('9', null, null, null, '2018-08-23 00:00:00');
INSERT INTO `user` VALUES ('10', '王译晨', '18', '女', '2018-08-23 11:41:05');
INSERT INTO `user` VALUES ('11', '王译晨', '18', '女', '2018-08-23 11:41:05');
INSERT INTO `user` VALUES ('12', '王译晨', '18', '女', '2018-08-23 11:41:05');
