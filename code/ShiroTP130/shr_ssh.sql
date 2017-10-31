/*
MySQL Data Transfer
Source Host: localhost
Source Database: demo_shiro
Target Host: localhost
Target Database: demo_shiro
Date: 2017/10/21 17:58:27
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

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
  `ur_password` varchar(200) DEFAULT NULL,
  `ur_salt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  UNIQUE KEY `ur_user_name` (`ur_user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

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
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `rl_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `shr_resource` VALUES ('33', '维护用户', '实现用户的增删改查，当前案例只实现添加用户功能');
INSERT INTO `shr_resource` VALUES ('34', '维护资源', '实现资源的CRUD');
INSERT INTO `shr_resource_item` VALUES ('43', '1', '/user/addUser.jsp', '添加用户的初始化页面URL', '33');
INSERT INTO `shr_resource_item` VALUES ('44', '1', '/userAction!add.action', '处理提交添加用户请求的URL', '33');
INSERT INTO `shr_resource_item` VALUES ('45', '2', '/resourceAction!edit.action', '修改资源请求URL', '34');
INSERT INTO `shr_resource_item` VALUES ('46', '1', '/resourceAction!add.action', '处理添加资源的请求URL', '34');
INSERT INTO `shr_resource_item` VALUES ('47', '8', '/resourceAction!view.action', '查看某个资源URL', '34');
INSERT INTO `shr_resource_item` VALUES ('48', '8', '/resourceAction!findAll.action', '查看所有资源列表URL', '34');
INSERT INTO `shr_resource_item` VALUES ('49', '1', '/resourceAction!initAdd.action', '初始化添加资源的页面URL', '34');
INSERT INTO `shr_role` VALUES ('9', 'role1', '角色1');
INSERT INTO `shr_role` VALUES ('10', 'role2', '角色2');
INSERT INTO `shr_role` VALUES ('11', 'role3', '角色3');
INSERT INTO `shr_role` VALUES ('12', 'admin', null);
INSERT INTO `shr_role` VALUES ('13', 'guest', null);
INSERT INTO `shr_user` VALUES ('20', 'admin', '$shiro1$SHA-512$1$$dZMkxWAiOBzSEjk+w0b2+z1/NX3omaw0boHcvMMHaLQ6b8+4E2X0OpF0ts4QWkEF1Npmr9P+mGk9f++pt+MUqQ==', 'yNlac+PHQr7PQ4Yu4cv3VQ==0');
INSERT INTO `shr_user` VALUES ('24', 'testUser1', '$shiro1$SHA-512$1$$ATnx89d9byJ10Wm5P/LqsLsjMP3TSIxtR82G8tVOum8aQCo7/Bn85wVXAaqaKsUK6k3lCSkn0iPJ61ryHL2drA==', 'qpfvGailYF7D3h7jR43TtQ==4');
INSERT INTO `shr_user` VALUES ('25', 'testUser2', '$shiro1$SHA-512$1$$+q2MuHOOIVJfm/8HqTbe3nA50Rukmnsw55rb75o4YpNgihKgRifpuZPUe2BHWPk34U92GJx3LgAXeexvWMJKaQ==', 'voR+Ewy4uSeEmN3XnhsDkA==0');
INSERT INTO `shr_user_permission` VALUES ('24', '34', '8', '6');
INSERT INTO `shr_user_permission` VALUES ('24', '33', '1', '7');
INSERT INTO `shr_user_permission` VALUES ('25', '34', '11', '8');
INSERT INTO `user_roles` VALUES ('1', 'role1', 'zhangsan');
INSERT INTO `user_roles` VALUES ('2', 'role2', 'zhangsan');
INSERT INTO `user_roles` VALUES ('3', 'role2', 'lisi');
INSERT INTO `user_roles` VALUES ('4', 'role3', 'wangwu');
INSERT INTO `user_roles` VALUES ('5', 'role4', 'wangwu');
