-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 12-11-2015 a las 10:42:57
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `security`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `users`
-- 

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL default '1',
  PRIMARY KEY  (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `users`
-- 

INSERT INTO `users` VALUES ('jbugarin', 'pepito', 1);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `user_roles`
-- 

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY  (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `user_roles`
-- 

INSERT INTO `user_roles` VALUES (4, 'pepito', 'ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS `EDE_EVAL` (
  `Id_Evaluacion` INT NOT NULL COMMENT 'Autogenerado\n',
  `Cod_Evaluador` CHAR(8) NOT NULL,
  `Tipo_Evaluacion` CHAR(4) NOT NULL,
  `Rol_Evaluacion` CHAR(3) NOT NULL,
  `Cod_Evaluado` CHAR(8) NOT NULL,
  `Nombres_Evaluador` VARCHAR(100) NULL,
  `Posicion_Evaluador` VARCHAR(45) NULL,
  `Nombre_Evaluado` VARCHAR(100) NULL,
  `Posicion_Evaluado` VARCHAR(45) NULL,
  `Tipo_Empleado` CHAR(2) NULL,
  `Fecha_Ingreso_Evaluado` DATE NULL,
  `ind_Liderazgo` CHAR(1) NULL DEFAULT 'N' COMMENT 'S = Si\nN = No',
  `Num_Defi_Objetivos` INT NULL,
  `Num_Defi_Compromisos` INT NULL,
  `Estado_Defi` CHAR(2) NULL,
  `Num_ReInt_Objetivos` INT NULL,
  `Num_ReInt_Compromisos` INT NULL,
  `Estado_ReInt` CHAR(2) NULL,
  `Num_ReFin_Objetivos` INT NULL,
  `Num_ReFin_Compromisos` INT NULL,
  `Estado_Eval` CHAR(2) NULL,
  `Estado_Compe` CHAR(2) NULL,
  `Num_Eva_Forta` INT NULL,
  `Num_Eva_Opor` INT NULL,
  `Estado_Eva_Forta` CHAR(2) NULL,
  `Rev_Intermedia_Compromiso` VARCHAR(250) NULL,
  `Rev_Intermedia_Expectativa` VARCHAR(250) NULL,
  `Rev_Final_Compromiso` VARCHAR(250) NULL,
  `Rev_Final_Expectativa` VARCHAR(250) NULL,
  PRIMARY KEY (`Id_Evaluacion`, `Cod_Evaluador`, `Tipo_Evaluacion`, `Rol_Evaluacion`, `Cod_Evaluado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDE_OBJETIVOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDE_OBJETIVOS` (
  `Id_Evaluacion` INT NOT NULL,
  `Item` INT NOT NULL,
  `cod_Categoria` CHAR(2) NULL,
  `Por_Peso` DOUBLE NULL,
  `Definicion_Objetivo` VARCHAR(250) NULL,
  `Nombre_Indicador` VARCHAR(200) NULL,
  `Unidad` CHAR(3) NULL,
  `Tipo` CHAR(1) NULL,
  `Fuente_Validacion` VARCHAR(250) NULL,
  `Meta_Minimo` INT NULL,
  `Meta_Maximo` INT NULL,
  `Presiciones` VARCHAR(200) NULL,
  `Escala_Min_Meta` DOUBLE NULL,
  `Escala_Meta` DOUBLE NULL,
  `Escala_Max_Meta` DOUBLE NULL,
  `Escala_Min_Meta_Texto` VARCHAR(250) NULL,
  `Escala_Meta_Texto` VARCHAR(250) NULL,
  `Escala_Max_Meta_Texto` VARCHAR(250) NULL,
  `Por_Avance_Rev_Intermedia` DOUBLE NULL,
  `Comentario_Rev_Intermedia` VARCHAR(250) NULL,
  `ind_Rev_Objetivos_Intermedia` CHAR(1) NULL,
  `Por_Avance_Rev_Final` DOUBLE NULL,
  `Comentario_Rev_Final` VARCHAR(250) NULL,
  `ind_Rev_Objetivos_Final` CHAR(1) NULL,
  `Resultado` DOUBLE NULL,
  `Por_Cumplimiento` DOUBLE NULL,
  `Logro_por_Peso` DOUBLE NULL,
  `Comentario_Evaluacion` VARCHAR(250) NULL,
  PRIMARY KEY (`Id_Evaluacion`, `Item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDE_COMPROMISOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDE_COMPROMISOS` (
  `Id_Evaluacion` INT NOT NULL,
  `Item` INT NOT NULL,
  `Descripcion` VARCHAR(250) NULL,
  `Periodo` CHAR(2) NULL,
  `Fecha_Final` DATE NULL,
  `cod_Nivel_Eva` CHAR(2) NULL,
  `Comentario_Evaluacion` VARCHAR(250) NULL,
  PRIMARY KEY (`Id_Evaluacion`, `Item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDE_EXPECTATIVAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDE_EXPECTATIVAS` (
  `Id_Evaluacion` INT NOT NULL,
  `Item` INT NOT NULL,
  `Expec_Del_Evaluado` VARCHAR(250) NULL,
  `Expec_Sobre_Evaluado` VARCHAR(250) NULL,
  `Expec_Sobre_Equipo` VARCHAR(250) NULL,
  `Logros` VARCHAR(250) NULL,
  `Conocimiento_Clave` VARCHAR(250) NULL,
  `Fortalezas_Area` VARCHAR(250) NULL,
  `Oportunidades_Area` VARCHAR(250) NULL,
  `Comentarios` VARCHAR(250) NULL,
  PRIMARY KEY (`Id_Evaluacion`, `Item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDE_COMPETENCIAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDE_COMPETENCIAS` (
  `Id_Evaluacion` INT NOT NULL,
  `Item` INT NOT NULL,
  `cod_Pregunta` CHAR(4) NULL,
  `cod_Respuesta` CHAR(3) NULL,
  `comportamiento_Ident` VARCHAR(250) NULL,
  PRIMARY KEY (`Id_Evaluacion`, `Item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDE_FORTALEZAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDE_FORTALEZAS` (
  `Id_Evaluacion` INT NOT NULL,
  `Item` INT NOT NULL,
  `Descripcion` VARCHAR(250) NULL,
  PRIMARY KEY (`Id_Evaluacion`, `Item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDE_OPORTUNIDADES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDE_OPORTUNIDADES` (
  `Id_Evaluacion` INT NOT NULL,
  `Item` INT NOT NULL,
  `Descripcion` VARCHAR(250) NULL,
  PRIMARY KEY (`Id_Evaluacion`, `Item`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_TIPOEVA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_TIPOEVA` (
  `Tipo_Evaluacion` CHAR(4) NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  `Periodo` CHAR(4) NULL,
  `Estado` CHAR(1) NULL,
  PRIMARY KEY (`Tipo_Evaluacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = dec8;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_CATEGORIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_CATEGORIA` (
  `cod_Categoria` CHAR(2) NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  `Estado` CHAR(1) NULL,
  PRIMARY KEY (`cod_Categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_UNIDAD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_UNIDAD` (
  `Unidad` CHAR(3) NOT NULL,
  `Clasificacion` CHAR(2) NULL DEFAULT 'CT' COMMENT 'CT = Cuantitativo\nCL = Cualitativo',
  `Descripcion` VARCHAR(100) NULL,
  `Estado` CHAR(1) NULL,
  PRIMARY KEY (`Unidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_PERIODO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_PERIODO` (
  `Periodo` CHAR(2) NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  `Estado` CHAR(1) NULL DEFAULT 'A' COMMENT 'A = Activo\nI = Inactivo',
  PRIMARY KEY (`Periodo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_ESTADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_ESTADO` (
  `Estado` CHAR(2) NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  PRIMARY KEY (`Estado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_TIPOTRABAJADOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_TIPOTRABAJADOR` (
  `Tipo_Empleado` CHAR(2) NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  `Estado` CHAR(1) NULL DEFAULT 'A' COMMENT 'A = Activo\nI = Inactivo',
  PRIMARY KEY (`Tipo_Empleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEN_NIVEL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEN_NIVEL` (
  `cod_Nivel_Eva` CHAR(2) NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  `Requiere_Comp` CHAR(1) NULL DEFAULT 'S' COMMENT 'S = SI\nN = NO',
  `Estado` CHAR(1) NULL DEFAULT 'A' COMMENT 'A = Activo\nI = Inactivo',
  PRIMARY KEY (`cod_Nivel_Eva`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_COMPETENCIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_COMPETENCIA` (
  `cod_Pregunta` CHAR(4) NOT NULL,
  `Descripcion` VARCHAR(250) NULL,
  PRIMARY KEY (`cod_Pregunta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_NIVEL_EVAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_NIVEL_EVAL` (
  `cod_Respuesta` CHAR(3) NOT NULL,
  `Descripcion` VARCHAR(250) NULL,
  `Requiere_Comp` CHAR(2) NULL DEFAULT 'OB' COMMENT 'OB = Obligatorio\nOP = Opcional',
  PRIMARY KEY (`cod_Respuesta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_ROL_EVAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_ROL_EVAL` (
  `Rol_Evaluacion` CHAR(3) NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  `Estado` CHAR(1) NULL DEFAULT 'A' COMMENT 'A = Activo\nI = Inactivo',
  PRIMARY KEY (`Rol_Evaluacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDEM_EVALUADOS_CONF`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EDEM_EVALUADOS_CONF` (
  `Tipo_Evaluacion` CHAR(4) NOT NULL,
  `Cod_Evaluado` CHAR(8) NOT NULL,
  `Min_Compromisos` INT NULL,
  `Aplica_Expectativas` CHAR(1) NULL DEFAULT 'N' COMMENT 'S = Si\nN= No',
  PRIMARY KEY (`Cod_Evaluado`, `Tipo_Evaluacion`))
ENGINE = InnoDB;