/*
MySQL Data Transfer
Source Host: localhost
Source Database: demo_shiro
Target Host: localhost
Target Database: demo_shiro
Date: 2017/10/14 16:16:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for shr_demo_permission
-- ----------------------------
DROP TABLE IF EXISTS `shr_demo_permission`;
CREATE TABLE `shr_demo_permission` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_rl_dmpr_map
-- ----------------------------
DROP TABLE IF EXISTS `shr_rl_dmpr_map`;
CREATE TABLE `shr_rl_dmpr_map` (
  `rl_id` int(11) NOT NULL DEFAULT '0',
  `pr_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rl_id`,`pr_id`),
  KEY `pr_id` (`pr_id`),
  CONSTRAINT `shr_rl_dmpr_map_ibfk_1` FOREIGN KEY (`rl_id`) REFERENCES `shr_role` (`rl_id`),
  CONSTRAINT `shr_rl_dmpr_map_ibfk_2` FOREIGN KEY (`pr_id`) REFERENCES `shr_demo_permission` (`pr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_session
-- ----------------------------
DROP TABLE IF EXISTS `shr_session`;
CREATE TABLE `shr_session` (
  `session_id` varchar(200) NOT NULL DEFAULT '',
  `session_value` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `shr_demo_permission` VALUES ('1', '*');
INSERT INTO `shr_demo_permission` VALUES ('2', 'user:*');
INSERT INTO `shr_demo_permission` VALUES ('3', 'user:add');
INSERT INTO `shr_demo_permission` VALUES ('4', 'user:update');
INSERT INTO `shr_demo_permission` VALUES ('5', 'user:delete');
INSERT INTO `shr_demo_permission` VALUES ('6', 'user:view');
INSERT INTO `shr_resource` VALUES ('16', 'demo1', 'demoResource');
INSERT INTO `shr_resource` VALUES ('17', 'aaa', 'aa');
INSERT INTO `shr_resource` VALUES ('18', 'aaa1', 'aa1');
INSERT INTO `shr_resource` VALUES ('19', 'bbbb', 'bbb');
INSERT INTO `shr_resource` VALUES ('20', 'testAbc', 'teasw');
INSERT INTO `shr_resource` VALUES ('21', 'testAbc1', 'teasw1');
INSERT INTO `shr_resource` VALUES ('22', '测试资源', '测试资源');
INSERT INTO `shr_resource` VALUES ('23', '用户资源', '对用户管理的操作');
INSERT INTO `shr_resource` VALUES ('24', '订单资源', '官邸订单');
INSERT INTO `shr_resource` VALUES ('25', '11111111111', '11111111');
INSERT INTO `shr_resource` VALUES ('26', 'MyResource1', 'my resource1');
INSERT INTO `shr_resource` VALUES ('28', '用户资源2', '对用户管理的操作2');
INSERT INTO `shr_resource` VALUES ('29', 'newTest2', 'new test2');
INSERT INTO `shr_resource_item` VALUES ('13', '1', 'add', '', '19');
INSERT INTO `shr_resource_item` VALUES ('14', '2', 'update', '', '19');
INSERT INTO `shr_resource_item` VALUES ('15', '1', '', '', '19');
INSERT INTO `shr_resource_item` VALUES ('16', '1', '', '', '19');
INSERT INTO `shr_resource_item` VALUES ('17', '1', '', '', '21');
INSERT INTO `shr_resource_item` VALUES ('18', '1', '', '', '21');
INSERT INTO `shr_resource_item` VALUES ('19', '1', 'toAddUrl1', 'addd1', '21');
INSERT INTO `shr_resource_item` VALUES ('20', '2', 'toEditUrl1', 'edit1', '21');
INSERT INTO `shr_resource_item` VALUES ('21', '1', 'toAddUrl', '添加', '28');
INSERT INTO `shr_resource_item` VALUES ('22', '2', 'toEditUrl', '修改', '28');
INSERT INTO `shr_resource_item` VALUES ('23', '2', 'toEditUser.action', '修改用户2', '28');
INSERT INTO `shr_resource_item` VALUES ('24', '1', 'toAddUser.action', '添加用户', '28');
INSERT INTO `shr_resource_item` VALUES ('25', '2', 'toEditOrder.action', '修改订单', '24');
INSERT INTO `shr_resource_item` VALUES ('26', '1', 'toAddOrder.action', '添加订单', '24');
INSERT INTO `shr_resource_item` VALUES ('27', '2', 'edte1', 'edet1', '25');
INSERT INTO `shr_resource_item` VALUES ('28', '1', 'add1', 'add1', '25');
INSERT INTO `shr_resource_item` VALUES ('29', '1', 'myResource1Add.action', '', '26');
INSERT INTO `shr_resource_item` VALUES ('30', '2', 'myResource1Edit.action', '', '26');
INSERT INTO `shr_resource_item` VALUES ('31', '4', 'toDeleteUser.action', '删除用户', '28');
INSERT INTO `shr_resource_item` VALUES ('32', '2', 'edit', 'edit', '29');
INSERT INTO `shr_resource_item` VALUES ('33', '1', 'add', 'add', '29');
INSERT INTO `shr_resource_item` VALUES ('34', '4', 'delete', 'delete', '29');
INSERT INTO `shr_rl_dmpr_map` VALUES ('12', '1');
INSERT INTO `shr_rl_dmpr_map` VALUES ('11', '2');
INSERT INTO `shr_rl_dmpr_map` VALUES ('11', '3');
INSERT INTO `shr_rl_dmpr_map` VALUES ('10', '4');
INSERT INTO `shr_rl_dmpr_map` VALUES ('9', '5');
INSERT INTO `shr_rl_dmpr_map` VALUES ('9', '6');
INSERT INTO `shr_rl_dmpr_map` VALUES ('13', '6');
INSERT INTO `shr_role` VALUES ('9', 'role1', '角色1');
INSERT INTO `shr_role` VALUES ('10', 'role2', '角色2');
INSERT INTO `shr_role` VALUES ('11', 'role3', '角色3');
INSERT INTO `shr_role` VALUES ('12', 'admin', null);
INSERT INTO `shr_role` VALUES ('13', 'guest', null);
INSERT INTO `shr_role` VALUES ('14', 'dHello', 'demo hello');
INSERT INTO `shr_role` VALUES ('15', 'myDemo1', 'my demo1');
INSERT INTO `shr_role_permission` VALUES ('9', '16', '8', '1');
INSERT INTO `shr_role_permission` VALUES ('10', '17', '5', '2');
INSERT INTO `shr_ur_rl_map` VALUES ('3', '10');
INSERT INTO `shr_ur_rl_map` VALUES ('1', '11');
INSERT INTO `shr_ur_rl_map` VALUES ('1', '12');
INSERT INTO `shr_ur_rl_map` VALUES ('2', '13');
INSERT INTO `shr_user` VALUES ('1', 'zhangsan', '123456', null);
INSERT INTO `shr_user` VALUES ('2', 'lisi', '123456', null);
INSERT INTO `shr_user` VALUES ('3', 'wangwu', '123456', null);
