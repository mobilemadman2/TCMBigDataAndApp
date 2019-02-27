/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : tcmdata

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2018-10-22 15:28:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime NOT NULL,
  `delete_at` datetime DEFAULT NULL,
  `update_at` datetime NOT NULL,
  `account` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2017-12-08 11:12:19', null, '2018-09-25 14:13:59', 'root', 'root@qq.com', '$2a$10$/PMGLciykyk/jz7Z9D8B3.lEB73PXhM3qdE8aCX060c2HUT19yieu', '1', null);
INSERT INTO `user` VALUES ('2', '2018-09-25 16:47:16', null, '2018-09-25 16:47:16', 'user1', 'password', '$2a$10$ADyIbt/..UEXiMIYFUbIxO2qp8j1J.38SQbpLV4AKtUiy8gqESbrC', null, 'password');
