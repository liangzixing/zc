CREATE TABLE `zc_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `creator` varchar(100) DEFAULT NULL,
  `modifier` varchar(100) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` varchar(3) DEFAULT 'n',
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mobile` varchar(100) DEFAULT NULL,
  `is_enable` varchar(3) DEFAULT 'y',
  `is_black` varchar(3) DEFAULT 'n',
  `is_lock` varchar(3) DEFAULT 'n',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `zc_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `creator` varchar(100) DEFAULT NULL,
  `modifier` varchar(100) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` varchar(3) DEFAULT 'n',
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `role_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `zc_user_role_relation` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `creator` varchar(100) DEFAULT NULL,
  `modifier` varchar(100) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` varchar(3) DEFAULT 'n',
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `role_id` bigint(20) unsigned DEFAULT NULL,
  `role_code` varchar(100) DEFAULT NULL,
  `effect_start_date` datetime DEFAULT NULL,
  `effect_end_date` datetime DEFAULT NULL,
  `is_long_effect` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `creator` varchar(100) DEFAULT NULL,
  `modifier` varchar(100) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` varchar(100) DEFAULT 'n',
  `company` varchar(100) DEFAULT NULL,
  `company_code` varchar(100) DEFAULT NULL,
  `contact_name` varchar(100) DEFAULT NULL,
  `contact_mobile` varchar(100) DEFAULT NULL,
  `contact_email` varchar(100) DEFAULT NULL,
  `account_type` varchar(100) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `balance` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `customer_manage` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `creator` varchar(100) DEFAULT NULL,
  `modifier` varchar(100) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` varchar(3) DEFAULT 'n',
  `customer_id` bigint(20) unsigned DEFAULT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_group_id` bigint(20) DEFAULT NULL,
  `user_group_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer_tally` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `creator` varchar(100) DEFAULT NULL,
  `modifier` varchar(100) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` varchar(3) DEFAULT 'n',
  `customer_id` bigint(20) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `from_account_type` varchar(100) DEFAULT NULL,
  `from_account` varchar(100) DEFAULT NULL,
  `to_account_type` varchar(100) DEFAULT NULL,
  `to_account` varchar(100) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `customer_last_balance` bigint(20) DEFAULT NULL,
  `customer_balance` bigint(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `credentials_img_url` varchar(200) DEFAULT NULL,
  `reporter_id` bigint(20) DEFAULT NULL,
  `reporter_name` varchar(100) DEFAULT NULL,
  `report_date` datetime DEFAULT NULL,
  `display` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


insert  into zc.zc_user value (
  1, "system","system",now(),now(),"n", "admin", "a66abb5684c45962d887564f08346e8d","15158092133","y","n","n"
);

insert into zc.zc_role value (
	1, "system","system",now(),now(),"n", "admin","admin","admin"
);

insert into zc.zc_user_role_relation value (1, "system", "system", now(), now(), "n", 1, 1, "admin", null, null, "y");