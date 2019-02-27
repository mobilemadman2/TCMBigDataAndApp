/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : tcmdata

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2018-05-02 09:54:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mainrecord
-- ----------------------------
DROP TABLE IF EXISTS `mainrecord`;
CREATE TABLE `mainrecord` (
  `id` varchar(255) DEFAULT NULL,
  `RESIDENCE_NO` varchar(255) DEFAULT NULL,
  `VISIT_NUMBER` bigint(20) DEFAULT NULL,
  `SICK_ID` varchar(255) DEFAULT NULL,
  `SICK_NAME` varchar(255) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `CONFIRM` varchar(255) DEFAULT NULL,
  `EXIT_REASON` text,
  `TO_DATE(A.ADMISSION_TIME)` varchar(255) DEFAULT NULL,
  `admi_year` varchar(255) DEFAULT NULL,
  `TO_DATE(A.DISCHARGE_TIME)` varchar(255) DEFAULT NULL,
  `INDAY` int(11) DEFAULT NULL,
  `INDAYS` int(11) DEFAULT NULL,
  `DISEASE_STATUS` varchar(255) DEFAULT NULL,
  `NOW_DIAGNOSIS` text,
  `SUM_COST` double DEFAULT NULL,
  `create_at` datetime NOT NULL,
  `delete_at` datetime DEFAULT NULL,
  `update_at` datetime NOT NULL,
  `to_date_a_admission_time_` varchar(255) DEFAULT NULL,
  `to_date_a_discharge_time_` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainrecord
-- ----------------------------
INSERT INTO `mainrecord` VALUES ('2804', '234491005', '5', '0000913812', '', '73', '男', '停用', '变异', '路径执行错误', '41666', '2014', '41759', '93', '3', '好转', '脑梗死', '59135.57', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('1881', '248970001', '1', '0000302375', '', '85', '男', '停用', '', '', '41688', '2014', '41783', '95', '3', '好转', '脑梗死', '250543.37', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('2078', '249660001', '1', '0001083256', '', '82', '女', '停用', '变异', '不符合', '41697', '2014', '41740', '43', '14', '好转', '短暂性脑缺血发作,脑梗死（急性期），脑血管造影+支架置入术', '128111.46', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('1950', '207722033', '33', '0000001398', '', '88', '女', '停用', '变异', '证型不符合', '41705', '2014', '41750', '45', '3', '好转', '脑梗死', '49970.77', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('409', '251813001', '1', '0000886745', '', '74', '女', '停用', '变异', '短暂性脑缺血发作', '41726', '2014', '41739', '13', '14', '治愈', '短暂性脑缺血发作', '6259.86', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('1662', '252085001', '1', '0001109158', '', '64', '男', '停用', '变异', '中风病慢性期', '41730', '2014', '41774', '44', '3', '好转', '脑梗死', '28454.14', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('2296', '228604003', '3', '0000820051', '', '74', '女', '停用', '', '', '41731', '2014', '41737', '6', '3', '好转', '脑梗死', '5965.35', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('2952', '247381002', '2', '0001060990', '', '69', '男', '停用', '', '', '41731', '2014', '41737', '6', '3', '好转', '脑梗死', '9275.98', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
INSERT INTO `mainrecord` VALUES ('3381', '252179001', '1', '0001110180', '', '84', '女', '停用', '', '', '41731', '2014', '41742', '11', '3', '好转', '脑梗死', '9745.19', '2018-05-20 17:27:28', null, '2018-05-20 17:27:28', null, null);
