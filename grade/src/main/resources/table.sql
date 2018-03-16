CREATE TABLE `score` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` int(10) DEFAULT NULL COMMENT '考试类型：1周测2月考3模考',
  `chinese` int(10) DEFAULT NULL COMMENT '语文',
  `maths` int(10) DEFAULT NULL COMMENT '数学',
  `english` int(10) DEFAULT NULL COMMENT '英语',
  `politics` int(10) DEFAULT NULL COMMENT '政治',
  `history` int(10) DEFAULT NULL COMMENT '历史',
  `geography` int(10) DEFAULT NULL COMMENT '地理',
  `synthesize` int(10) DEFAULT NULL COMMENT '文综',
  `total_points` int(10) DEFAULT NULL COMMENT '总分',
  `date` date DEFAULT NULL COMMENT '考试日期',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 测试提交github

