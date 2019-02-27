/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : tcmdata

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2018-05-02 09:54:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for surgery
-- ----------------------------
DROP TABLE IF EXISTS `surgery`;
CREATE TABLE `surgery` (
  `id` varchar(255) DEFAULT NULL,
  `RESIDENCE_NO` varchar(255) DEFAULT NULL,
  `SICK_ID` varchar(255) DEFAULT NULL,
  `VISIT_NUMBER` int(11) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `OPERAT_ITEM_NAME` varchar(255) DEFAULT NULL,
  `create_at` datetime NOT NULL,
  `delete_at` datetime DEFAULT NULL,
  `update_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of surgery
-- ----------------------------
INSERT INTO `surgery` VALUES ('1', '252197001', '0001110342', '1', '男', '尿道狭窄瘢痕切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('2', '258921001', '0001190541', '1', '女', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('3', '256329001', '0001159496', '1', '男', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('4', '262783001', '0001236266', '1', '男', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('5', '262512001', '0001229020', '1', '男', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('6', '266572001', '0001283090', '1', '男', '经输尿管镜碎石取石术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('7', '270239001', '0001266941', '1', '男', '颅内多发血肿清除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('8', '275856001', '0001382482', '1', '女', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('9', '280305001', '0001435358', '1', '男', '门体静脉断流术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('10', '280305001', '0001435358', '1', '男', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('11', '297209001', '0001622193', '1', '男', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('12', '259114004', '0001192196', '4', '女', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('13', '268144002', '0001127796', '2', '男', '白内障囊外摘除+人工晶体植入术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('14', '234491005', '0000913812', '5', '男', '颅骨修补术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('15', '256366001', '0001162015', '1', '男', '术中显微镜', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('16', '228304003', '0000838210', '3', '男', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('17', '269148001', '0001312216', '1', '女', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('18', '265430001', '0001268378', '1', '女', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('19', '271828001', '0001340722', '1', '男', '门体静脉断流术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('20', '278078001', '0001408045', '1', '男', '肛周常见疾病手术治疗', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('21', '279506001', '0001423674', '1', '女', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('22', '291453001', '0001554418', '1', '女', '翼状胬肉切除+角膜移植术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('23', '266567004', '0001282953', '4', '男', '脾切除术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('24', '265120001', '0001265093', '1', '女', '白内障囊外摘除+人工晶体植入术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
INSERT INTO `surgery` VALUES ('25', '269884001', '0001320594', '1', '女', '门体静脉断流术', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28');
