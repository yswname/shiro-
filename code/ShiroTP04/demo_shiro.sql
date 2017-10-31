/*
MySQL Data Transfer
Source Host: localhost
Source Database: demo_shiro
Target Host: localhost
Target Database: demo_shiro
Date: 2017/9/21 15:57:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for shr_resource
-- ----------------------------
DROP TABLE IF EXISTS `shr_resource`;
CREATE TABLE `shr_resource` (
  `rsc_id` int(11) NOT NULL AUTO_INCREMENT,
  `rsc_name` varchar(50) DEFAULT NULL,
  `rsc_remark` varchar(200) DEFAULT NULL COMMENT '权限操作码\r\n1 创建\r\n2 修改\r\n4 删除\r\n8 查看\r\n16 打印\r\n32 其他\r\n64 其他',
  PRIMARY KEY (`rsc_id`),
  UNIQUE KEY `pms_resource_name` (`rsc_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_resource_item
-- ----------------------------
DROP TABLE IF EXISTS `shr_resource_item`;
CREATE TABLE `shr_resource_item` (
  `itm_id` int(11) NOT NULL AUTO_INCREMENT,
  `itm_type` int(11) NOT NULL COMMENT '1 创建 2修改 4删除 8查看 16打印 32其他 64其他',
  `itm_url` varchar(200) DEFAULT NULL,
  `itm_remark` varchar(500) DEFAULT NULL,
  `itm_rsc_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`itm_id`),
  KEY `itm_rsc_id` (`itm_rsc_id`),
  CONSTRAINT `shr_resource_item_ibfk_1` FOREIGN KEY (`itm_rsc_id`) REFERENCES `shr_resource` (`rsc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_role
-- ----------------------------
DROP TABLE IF EXISTS `shr_role`;
CREATE TABLE `shr_role` (
  `rl_id` int(11) NOT NULL AUTO_INCREMENT,
  `rl_name` varchar(50) NOT NULL,
  `rl_remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`rl_id`),
  UNIQUE KEY `rl_name` (`rl_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `shr_role_permission`;
CREATE TABLE `shr_role_permission` (
  `prm_rl_id` int(11) NOT NULL,
  `prm_rsc_id` int(11) NOT NULL,
  `prm_operation_code` int(11) NOT NULL,
  `prm_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`prm_id`),
  KEY `prm_rl_id` (`prm_rl_id`),
  KEY `prm_rsc_id` (`prm_rsc_id`),
  CONSTRAINT `shr_role_permission_ibfk_1` FOREIGN KEY (`prm_rl_id`) REFERENCES `shr_role` (`rl_id`),
  CONSTRAINT `shr_role_permission_ibfk_2` FOREIGN KEY (`prm_rsc_id`) REFERENCES `shr_resource` (`rsc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_ur_rl_map
-- ----------------------------
DROP TABLE IF EXISTS `shr_ur_rl_map`;
CREATE TABLE `shr_ur_rl_map` (
  `ur_id` int(11) NOT NULL,
  `rl_id` int(11) NOT NULL,
  PRIMARY KEY (`ur_id`,`rl_id`),
  KEY `rl_id` (`rl_id`),
  CONSTRAINT `shr_ur_rl_map_ibfk_1` FOREIGN KEY (`ur_id`) REFERENCES `shr_user` (`ur_id`),
  CONSTRAINT `shr_ur_rl_map_ibfk_2` FOREIGN KEY (`rl_id`) REFERENCES `shr_role` (`rl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_user
-- ----------------------------
DROP TABLE IF EXISTS `shr_user`;
CREATE TABLE `shr_user` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `ur_user_name` varchar(20) NOT NULL,
  `ur_password` varchar(100) DEFAULT NULL,
  `ur_salt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  UNIQUE KEY `ur_user_name` (`ur_user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `shr_user_permission`;
CREATE TABLE `shr_user_permission` (
  `prm_ur_id` int(11) NOT NULL DEFAULT '0',
  `prm_rsc_id` int(11) NOT NULL DEFAULT '0',
  `prm_operation_code` int(11) DEFAULT NULL,
  `prm_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`prm_id`),
  KEY `prm_ur_id` (`prm_ur_id`),
  KEY `prm_rsc_id` (`prm_rsc_id`),
  CONSTRAINT `shr_user_permission_ibfk_1` FOREIGN KEY (`prm_ur_id`) REFERENCES `shr_user` (`ur_id`),
  CONSTRAINT `shr_user_permission_ibfk_2` FOREIGN KEY (`prm_rsc_id`) REFERENCES `shr_resource` (`rsc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
