/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.5.4-MariaDB : Database - product_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`product_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `product_db`;

/*Table structure for table `product_info` */

DROP TABLE IF EXISTS `product_info`;

CREATE TABLE `product_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(40) NOT NULL,
  `sku` varchar(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `stock_level` int(10) NOT NULL,
  `email` varchar(60) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `create_time` time DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `update_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `product_info` */

insert  into `product_info`(`id`,`product_name`,`sku`,`description`,`price`,`stock_level`,`email`,`status`,`create_date`,`create_time`,`update_date`,`update_time`) values 
(1,'samsung','smj12','Self Sensor',2000,100,'ssplPune@gmail.com','A','2021-06-14','10:10:10',NULL,NULL),
(2,'VIVO','VRsd6','Long battery life',2000,200,'abhijitghodke73@gmail.com','A','2021-06-15','11:09:46',NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`user_name`,`password`,`status`) values 
(1,'Test-User','test','test','A');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
