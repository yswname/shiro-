/*
MySQL Data Transfer
Source Host: localhost
Source Database: demo_shiro
Target Host: localhost
Target Database: demo_shiro
Date: 2017/9/25 14:23:40
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

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `shr_view_role_permission` AS select `rl`.`rl_name` AS `rl_name`,`pr`.`pr_desc` AS `pr_desc` from ((`shr_role` `rl` join `shr_demo_permission` `pr`) join `shr_rl_dmpr_map` `mp`) where ((`rl`.`rl_id` = `mp`.`rl_id`) and (`mp`.`pr_id` = `pr`.`pr_id`));

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `shr_view_user_role` AS select `rl`.`rl_name` AS `rl_name`,`ur`.`ur_user_name` AS `ur_user_name` from ((`shr_role` `rl` join `shr_user` `ur`) join `shr_ur_rl_map` `mp`) where ((`rl`.`rl_id` = `mp`.`rl_id`) and (`mp`.`ur_id` = `ur`.`ur_id`));

