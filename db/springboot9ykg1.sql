-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot9ykg1
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot9ykg1`
--

/*!40000 DROP DATABASE IF EXISTS `springboot9ykg1`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot9ykg1` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot9ykg1`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hangxianfenlei`
--

DROP TABLE IF EXISTS `hangxianfenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hangxianfenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `hangxian` varchar(200) DEFAULT NULL COMMENT '航线',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='航线分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hangxianfenlei`
--

LOCK TABLES `hangxianfenlei` WRITE;
/*!40000 ALTER TABLE `hangxianfenlei` DISABLE KEYS */;
INSERT INTO `hangxianfenlei` VALUES (81,'2022-07-24 11:55:03','航线1'),(82,'2022-07-24 11:55:03','航线2'),(83,'2022-07-24 11:55:03','航线3'),(84,'2022-07-24 11:55:03','航线4'),(85,'2022-07-24 11:55:03','航线5'),(86,'2022-07-24 11:55:03','航线6');
/*!40000 ALTER TABLE `hangxianfenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huowuchukou`
--

DROP TABLE IF EXISTS `huowuchukou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huowuchukou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huoyundanhao` varchar(200) DEFAULT NULL COMMENT '货运单号',
  `huowumingcheng` varchar(200) DEFAULT NULL COMMENT '货物名称',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `chukoushijian` date DEFAULT NULL COMMENT '出口时间',
  `jiaojieren` varchar(200) DEFAULT NULL COMMENT '交接人',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `huoyundanhao` (`huoyundanhao`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='货物出口';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huowuchukou`
--

LOCK TABLES `huowuchukou` WRITE;
/*!40000 ALTER TABLE `huowuchukou` DISABLE KEYS */;
INSERT INTO `huowuchukou` VALUES (61,'2022-07-24 11:55:03','1111111111','货物名称1','规格1',1,'2022-07-24','交接人1','备注1','工号1','姓名1'),(62,'2022-07-24 11:55:03','2222222222','货物名称2','规格2',2,'2022-07-24','交接人2','备注2','工号2','姓名2'),(63,'2022-07-24 11:55:03','3333333333','货物名称3','规格3',3,'2022-07-24','交接人3','备注3','工号3','姓名3'),(64,'2022-07-24 11:55:03','4444444444','货物名称4','规格4',4,'2022-07-24','交接人4','备注4','工号4','姓名4'),(65,'2022-07-24 11:55:03','5555555555','货物名称5','规格5',5,'2022-07-24','交接人5','备注5','工号5','姓名5'),(66,'2022-07-24 11:55:03','6666666666','货物名称6','规格6',6,'2022-07-24','交接人6','备注6','工号6','姓名6');
/*!40000 ALTER TABLE `huowuchukou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huowujinkou`
--

DROP TABLE IF EXISTS `huowujinkou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huowujinkou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huoyundanhao` varchar(200) DEFAULT NULL COMMENT '货运单号',
  `huowumingcheng` varchar(200) DEFAULT NULL COMMENT '货物名称',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `jinkoushijian` date DEFAULT NULL COMMENT '进口时间',
  `jiaojieren` varchar(200) DEFAULT NULL COMMENT '交接人',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `huoyundanhao` (`huoyundanhao`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='货物进口';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huowujinkou`
--

LOCK TABLES `huowujinkou` WRITE;
/*!40000 ALTER TABLE `huowujinkou` DISABLE KEYS */;
INSERT INTO `huowujinkou` VALUES (51,'2022-07-24 11:55:03','1111111111','货物名称1','规格1',1,'2022-07-24','交接人1','备注1','工号1','姓名1'),(52,'2022-07-24 11:55:03','2222222222','货物名称2','规格2',2,'2022-07-24','交接人2','备注2','工号2','姓名2'),(53,'2022-07-24 11:55:03','3333333333','货物名称3','规格3',3,'2022-07-24','交接人3','备注3','工号3','姓名3'),(54,'2022-07-24 11:55:03','4444444444','货物名称4','规格4',4,'2022-07-24','交接人4','备注4','工号4','姓名4'),(55,'2022-07-24 11:55:03','5555555555','货物名称5','规格5',5,'2022-07-24','交接人5','备注5','工号5','姓名5'),(56,'2022-07-24 11:55:03','6666666666','货物名称6','规格6',6,'2022-07-24','交接人6','备注6','工号6','姓名6');
/*!40000 ALTER TABLE `huowujinkou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huowukucun`
--

DROP TABLE IF EXISTS `huowukucun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huowukucun` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huowumingcheng` varchar(200) DEFAULT NULL COMMENT '货物名称',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `huowulaiyuan` varchar(200) DEFAULT NULL COMMENT '货物来源',
  `yunshuhangxian` varchar(200) DEFAULT NULL COMMENT '运输航线',
  `huowujieshao` longtext COMMENT '货物介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='货物库存';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huowukucun`
--

LOCK TABLES `huowukucun` WRITE;
/*!40000 ALTER TABLE `huowukucun` DISABLE KEYS */;
INSERT INTO `huowukucun` VALUES (31,'2022-07-24 11:55:03','货物名称1','规格1',1,'货物来源1','运输航线1','货物介绍1'),(32,'2022-07-24 11:55:03','货物名称2','规格2',2,'货物来源2','运输航线2','货物介绍2'),(33,'2022-07-24 11:55:03','货物名称3','规格3',3,'货物来源3','运输航线3','货物介绍3'),(34,'2022-07-24 11:55:03','货物名称4','规格4',4,'货物来源4','运输航线4','货物介绍4'),(35,'2022-07-24 11:55:03','货物名称5','规格5',5,'货物来源5','运输航线5','货物介绍5'),(36,'2022-07-24 11:55:03','货物名称6','规格6',6,'货物来源6','运输航线6','货物介绍6');
/*!40000 ALTER TABLE `huowukucun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kehu`
--

DROP TABLE IF EXISTS `kehu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kehu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kehuzhanghao` varchar(200) NOT NULL COMMENT '客户账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `kehuxingming` varchar(200) NOT NULL COMMENT '客户姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `kehuzhanghao` (`kehuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='客户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kehu`
--

LOCK TABLES `kehu` WRITE;
/*!40000 ALTER TABLE `kehu` DISABLE KEYS */;
INSERT INTO `kehu` VALUES (11,'2022-07-24 11:55:03','客户账号1','123456','客户姓名1','男',1,'13823888881','773890001@qq.com'),(12,'2022-07-24 11:55:03','客户账号2','123456','客户姓名2','男',2,'13823888882','773890002@qq.com'),(13,'2022-07-24 11:55:03','客户账号3','123456','客户姓名3','男',3,'13823888883','773890003@qq.com'),(14,'2022-07-24 11:55:03','客户账号4','123456','客户姓名4','男',4,'13823888884','773890004@qq.com'),(15,'2022-07-24 11:55:03','客户账号5','123456','客户姓名5','男',5,'13823888885','773890005@qq.com'),(16,'2022-07-24 11:55:03','客户账号6','123456','客户姓名6','男',6,'13823888886','773890006@qq.com');
/*!40000 ALTER TABLE `kehu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paichurenyuan`
--

DROP TABLE IF EXISTS `paichurenyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paichurenyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `zhiwu` varchar(200) DEFAULT NULL COMMENT '职务',
  `paichushijian` date DEFAULT NULL COMMENT '派出时间',
  `paichudidian` varchar(200) DEFAULT NULL COMMENT '派出地点',
  `paichushiyou` longtext COMMENT '派出事由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='派出人员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paichurenyuan`
--

LOCK TABLES `paichurenyuan` WRITE;
/*!40000 ALTER TABLE `paichurenyuan` DISABLE KEYS */;
INSERT INTO `paichurenyuan` VALUES (71,'2022-07-24 11:55:03','工号1','姓名1','职务1','2022-07-24','派出地点1','派出事由1'),(72,'2022-07-24 11:55:03','工号2','姓名2','职务2','2022-07-24','派出地点2','派出事由2'),(73,'2022-07-24 11:55:03','工号3','姓名3','职务3','2022-07-24','派出地点3','派出事由3'),(74,'2022-07-24 11:55:03','工号4','姓名4','职务4','2022-07-24','派出地点4','派出事由4'),(75,'2022-07-24 11:55:03','工号5','姓名5','职务5','2022-07-24','派出地点5','派出事由5'),(76,'2022-07-24 11:55:03','工号6','姓名6','职务6','2022-07-24','派出地点6','派出事由6');
/*!40000 ALTER TABLE `paichurenyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shugangxinxi`
--

DROP TABLE IF EXISTS `shugangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shugangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huowumingcheng` varchar(200) DEFAULT NULL COMMENT '货物名称',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `yunshufangshi` varchar(200) DEFAULT NULL COMMENT '运输方式',
  `duifangdidian` varchar(200) DEFAULT NULL COMMENT '堆放地点',
  `shugangshijian` date DEFAULT NULL COMMENT '疏港时间',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='疏港信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shugangxinxi`
--

LOCK TABLES `shugangxinxi` WRITE;
/*!40000 ALTER TABLE `shugangxinxi` DISABLE KEYS */;
INSERT INTO `shugangxinxi` VALUES (41,'2022-07-24 11:55:03','货物名称1','规格1',1,'水路','堆放地点1','2022-07-24','备注1','工号1','姓名1'),(42,'2022-07-24 11:55:03','货物名称2','规格2',2,'水路','堆放地点2','2022-07-24','备注2','工号2','姓名2'),(43,'2022-07-24 11:55:03','货物名称3','规格3',3,'水路','堆放地点3','2022-07-24','备注3','工号3','姓名3'),(44,'2022-07-24 11:55:03','货物名称4','规格4',4,'水路','堆放地点4','2022-07-24','备注4','工号4','姓名4'),(45,'2022-07-24 11:55:03','货物名称5','规格5',5,'水路','堆放地点5','2022-07-24','备注5','工号5','姓名5'),(46,'2022-07-24 11:55:03','货物名称6','规格6',6,'水路','堆放地点6','2022-07-24','备注6','工号6','姓名6');
/*!40000 ALTER TABLE `shugangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2022-07-24 11:55:03');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangong`
--

DROP TABLE IF EXISTS `yuangong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonghao` varchar(200) NOT NULL COMMENT '工号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `zhiwu` varchar(200) DEFAULT NULL COMMENT '职务',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gonghao` (`gonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangong`
--

LOCK TABLES `yuangong` WRITE;
/*!40000 ALTER TABLE `yuangong` DISABLE KEYS */;
INSERT INTO `yuangong` VALUES (21,'2022-07-24 11:55:03','工号1','123456','姓名1','男',1,'职务1','13823888881','773890001@qq.com'),(22,'2022-07-24 11:55:03','工号2','123456','姓名2','男',2,'职务2','13823888882','773890002@qq.com'),(23,'2022-07-24 11:55:03','工号3','123456','姓名3','男',3,'职务3','13823888883','773890003@qq.com'),(24,'2022-07-24 11:55:03','工号4','123456','姓名4','男',4,'职务4','13823888884','773890004@qq.com'),(25,'2022-07-24 11:55:03','工号5','123456','姓名5','男',5,'职务5','13823888885','773890005@qq.com'),(26,'2022-07-24 11:55:03','工号6','123456','姓名6','男',6,'职务6','13823888886','773890006@qq.com');
/*!40000 ALTER TABLE `yuangong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-24 19:57:15
