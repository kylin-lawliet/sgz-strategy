-- 战法兵书
DROP TABLE IF EXISTS `tactics`;
CREATE TABLE `tactics`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL COMMENT '兵法/战法名',
  `quality` varchar(5) NULL DEFAULT NULL COMMENT '战法品质',
  `type` varchar(10) NULL DEFAULT NULL COMMENT '战法类型',
  `source` int NULL DEFAULT NULL COMMENT '战法来源：1-自带战法；2-传承战法',
  `suit` varchar(255) NULL DEFAULT NULL COMMENT '兵种适用：\r\n1-骑兵、2-弓兵、3-枪兵、4-盾兵、5-器械\r\n多个逗号分隔',
  `source_general` varchar(255) NULL DEFAULT NULL COMMENT '来源武将,拉取战法信息时存储',
  `img_url` varchar(255) NULL DEFAULT NULL COMMENT '战法图片路径',
  `target` varchar(255) NULL DEFAULT NULL COMMENT '目标',
  `tactics_describe` varchar(255) NULL DEFAULT NULL COMMENT '战法描述',
  `conflict` int NULL DEFAULT NULL COMMENT '战法冲突',
  `is_tactics` int NULL DEFAULT NULL COMMENT '0-战法；1兵书',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- 武将信息表
DROP TABLE IF EXISTS `general`;
CREATE TABLE `general`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '武将名称',
  `biographies` text NOT NULL COMMENT '武将列传',
  `reign` int NULL DEFAULT NULL COMMENT '统御值',
	`img_url` varchar(255) NULL DEFAULT NULL COMMENT '武将图片路径',
  `byo_tactics` int NULL DEFAULT NULL COMMENT '自带战法',
  `inherit_tactics` int NULL DEFAULT NULL COMMENT '传承战法',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- 武将兵种适应
DROP TABLE IF EXISTS `arms`;
CREATE TABLE `arms`  (
   `id` int NOT NULL AUTO_INCREMENT,
   `general_id` int NULL DEFAULT NULL COMMENT '武将编号',
   `arms` int NULL DEFAULT NULL COMMENT '兵种：1-骑兵；2-盾兵；3-弓兵；4-枪兵；5-器械',
   `level` varchar(5) NULL DEFAULT NULL COMMENT '适应级别',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
