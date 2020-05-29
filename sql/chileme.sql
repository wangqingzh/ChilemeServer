/*
 Navicat Premium Data Transfer

 Source Server         : miaosha
 Source Server Type    : MySQL
 Source Server Version : 100412
 Source Host           : 192.168.2.225:3306
 Source Schema         : chileme

 Target Server Type    : MySQL
 Target Server Version : 100412
 File Encoding         : 65001

 Date: 05/04/2020 12:58:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attention_fans
-- ----------------------------
DROP TABLE IF EXISTS `attention_fans`;
CREATE TABLE `attention_fans`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attention_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `enable` bit(1) NULL DEFAULT NULL,
  `fans_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for browser_history
-- ----------------------------
DROP TABLE IF EXISTS `browser_history`;
CREATE TABLE `browser_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `post_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for campus_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `campus_evaluate`;
CREATE TABLE `campus_evaluate`  (
  `evaluate_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `dish` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `evaluate_score` float NOT NULL,
  `hall_id` int(11) NULL DEFAULT NULL,
  `post_id` int(11) NULL DEFAULT NULL,
  `store_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`evaluate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of campus_evaluate
-- ----------------------------
INSERT INTO `campus_evaluate` VALUES (1, '监控', '2020-03-10 13:54:57.000000', '今年', 2.5, 0, 7, '图我', '2020-03-10 13:54:57.000000');
INSERT INTO `campus_evaluate` VALUES (2, '劲道\n汤好喝\n肉多', '2020-03-13 15:03:24.000000', '牛肉面', 5, 1, 10, '老王面馆', '2020-03-13 15:03:24.000000');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `from_uid` int(11) NULL DEFAULT NULL,
  `post_id` int(11) NULL DEFAULT NULL,
  `to_uid` int(11) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '你一', '2020-03-09 14:18:47.000000', 1, 3, NULL, '2020-03-09 14:18:47.000000', b'1');
INSERT INTO `comment` VALUES (2, '好咯泼墨', '2020-03-09 15:00:45.000000', 1, 1, NULL, '2020-03-09 15:00:45.000000', b'1');
INSERT INTO `comment` VALUES (3, 'Roy空', '2020-03-09 15:01:13.000000', 1, 1, NULL, '2020-03-09 15:01:13.000000', b'1');
INSERT INTO `comment` VALUES (4, '户口页', '2020-03-09 15:10:32.000000', 1, 3, NULL, '2020-03-09 15:10:32.000000', b'1');
INSERT INTO `comment` VALUES (5, '好哦无咯', '2020-03-09 15:13:33.000000', 1, 2, NULL, '2020-03-09 15:13:33.000000', b'1');
INSERT INTO `comment` VALUES (6, '咯哦无咯', '2020-03-09 15:13:45.000000', 1, 1, NULL, '2020-03-09 15:13:45.000000', b'1');
INSERT INTO `comment` VALUES (7, '大傻子', '2020-03-09 15:13:53.000000', 1, 1, NULL, '2020-03-09 15:13:53.000000', b'1');
INSERT INTO `comment` VALUES (8, 'two佛祖lz', '2020-03-09 15:14:08.000000', 1, 1, NULL, '2020-03-09 15:14:08.000000', b'1');
INSERT INTO `comment` VALUES (9, '空投', '2020-03-09 15:14:50.000000', 1, 2, NULL, '2020-03-09 15:14:50.000000', b'1');
INSERT INTO `comment` VALUES (10, '🐉', '2020-03-09 15:14:54.000000', 1, 2, NULL, '2020-03-09 15:14:54.000000', b'1');
INSERT INTO `comment` VALUES (11, '来天加一个评论', '2020-03-09 16:05:43.000000', 1, 4, NULL, '2020-03-09 16:05:43.000000', b'1');
INSERT INTO `comment` VALUES (12, '呼我', '2020-03-19 12:32:21.000000', 1, 7, NULL, '2020-03-19 12:32:21.000000', b'1');
INSERT INTO `comment` VALUES (13, '给我哦哟', '2020-03-19 12:36:25.000000', 1, 7, NULL, '2020-03-19 12:36:25.000000', b'1');
INSERT INTO `comment` VALUES (14, '一系列', '2020-03-19 14:36:38.000000', 1, 1, NULL, '2020-03-19 14:36:38.000000', b'1');
INSERT INTO `comment` VALUES (15, '@nikeName信息', '2020-03-19 14:36:47.000000', 1, 1, 1, '2020-03-19 14:36:47.000000', b'1');
INSERT INTO `comment` VALUES (16, '@nikeName 心里', '2020-03-19 14:38:05.000000', 1, 1, 1, '2020-03-19 14:38:05.000000', b'1');
INSERT INTO `comment` VALUES (17, '@nikeName 你好啊', '2020-03-19 14:38:11.000000', 1, 1, 1, '2020-03-19 14:38:11.000000', b'1');
INSERT INTO `comment` VALUES (18, '@nikeName 信息', '2020-03-19 14:38:21.000000', 1, 1, 1, '2020-03-19 14:38:21.000000', b'1');
INSERT INTO `comment` VALUES (19, '@nikeName 弟弟', '2020-03-19 14:51:26.000000', 1, 1, 1, '2020-03-19 14:51:26.000000', b'1');
INSERT INTO `comment` VALUES (20, '@nikeName 你好啊', '2020-03-19 14:51:37.000000', 1, 1, 1, '2020-03-19 14:51:37.000000', b'1');
INSERT INTO `comment` VALUES (21, '好女', '2020-03-22 08:54:33.000000', 1, 7, NULL, '2020-03-22 08:54:33.000000', b'1');

-- ----------------------------
-- Table structure for food_rec
-- ----------------------------
DROP TABLE IF EXISTS `food_rec`;
CREATE TABLE `food_rec`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `post_id` int(11) NULL DEFAULT NULL,
  `recommend_score` float NOT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `classify_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food_rec
-- ----------------------------
INSERT INTO `food_rec` VALUES (1, '临沂', '2020-02-25 06:06:53.000000', 1, 2.5, '2020-02-25 06:06:53.000000', 2);
INSERT INTO `food_rec` VALUES (2, '外婆哦了', '2020-02-26 08:14:24.000000', 2, 3.5, '2020-02-26 08:14:24.000000', 2);
INSERT INTO `food_rec` VALUES (3, '味道不错\n价格一般', '2020-02-26 15:21:16.000000', 3, 4, '2020-02-26 15:21:16.000000', 1);
INSERT INTO `food_rec` VALUES (4, '自由', '2020-03-09 15:09:07.000000', 4, 3.5, '2020-03-09 15:09:07.000000', 1);
INSERT INTO `food_rec` VALUES (5, '金木', '2020-03-12 17:03:23.000000', 8, 2.5, '2020-03-12 17:03:23.000000', 1);
INSERT INTO `food_rec` VALUES (6, '摸摸', '2020-03-12 17:04:02.000000', 9, 3.5, '2020-03-12 17:04:02.000000', 2);

-- ----------------------------
-- Table structure for hall_classify
-- ----------------------------
DROP TABLE IF EXISTS `hall_classify`;
CREATE TABLE `hall_classify`  (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT,
  `classify_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for my_favorite
-- ----------------------------
DROP TABLE IF EXISTS `my_favorite`;
CREATE TABLE `my_favorite`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `is_delete` bit(1) NULL DEFAULT NULL,
  `post_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_favorite
-- ----------------------------
INSERT INTO `my_favorite` VALUES (1, '2020-02-28 16:25:33.000000', NULL, 1, '2020-03-12 17:21:58.000000', 1, b'1');
INSERT INTO `my_favorite` VALUES (2, '2020-02-28 16:31:36.000000', NULL, 3, '2020-03-09 14:21:50.000000', 1, b'0');
INSERT INTO `my_favorite` VALUES (3, '2020-02-28 16:40:29.000000', NULL, 2, '2020-02-28 16:40:29.000000', 1, b'1');
INSERT INTO `my_favorite` VALUES (4, '2020-03-21 15:49:17.000000', NULL, 7, '2020-03-21 15:49:17.000000', 1, b'1');

-- ----------------------------
-- Table structure for my_like
-- ----------------------------
DROP TABLE IF EXISTS `my_like`;
CREATE TABLE `my_like`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_like
-- ----------------------------
INSERT INTO `my_like` VALUES (1, '2020-02-27 08:11:24.000000', b'0', 0, 3, '2020-03-12 17:20:55.000000', 1);
INSERT INTO `my_like` VALUES (2, '2020-02-27 08:11:47.000000', b'1', 0, 1, '2020-03-21 15:44:12.000000', 1);
INSERT INTO `my_like` VALUES (3, '2020-02-27 08:34:28.000000', b'0', 0, 2, '2020-03-21 15:44:28.000000', 1);
INSERT INTO `my_like` VALUES (4, '2020-03-09 15:44:11.000000', b'1', 1, 5, '2020-03-19 12:44:18.000000', 1);
INSERT INTO `my_like` VALUES (5, '2020-03-09 15:44:23.000000', b'0', 1, 9, '2020-03-21 15:44:24.000000', 1);
INSERT INTO `my_like` VALUES (6, '2020-03-09 16:05:23.000000', b'0', 1, 10, '2020-03-13 15:03:47.000000', 1);
INSERT INTO `my_like` VALUES (7, '2020-03-09 16:05:47.000000', b'0', 0, 4, '2020-03-12 17:20:41.000000', 1);
INSERT INTO `my_like` VALUES (8, '2020-03-09 16:05:50.000000', b'1', 1, 11, '2020-03-09 16:06:54.000000', 1);
INSERT INTO `my_like` VALUES (9, '2020-03-11 14:52:03.000000', b'0', 0, 7, '2020-03-21 15:49:11.000000', 1);
INSERT INTO `my_like` VALUES (10, '2020-03-19 12:43:08.000000', b'1', 1, 8, '2020-03-19 12:43:08.000000', 1);
INSERT INTO `my_like` VALUES (11, '2020-03-19 12:47:25.000000', b'0', 1, 12, '2020-03-19 12:47:32.000000', 1);
INSERT INTO `my_like` VALUES (12, '2020-03-19 15:01:17.000000', b'1', 1, 20, '2020-03-19 15:01:17.000000', 1);
INSERT INTO `my_like` VALUES (13, '2020-03-22 08:54:35.000000', b'1', 1, 21, '2020-03-22 08:54:35.000000', 1);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  `headline` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `post_type` int(11) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, '2020-02-25 06:06:53.000000', b'1', '囧', 'image/5fec5814-3d3d-44af-8fcf-619ff1f9768e.jpg', 1, '2020-02-25 06:06:53.000000', 1);
INSERT INTO `post` VALUES (2, '2020-02-26 08:14:24.000000', b'1', '13766', 'image/5408ec03-d9f0-4670-99c8-36946f9b70b8.jpg', 1, '2020-02-26 08:14:24.000000', 1);
INSERT INTO `post` VALUES (3, '2020-02-26 15:21:16.000000', b'1', '蜀大侠火锅', 'image/0f045a16-9b73-4afe-a9e5-ebdd555239e6.jpg', 1, '2020-02-26 15:21:16.000000', 1);
INSERT INTO `post` VALUES (4, '2020-03-09 15:09:07.000000', b'1', '继续', 'image/a5b19e3e-8de7-40e3-8fbb-37d3e81dc71c.jpg', 1, '2020-03-09 15:09:07.000000', 1);
INSERT INTO `post` VALUES (7, '2020-03-10 13:54:57.000000', b'1', '好女', 'image/ad204f17-299a-4a5b-9f76-08c4ff0b4df4.jpg', 0, '2020-03-10 13:54:57.000000', 1);
INSERT INTO `post` VALUES (8, '2020-03-12 17:03:23.000000', b'1', '民族', NULL, 1, '2020-03-12 17:03:23.000000', 1);
INSERT INTO `post` VALUES (9, '2020-03-12 17:04:02.000000', b'1', '同', 'image/38e0a45d-9234-485f-8a2d-f933306cc2cd.jpg', 1, '2020-03-12 17:04:02.000000', 1);
INSERT INTO `post` VALUES (10, '2020-03-13 15:03:24.000000', b'1', '面条忒好吃', 'image/dfa418bf-7717-46ab-9c00-357e6132c0f8.jpg', 0, '2020-03-13 15:03:24.000000', 1);

-- ----------------------------
-- Table structure for rec_classify
-- ----------------------------
DROP TABLE IF EXISTS `rec_classify`;
CREATE TABLE `rec_classify`  (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT,
  `classify_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rec_classify
-- ----------------------------
INSERT INTO `rec_classify` VALUES (0, '校园餐饮');
INSERT INTO `rec_classify` VALUES (1, '实体店');
INSERT INTO `rec_classify` VALUES (2, '网购');
INSERT INTO `rec_classify` VALUES (3, '外卖');
INSERT INTO `rec_classify` VALUES (4, '自己做');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `name_zh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_dba', '数据库管理员');
INSERT INTO `role` VALUES (2, 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES (3, 'ROLE_user', '用户');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `credential` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `identifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `identity_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `locked` bit(1) NOT NULL,
  `security_answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `security_question` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2020-02-18 05:17:45.000000', '$2a$10$BbDVUpxx4w.VrqoioKqe5ORukg0/Yy0qQbX1IQk/Fsq7UILN/Trn6', b'1', '123', 'phone', b'0', '', '', '2020-02-18 05:17:45.000000');
INSERT INTO `user` VALUES (2, '2020-02-26 14:33:27.000000', '$2a$10$h20ouubMa8eqAqsjJp7KleTJkgNtW3XW9BDYjQHBKiXgmqAj6NoHq', b'1', '456', 'phone', b'0', '', '', '2020-02-26 14:33:27.000000');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `cover_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'image/a3a5c2df-86fd-4f1a-85f4-64187a87c2f0.jpg', NULL, NULL, 'nikeName', NULL, 1, NULL);
INSERT INTO `user_info` VALUES (2, NULL, NULL, NULL, 'unnamed', NULL, 2, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 1, 2);
INSERT INTO `user_role` VALUES (3, 2, 2);
INSERT INTO `user_role` VALUES (4, 3, 3);
INSERT INTO `user_role` VALUES (5, 3, 1);
INSERT INTO `user_role` VALUES (6, 3, 2);
INSERT INTO `user_role` VALUES (7, 3, 3);
INSERT INTO `user_role` VALUES (8, 3, 4);
INSERT INTO `user_role` VALUES (9, 3, 5);
INSERT INTO `user_role` VALUES (10, 3, 6);
INSERT INTO `user_role` VALUES (11, 3, 7);
INSERT INTO `user_role` VALUES (12, 3, 8);
INSERT INTO `user_role` VALUES (13, 3, 9);
INSERT INTO `user_role` VALUES (14, 3, 10);
INSERT INTO `user_role` VALUES (15, 3, 11);
INSERT INTO `user_role` VALUES (16, 3, 12);
INSERT INTO `user_role` VALUES (17, 3, 13);
INSERT INTO `user_role` VALUES (18, 3, 14);
INSERT INTO `user_role` VALUES (19, 3, 15);
INSERT INTO `user_role` VALUES (20, 3, 16);
INSERT INTO `user_role` VALUES (21, 3, 17);
INSERT INTO `user_role` VALUES (22, 3, 18);
INSERT INTO `user_role` VALUES (23, 3, 19);
INSERT INTO `user_role` VALUES (24, 3, 20);
INSERT INTO `user_role` VALUES (25, 3, 21);
INSERT INTO `user_role` VALUES (26, 3, 22);
INSERT INTO `user_role` VALUES (27, 3, 23);
INSERT INTO `user_role` VALUES (28, 3, 24);
INSERT INTO `user_role` VALUES (29, 3, 25);
INSERT INTO `user_role` VALUES (30, 3, 26);
INSERT INTO `user_role` VALUES (31, 3, 27);
INSERT INTO `user_role` VALUES (32, 3, 28);
INSERT INTO `user_role` VALUES (33, 3, 29);
INSERT INTO `user_role` VALUES (34, 3, 1);
INSERT INTO `user_role` VALUES (35, 3, 2);

SET FOREIGN_KEY_CHECKS = 1;
