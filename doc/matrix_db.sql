/*
 Navicat Premium Data Transfer

 Source Server         : localMysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : matrix_db

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 12/03/2024 01:00:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dic
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型',
  `dic_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名',
  `dic_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `sort_num` int(0) NULL DEFAULT NULL COMMENT '排序字段',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新用户id',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dic
-- ----------------------------

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `file_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件类型(jpg、doc等等)',
  `file_url` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件存放目录',
  `file_temp_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件临时名(带后缀)',
  `file_source_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件上传时的名(带后缀)',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新用户id',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件总表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('1766829528619884545', 'jpg', '\\202403\\10\\20240310221240366.jpg', '20240310221240366.jpg', 'coding-1853305_640.jpg', NULL, '000000001', '2024-03-10 22:12:40', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766830884588036098', 'jpg', '\\202403\\10\\20240310221803677.jpg', '20240310221803677.jpg', 'coding-1853305_640.jpg', NULL, '000000001', '2024-03-10 22:18:04', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766833003823026178', 'jpg', '\\202403\\10\\20240310222628907.jpg', '20240310222628907.jpg', 'coding-1853305_640.jpg', NULL, '000000001', '2024-03-10 22:26:29', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766833073398140930', 'png', '\\202403\\10\\20240310222645527.png', '20240310222645527.png', '微信截图_20231219231637.png', NULL, '000000001', '2024-03-10 22:26:46', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766842484342571010', 'png', '\\202403\\10\\20240310230409250.png', '20240310230409250.png', 'background.png', NULL, '000000001', '2024-03-10 23:04:09', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766848050829910018', 'png', '\\202403\\10\\20240310232616402.png', '20240310232616402.png', 'wallhaven-x637oz_1920x1080.png', NULL, '000000001', '2024-03-10 23:26:16', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766855393042948098', 'jpg', '\\202403\\10\\20240310235526947.jpg', '20240310235526947.jpg', 'wallhaven-x637oz_1920x1080.jpg', NULL, '000000001', '2024-03-10 23:55:27', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766855542414696450', 'jpg', '\\202403\\10\\20240310235602563.jpg', '20240310235602563.jpg', 'wallhaven-x637oz_1920x1080.jpg', NULL, '000000001', '2024-03-10 23:56:03', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1766855770379313154', 'png', '\\202403\\10\\20240310235656907.png', '20240310235656907.png', 'wallhaven-x637oz_1920x1080.png', NULL, '000000001', '2024-03-10 23:56:57', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1767224930259075074', 'png', '\\202403\\12\\20240312002351461.png', '20240312002351461.png', 'wallhaven-6dgmqw_1920x1080.png', NULL, '000000001', '2024-03-12 00:23:51', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1767225060790009857', 'png', '\\202403\\12\\20240312002422601.png', '20240312002422601.png', 'background.png', NULL, '000000001', '2024-03-12 00:24:23', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1767225933242990593', 'png', '\\202403\\12\\20240312002750623.png', '20240312002750623.png', 'wallhaven-x637oz_1920x1080.png', NULL, '000000001', '2024-03-12 00:27:51', '000000001', NULL, 0);
INSERT INTO `sys_file` VALUES ('1767228887526178817', 'png', '\\202403\\12\\20240312003934972.png', '20240312003934972.png', 'logo.png', NULL, '000000001', '2024-03-12 00:39:35', '000000001', NULL, 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名(唯一)',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `avatar_file_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像文件id',
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名(姓_名字)',
  `user_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新用户id',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('000000001', 'admin', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', NULL, NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-12 00:40:03', 0);

SET FOREIGN_KEY_CHECKS = 1;
