/*
Navicat MySQL Data Transfer

Source Server         : localhost_mysql
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : account

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2018-04-13 17:39:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comsume
-- ----------------------------
DROP TABLE IF EXISTS `comsume`;
CREATE TABLE `comsume` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `account` decimal(10,0) DEFAULT NULL COMMENT '金额',
  `good_code` varchar(255) DEFAULT NULL COMMENT '商品代码',
  `user_type` char(1) DEFAULT NULL COMMENT '使用者类型：  0：自己使用    1：小组使用',
  `group_code` varchar(255) DEFAULT NULL COMMENT '小组代码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '消费时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for good_detail
-- ----------------------------
DROP TABLE IF EXISTS `good_detail`;
CREATE TABLE `good_detail` (
  `good_code` varchar(255) NOT NULL COMMENT '商品代码',
  `good_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`good_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for good_type
-- ----------------------------
DROP TABLE IF EXISTS `good_type`;
CREATE TABLE `good_type` (
  `good_type_code` varchar(255) NOT NULL COMMENT '商品类型代码',
  `good_type_name` varchar(255) DEFAULT NULL COMMENT '商品类型名称',
  PRIMARY KEY (`good_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `group_code` varchar(255) NOT NULL COMMENT '小组代码',
  `group_name` varchar(255) DEFAULT NULL COMMENT '小组名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`group_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  `register_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `group_code` varchar(255) DEFAULT NULL COMMENT '小组代码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
