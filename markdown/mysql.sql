CREATE TABLE `bl_user` (
  `user_id` bigint(10) NOT NULL,
  `login_name` varchar(20) NOT NULL,
  `salt` varchar(20) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bl_role` (
  `role_id` bigint(20) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `tooltips` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '提示文本，用于前台',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_date` bigint(20) DEFAULT '0' COMMENT '更新日期',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色';

CREATE TABLE `bl_role_privilege` (
  `role_privilege_id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `privilege_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新日期',
  PRIMARY KEY (`role_privilege_id`),
  KEY `idx_role_privilege_role_id` (`role_id`),
  KEY `idx_role_privilege_privilege_id` (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限对应关系';

CREATE TABLE `util_seq` (
  `seq_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '序列号域ID',
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `note` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '说明',
  `current_value` bigint(20) DEFAULT NULL COMMENT '当前值',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录更新时间',
  PRIMARY KEY (`seq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='全局序列号工具表';

INSERT INTO `blog`.`util_seq` (`seq_id`, `name`, `note`, `current_value`, `create_time`, `update_time`) VALUES ('default', '缺省序列', '缺省序列', '100000000000000000', '2018-08-14 15:23:10', '2018-08-14 15:23:10');
INSERT INTO `blog`.`util_seq` (`seq_id`, `name`, `note`, `current_value`, `create_time`, `update_time`) VALUES ('int6', '6位整数', '用于生成6位整数的序列号', '100000', '2019-11-19 14:28:35', '2018-08-14 15:23:11');
INSERT INTO `blog`.`util_seq` (`seq_id`, `name`, `note`, `current_value`, `create_time`, `update_time`) VALUES ('int8', '8位整数', '用于生成8位整数的序列号', '10000000', '2019-11-19 14:28:35', '2018-08-14 15:23:11');

