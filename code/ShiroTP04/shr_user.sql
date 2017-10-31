/*
MySQL Data Transfer
Source Host: localhost
Source Database: demo_shiro
Target Host: localhost
Target Database: demo_shiro
Date: 2017/9/20 13:49:14
*/

SET FOREIGN_KEY_CHECKS=0;
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

) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `shr_user` VALUES ('39', 'zhangsan', '123456', 'test');
INSERT INTO `shr_user` VALUES ('40', 'lisi', 'abc123', 'test');
INSERT INTO `shr_user` VALUES ('41', 'wangwu', 'abcefg', 'test');
