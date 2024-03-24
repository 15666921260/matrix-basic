/*
 Navicat Premium Data Transfer

 Source Server         : localPostgreSQL
 Source Server Type    : PostgreSQL
 Source Server Version : 160002 (160002)
 Source Host           : localhost:5432
 Source Catalog        : matrix_db
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 160002 (160002)
 File Encoding         : 65001

 Date: 24/03/2024 14:18:08
*/


-- ----------------------------
-- Sequence structure for sys_dict_type_1_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sys_dict_type_1_id_seq";
CREATE SEQUENCE "public"."sys_dict_type_1_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_menu_1_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sys_menu_1_id_seq";
CREATE SEQUENCE "public"."sys_menu_1_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dict";
CREATE TABLE "public"."sys_dict" (
  "id" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "type" int4,
  "dic_name" varchar(50) COLLATE "pg_catalog"."default",
  "dic_value" varchar(50) COLLATE "pg_catalog"."default",
  "sort_num" int4,
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0,
  "disable" bool DEFAULT false
)
;
COMMENT ON COLUMN "public"."sys_dict"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_dict"."type" IS '字典类型id';
COMMENT ON COLUMN "public"."sys_dict"."dic_name" IS '字典名';
COMMENT ON COLUMN "public"."sys_dict"."dic_value" IS '字典值';
COMMENT ON COLUMN "public"."sys_dict"."sort_num" IS '排序字段';
COMMENT ON COLUMN "public"."sys_dict"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_dict"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_dict"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_dict"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_dict"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_dict"."deleted" IS '0 未删除 1 已删除';
COMMENT ON COLUMN "public"."sys_dict"."disable" IS '是否禁用 true 禁用 false 不禁用';
COMMENT ON TABLE "public"."sys_dict" IS '系统字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dict_type";
CREATE TABLE "public"."sys_dict_type" (
  "id" int4 NOT NULL DEFAULT nextval('sys_dict_type_1_id_seq'::regclass),
  "type_name" varchar(100) COLLATE "pg_catalog"."default",
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0,
  "need_enum" bool DEFAULT false,
  "disable" bool DEFAULT false
)
;
COMMENT ON COLUMN "public"."sys_dict_type"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_dict_type"."type_name" IS '字典类型名';
COMMENT ON COLUMN "public"."sys_dict_type"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_dict_type"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_dict_type"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_dict_type"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_dict_type"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_dict_type"."deleted" IS '0 未删除 1 已删除';
COMMENT ON COLUMN "public"."sys_dict_type"."need_enum" IS '代码中是否需要枚举类 true 需要 false不需要';
COMMENT ON COLUMN "public"."sys_dict_type"."disable" IS '是否禁用 true 禁用 false 不禁用';
COMMENT ON TABLE "public"."sys_dict_type" IS '系统字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO "public"."sys_dict_type" VALUES (2, '用户类型', '用于描述用户的类型', '000000001', '2024-03-24 14:00:08', '000000001', '2024-03-24 14:00:08', 0, 'f', 'f');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_file";
CREATE TABLE "public"."sys_file" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "file_type" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "file_url" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "file_temp_name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "file_source_name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."sys_file"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_file"."file_type" IS '文件类型(jpg、doc等等)';
COMMENT ON COLUMN "public"."sys_file"."file_url" IS '文件存放目录';
COMMENT ON COLUMN "public"."sys_file"."file_temp_name" IS '文件临时名(带后缀)';
COMMENT ON COLUMN "public"."sys_file"."file_source_name" IS '文件上传时的名(带后缀)';
COMMENT ON COLUMN "public"."sys_file"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_file"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_file"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_file"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_file"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_file"."deleted" IS '0 未删除 1 已删除';
COMMENT ON TABLE "public"."sys_file" IS '系统文件表';

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO "public"."sys_file" VALUES ('1766829528619884545', 'jpg', '\202403\10\20240310221240366.jpg', '20240310221240366.jpg', 'coding-1853305_640.jpg', NULL, '000000001', '2024-03-10 22:12:40', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766830884588036098', 'jpg', '\202403\10\20240310221803677.jpg', '20240310221803677.jpg', 'coding-1853305_640.jpg', NULL, '000000001', '2024-03-10 22:18:04', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766833003823026178', 'jpg', '\202403\10\20240310222628907.jpg', '20240310222628907.jpg', 'coding-1853305_640.jpg', NULL, '000000001', '2024-03-10 22:26:29', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766833073398140930', 'png', '\202403\10\20240310222645527.png', '20240310222645527.png', '微信截图_20231219231637.png', NULL, '000000001', '2024-03-10 22:26:46', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766842484342571010', 'png', '\202403\10\20240310230409250.png', '20240310230409250.png', 'background.png', NULL, '000000001', '2024-03-10 23:04:09', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766848050829910018', 'png', '\202403\10\20240310232616402.png', '20240310232616402.png', 'wallhaven-x637oz_1920x1080.png', NULL, '000000001', '2024-03-10 23:26:16', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766855393042948098', 'jpg', '\202403\10\20240310235526947.jpg', '20240310235526947.jpg', 'wallhaven-x637oz_1920x1080.jpg', NULL, '000000001', '2024-03-10 23:55:27', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766855542414696450', 'jpg', '\202403\10\20240310235602563.jpg', '20240310235602563.jpg', 'wallhaven-x637oz_1920x1080.jpg', NULL, '000000001', '2024-03-10 23:56:03', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1766855770379313154', 'png', '\202403\10\20240310235656907.png', '20240310235656907.png', 'wallhaven-x637oz_1920x1080.png', NULL, '000000001', '2024-03-10 23:56:57', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1767224930259075074', 'png', '\202403\12\20240312002351461.png', '20240312002351461.png', 'wallhaven-6dgmqw_1920x1080.png', NULL, '000000001', '2024-03-12 00:23:51', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1767225060790009857', 'png', '\202403\12\20240312002422601.png', '20240312002422601.png', 'background.png', NULL, '000000001', '2024-03-12 00:24:23', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1767225933242990593', 'png', '\202403\12\20240312002750623.png', '20240312002750623.png', 'wallhaven-x637oz_1920x1080.png', NULL, '000000001', '2024-03-12 00:27:51', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1767228887526178817', 'png', '\202403\12\20240312003934972.png', '20240312003934972.png', 'logo.png', NULL, '000000001', '2024-03-12 00:39:35', '000000001', NULL, 0);
INSERT INTO "public"."sys_file" VALUES ('1769775045494665217', 'jpg', '\202403\19\20240319011706309.jpg', '20240319011706309.jpg', 'pexels-alexis-ricardo-alaurin-16427628.jpg', NULL, '000000001', '2024-03-19 01:17:06', '000000001', '2024-03-19 01:17:06', 0);
INSERT INTO "public"."sys_file" VALUES ('1770483702859546625', 'jpg', '\202403\21\20240321001303396.jpg', '20240321001303396.jpg', 'pexels-alim-18748124.jpg', NULL, '000000001', '2024-03-21 00:13:03', '000000001', '2024-03-21 00:13:03', 0);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_menu";
CREATE TABLE "public"."sys_menu" (
  "id" int8 NOT NULL DEFAULT nextval('sys_menu_1_id_seq'::regclass),
  "title" varchar(64) COLLATE "pg_catalog"."default",
  "parent_id" int8 NOT NULL,
  "type" int2 NOT NULL,
  "code" varchar(100) COLLATE "pg_catalog"."default",
  "route_url" varchar(200) COLLATE "pg_catalog"."default",
  "component_path" varchar(100) COLLATE "pg_catalog"."default",
  "route_redirect" varchar(100) COLLATE "pg_catalog"."default",
  "icon" varchar(64) COLLATE "pg_catalog"."default",
  "sort" int2 NOT NULL,
  "hidden" bool NOT NULL,
  "status" bool NOT NULL,
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."sys_menu"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_menu"."title" IS '名称';
COMMENT ON COLUMN "public"."sys_menu"."parent_id" IS '父级id(根为0)';
COMMENT ON COLUMN "public"."sys_menu"."type" IS '菜单类型，1：目录，2：菜单，3：权限(按钮)';
COMMENT ON COLUMN "public"."sys_menu"."code" IS '菜单编码';
COMMENT ON COLUMN "public"."sys_menu"."route_url" IS '前端路由地址';
COMMENT ON COLUMN "public"."sys_menu"."component_path" IS '组件路径';
COMMENT ON COLUMN "public"."sys_menu"."route_redirect" IS '重定向';
COMMENT ON COLUMN "public"."sys_menu"."icon" IS '菜单图标';
COMMENT ON COLUMN "public"."sys_menu"."sort" IS '排序(最大到32000多足够用)';
COMMENT ON COLUMN "public"."sys_menu"."hidden" IS '是否显示,false：显示，true：不显示';
COMMENT ON COLUMN "public"."sys_menu"."status" IS '状态，false：禁用，true：启用';
COMMENT ON COLUMN "public"."sys_menu"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_menu"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_menu"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_menu"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_menu"."deleted" IS '0 未删除 1 已删除';
COMMENT ON TABLE "public"."sys_menu" IS '系统枚举类';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO "public"."sys_menu" VALUES (1, '数据大屏', 0, 2, NULL, '/screen', 'screen/index', NULL, 'Platform', 1, 'f', 't', NULL, NULL, '2024-03-12 23:46:29', NULL, '2024-03-17 13:16:26', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
  "id" int8 NOT NULL,
  "role_name" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "role_type" int2 NOT NULL,
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."sys_role"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."sys_role"."role_type" IS '角色类型';
COMMENT ON COLUMN "public"."sys_role"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_role"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_role"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_role"."deleted" IS '0 未删除 1 已删除';
COMMENT ON TABLE "public"."sys_role" IS '系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_menu";
CREATE TABLE "public"."sys_role_menu" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "role_id" int8,
  "menu_id" int8,
  "is_choice" bool,
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."sys_role_menu"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_role_menu"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."sys_role_menu"."menu_id" IS '菜单id';
COMMENT ON COLUMN "public"."sys_role_menu"."is_choice" IS '是否用户选中 false：否，true：是';
COMMENT ON COLUMN "public"."sys_role_menu"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_role_menu"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_role_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_role_menu"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_role_menu"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_role_menu"."deleted" IS '0 未删除 1 已删除';
COMMENT ON TABLE "public"."sys_role_menu" IS '系统角色菜单映射表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "username" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "avatar_file_id" varchar(255) COLLATE "pg_catalog"."default",
  "phone" varchar(50) COLLATE "pg_catalog"."default",
  "nick_name" varchar(50) COLLATE "pg_catalog"."default",
  "real_name" varchar(50) COLLATE "pg_catalog"."default",
  "user_type" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."sys_user"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_user"."username" IS '用户名(唯一)';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."avatar_file_id" IS '头像文件id';
COMMENT ON COLUMN "public"."sys_user"."phone" IS '手机号';
COMMENT ON COLUMN "public"."sys_user"."nick_name" IS '昵称';
COMMENT ON COLUMN "public"."sys_user"."real_name" IS '真实姓名(姓_名字)';
COMMENT ON COLUMN "public"."sys_user"."user_type" IS '用户类型';
COMMENT ON COLUMN "public"."sys_user"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_user"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_user"."deleted" IS '0 未删除 1 已删除';
COMMENT ON TABLE "public"."sys_user" IS '系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES ('000000001', 'admin', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000002', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000003', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000004', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000005', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000006', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000007', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000008', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000009', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000010', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);
INSERT INTO "public"."sys_user" VALUES ('000000011', 'admin1', '634d6cb6778c4f2d1d2470ff898d0430', '1767228887526178817', '15666921260', 'admin', '刘伟中', 'admin', NULL, '0', '2024-03-07 02:05:50', '0', '2024-03-17 19:04:48', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "role_id" int8 NOT NULL,
  "remarks" varchar(255) COLLATE "pg_catalog"."default",
  "create_id" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0),
  "update_id" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(0),
  "deleted" int2 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."sys_user_role"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_user_role"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."sys_user_role"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."sys_user_role"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_user_role"."create_id" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_user_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user_role"."update_id" IS '更新用户id';
COMMENT ON COLUMN "public"."sys_user_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_user_role"."deleted" IS '0 未删除 1 已删除';
COMMENT ON TABLE "public"."sys_user_role" IS '系统用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."sys_dict_type_1_id_seq"
OWNED BY "public"."sys_dict_type"."id";
SELECT setval('"public"."sys_dict_type_1_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."sys_menu_1_id_seq"
OWNED BY "public"."sys_menu"."id";
SELECT setval('"public"."sys_menu_1_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table sys_dict
-- ----------------------------
CREATE INDEX "type" ON "public"."sys_dict" USING btree (
  "type" "pg_catalog"."int4_ops" ASC NULLS LAST
);
COMMENT ON INDEX "public"."type" IS '字典类型索引';

-- ----------------------------
-- Primary Key structure for table sys_dict
-- ----------------------------
ALTER TABLE "public"."sys_dict" ADD CONSTRAINT "sys_dict_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_dict_type
-- ----------------------------
ALTER TABLE "public"."sys_dict_type" ADD CONSTRAINT "sys_dict_type_1_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_file
-- ----------------------------
ALTER TABLE "public"."sys_file" ADD CONSTRAINT "sys_file_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "public"."sys_menu" ADD CONSTRAINT "sys_menu_1_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_menu
-- ----------------------------
ALTER TABLE "public"."sys_role_menu" ADD CONSTRAINT "sys_role_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user_role
-- ----------------------------
ALTER TABLE "public"."sys_user_role" ADD CONSTRAINT "sys_user_role_pkey" PRIMARY KEY ("id");
