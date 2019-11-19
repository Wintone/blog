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

