/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-06-11 16:00:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xi` varchar(255) DEFAULT NULL,
  `qudui` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `sno` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '计算机', '区队1', 'maker', 's001');
INSERT INTO `user` VALUES ('2', '333', 'aa', '123456', '123456');
INSERT INTO `user` VALUES ('3', 'dd', 'aa', '123456', '123456');
INSERT INTO `user` VALUES ('4', 'dd', 'aa', '123456', '123456');
INSERT INTO `user` VALUES ('9', '信息技术与管理系', '信安183', '朱匡易', '201811062');
