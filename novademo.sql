/*
SQLyog Ultimate
MySQL - 8.0.15 : Database - learn-jooq
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`nova-demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `nova-demo`;

/*Table structure for table `s1_user` */

CREATE TABLE `nova_user`
(
    `id`          varchar(128)                           NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`    varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
    `email`       varchar(50) COLLATE utf8mb4_general_ci      DEFAULT NULL,
    `address`     varchar(128) COLLATE utf8mb4_general_ci     DEFAULT NULL,
    `create_time` timestamp                              NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp                              NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted`     varchar(11)                                NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 343
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='USER TABLE';

/*Data for the table `s1_user` */

insert into `nova_user`(`id`, `username`, `email`, `address`, `create_time`, `update_time`,`deleted`)
values ('1', '张三', 'zhansan@163.com', '北京', '2019-12-27 16:41:42', '2019-12-27 16:41:42','0'),
       ('2', '李四', 'lisi@gmail.com', '上海', '2019-12-27 16:41:42','2019-12-27 16:41:42','0'),
       ('3', '王五', 'wangwu@gmail.com', '西安', '2019-12-27 16:41:44','2019-12-27 16:41:45','0');