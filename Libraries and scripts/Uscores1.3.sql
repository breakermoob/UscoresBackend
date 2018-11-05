

--
-- Drop Base de datos: `Uscores`
--


ALTER TABLE `Evento` DROP FOREIGN KEY `Evento_fk0`;

ALTER TABLE `Favoritos` DROP FOREIGN KEY `Favoritos_fk0`;

ALTER TABLE `Favoritos` DROP FOREIGN KEY `Favoritos_fk1`;

ALTER TABLE `MisTorneos` DROP FOREIGN KEY `MisTorneos_fk0`;

ALTER TABLE `MisTorneos` DROP FOREIGN KEY `MisTorneos_fk1`;


DROP TABLE IF EXISTS `Torneo`;

DROP TABLE IF EXISTS `Evento`;

DROP TABLE IF EXISTS `Usuario`;

DROP TABLE IF EXISTS `Favoritos`;

DROP TABLE IF EXISTS `MisTorneos`;





--
-- Base de datos: `Uscores`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Torneo`
--

CREATE TABLE IF NOT EXISTS `Torneo` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(20) NOT NULL,
	`deporte` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Torneo`(`id`,`nombre`,`deporte`) VALUES 
(1,'Champions League','Futbol'),
(2,'Champions League','Futsal'),
(3,'BasketPro','basquetbol'),
(4,'LEAGUE','Judo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Evento`
--
CREATE TABLE IF NOT EXISTS `Evento` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(20) NOT NULL,
	`fecha` date NOT NULL,
	`lugar` varchar(20) DEFAULT 'Udea',
	`id_Torneo` INT(20) NOT NULL,
	PRIMARY KEY (`id`),
	KEY `id_Torneo` (`id_Torneo`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Evento`(`id`,`nombre`,`fecha`, `lugar`, `id_Torneo`) VALUES 
(1,'Real Vs Barcelona','2018-05-29','UdeA',2),
(2,'UdeA Vs UdeM','2015-05-29','UdeA',2),
(3,'UdeA Vs Real','2016-05-29','UdeM',1),
(4,'UdeA Vs Unal','2017-05-29','UdeA',1);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE IF NOT EXISTS  `Usuario` (
	`correo` varchar(50) NOT NULL,
	`nombre` varchar(20) NOT NULL,
	`contrasena` varchar(20) NOT NULL,
	PRIMARY KEY (`correo`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Usuario`(`correo`,`nombre`,`contrasena`) VALUES 
('Vane@gmail.com','Vanessa Serna','1234'),
('pepe@gmail.com','Pedrito Serna','1234'),
('Leo@gmail.com','Leon Arango','1234');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Favoritos`
--

CREATE TABLE IF NOT EXISTS `Favoritos` (
	`correo` varchar(50) NOT NULL,
	`id_Evento` INT(20) NOT NULL,
	PRIMARY KEY (`correo`,`id_Evento`),
	KEY `correo` (`correo`),
	KEY `id_Evento` (`id_Evento`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Favoritos`(`correo`,`id_Evento`) VALUES 
('Vane@gmail.com',3),
('Vane@gmail.com',2),
('Leo@gmail.com',2);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MisTorneos`
--

CREATE TABLE IF NOT EXISTS `MisTorneos` (
	`correo` varchar(50) NOT NULL,
	`id_Torneo` INT(20) NOT NULL,
	PRIMARY KEY (`correo`,`id_Torneo`),
	KEY `id_Torneo` (`id_Torneo`),
	KEY `correo` (`correo`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `MisTorneos`(`correo`,`id_Torneo`) VALUES 
('Vane@gmail.com',1),
('Vane@gmail.com',2),
('Leo@gmail.com',2);


-- Filtros para las tablas
--

ALTER TABLE `Evento` ADD CONSTRAINT `Evento_fk0` FOREIGN KEY (`id_Torneo`) REFERENCES `Torneo`(`id`)ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Favoritos` ADD CONSTRAINT `Favoritos_fk0` FOREIGN KEY (`correo`) REFERENCES `Usuario`(`correo`)ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Favoritos` ADD CONSTRAINT `Favoritos_fk1` FOREIGN KEY (`id_Evento`) REFERENCES `Evento`(`id`)ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `MisTorneos` ADD CONSTRAINT `MisTorneos_fk0` FOREIGN KEY (`correo`) REFERENCES `Usuario`(`correo`)ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `MisTorneos` ADD CONSTRAINT `MisTorneos_fk1` FOREIGN KEY (`id_Torneo`) REFERENCES `Torneo`(`id`)ON DELETE CASCADE ON UPDATE CASCADE;


