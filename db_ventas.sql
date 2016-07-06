/*
SQLyog Ultimate v8.82 
MySQL - 5.5.5-10.1.13-MariaDB : Database - db_inventario
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_inventario` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_inventario`;

/*Table structure for table `asignacion_equipo` */

DROP TABLE IF EXISTS `asignacion_equipo`;

CREATE TABLE `asignacion_equipo` (
  `id_asignacion_equipo` int(10) NOT NULL AUTO_INCREMENT,
  `fecha_desde` varchar(32) DEFAULT NULL COMMENT 'Fecha en que fue asignado el equipo.',
  `fecha_hasta` varchar(32) DEFAULT NULL COMMENT 'Fecha en que fue retirada la asignación de equipo.',
  `id_empleado` int(10) DEFAULT NULL,
  `id_equipo` int(10) DEFAULT NULL,
  `id_usuario` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_asignacion_equipo`),
  KEY `FK_asignacion_equipo` (`id_equipo`),
  KEY `FK_asignacion_empleado` (`id_empleado`),
  KEY `FK_asignacion_usuario` (`id_usuario`),
  CONSTRAINT `FK_asignacion_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FK_asignacion_equipo` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`),
  CONSTRAINT `FK_asignacion_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `caracteristica_equipo` */

DROP TABLE IF EXISTS `caracteristica_equipo`;

CREATE TABLE `caracteristica_equipo` (
  `id_caracteristica_equipo` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` text,
  `id_tipo` int(10) DEFAULT NULL,
  `id_equipo` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_caracteristica_equipo`),
  KEY `FK_caracteristica_equipo` (`id_equipo`),
  KEY `FK_caracteristica_tipo` (`id_tipo`),
  CONSTRAINT `FK_caracteristica_equipo` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`),
  CONSTRAINT `FK_caracteristica_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `cargo` */

DROP TABLE IF EXISTS `cargo`;

CREATE TABLE `cargo` (
  `id_cargo` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `empleado` */

DROP TABLE IF EXISTS `empleado`;

CREATE TABLE `empleado` (
  `id_empleado` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `id_cargo` int(10) DEFAULT NULL,
  `id_empresa` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `FK_empleado_empresa` (`id_empresa`),
  KEY `FK_empleado_cargo` (`id_cargo`),
  CONSTRAINT `FK_empleado_cargo` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`),
  CONSTRAINT `FK_empleado_empresa` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `id_empresa` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` text,
  `id_pais` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_empresa`),
  KEY `FK_empresa_pais` (`id_pais`),
  CONSTRAINT `FK_empresa_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `equipo` */

DROP TABLE IF EXISTS `equipo`;

CREATE TABLE `equipo` (
  `id_equipo` int(10) NOT NULL AUTO_INCREMENT,
  `numero_serie` varchar(128) DEFAULT NULL,
  `modelo` varchar(128) DEFAULT NULL,
  `activo` varchar(128) DEFAULT NULL COMMENT 'si/no',
  `fecha_compra` varchar(32) DEFAULT NULL,
  `fin_garantia` varchar(128) DEFAULT NULL,
  `ubicacion` varchar(128) DEFAULT NULL,
  `precio_compra` decimal(10,2) DEFAULT NULL,
  `valor_estimado` decimal(10,2) DEFAULT NULL,
  `id_marca` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_equipo`),
  KEY `FK_equipo_marca` (`id_marca`),
  CONSTRAINT `FK_equipo_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `estado` */

DROP TABLE IF EXISTS `estado`;

CREATE TABLE `estado` (
  `id_estado` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `marca` */

DROP TABLE IF EXISTS `marca`;

CREATE TABLE `marca` (
  `id_marca` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `id_pais` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Table structure for table `reporte_equipo` */

DROP TABLE IF EXISTS `reporte_equipo`;

CREATE TABLE `reporte_equipo` (
  `id_reporte_equipo` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` text,
  `fecha` varchar(32) DEFAULT NULL,
  `id_equipo` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_reporte_equipo`),
  KEY `FK_reporte_equipo` (`id_equipo`),
  CONSTRAINT `FK_reporte_equipo` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id_rol` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `tipo` */

DROP TABLE IF EXISTS `tipo`;

CREATE TABLE `tipo` (
  `id_tipo` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `imagen` varchar(128) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `correo` varchar(32) DEFAULT NULL,
  `contrasena` varchar(128) DEFAULT NULL,
  `id_estado` int(10) DEFAULT NULL,
  `id_rol` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK_usuario_rol` (`id_rol`),
  KEY `FK_usuario_estado` (`id_estado`),
  CONSTRAINT `FK_usuario_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`),
  CONSTRAINT `FK_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/* Procedure structure for procedure `sp_autenticarUsuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_autenticarUsuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_autenticarUsuario`(IN _email VARCHAR(32),in _contrasena VARCHAR(128))
BEGIN
	SELECT 
		id_usuario,nombre,correo,'none' AS contrasena,id_Estado,id_rol 
	FROM  usuario u
	WHERE
		u.`correo`=_email 
	AND
		u.`contrasena`=md5(_contrasena);
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
