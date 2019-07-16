/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.10 : Database - test1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test1`;

/*Table structure for table `participant` */

DROP TABLE IF EXISTS `participant`;

CREATE TABLE `participant` (
  `par_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `par_name` varchar(100) DEFAULT NULL,
  `par_telephone` varchar(100) DEFAULT NULL,
  `par_identityid` varchar(100) DEFAULT NULL,
  `par_hasget` int(11) DEFAULT NULL,
  PRIMARY KEY (`par_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Table structure for table `pool` */

DROP TABLE IF EXISTS `pool`;

CREATE TABLE `pool` (
  `pool_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pool_name` varchar(100) DEFAULT NULL,
  `pool_telephone` varchar(100) DEFAULT NULL,
  `pool_identityid` varchar(100) DEFAULT NULL,
  `pool_hasget` int(11) DEFAULT NULL,
  PRIMARY KEY (`pool_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Table structure for table `systemuser` */

DROP TABLE IF EXISTS `systemuser`;

CREATE TABLE `systemuser` (
  `sys_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sys_name` varchar(100) NOT NULL,
  `sys_password` varchar(100) NOT NULL,
  PRIMARY KEY (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
