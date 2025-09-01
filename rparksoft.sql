-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 01-09-2025 a las 15:11:48
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rparksoft`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresias`
--

DROP TABLE IF EXISTS `membresias`;
CREATE TABLE IF NOT EXISTS `membresias` (
  `idCliente` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL,
  `tipoVehiculo` varchar(250) NOT NULL,
  `placa` varchar(250) NOT NULL,
  `telefono` varchar(250) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `fechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `membresias`
--

INSERT INTO `membresias` (`idCliente`, `nombre`, `apellido`, `tipoVehiculo`, `placa`, `telefono`, `direccion`, `fechaRegistro`) VALUES
(111111, 'Roberto', 'Rosero', 'Automovil', 'XSX598', '3174989271', 'Carrera 28D4 # 72Y-31', '2025-07-25 16:15:53'),
(222222, 'Eliana ', 'Agredo', 'Motocicleta', 'ADR85C', '4444444', 'SAN MIGUEL', '2025-07-22 15:53:55');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `principal`
--

DROP TABLE IF EXISTS `principal`;
CREATE TABLE IF NOT EXISTS `principal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipoVehiculo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `placa` varchar(255) NOT NULL,
  `fechaHora` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `principal`
--

INSERT INTO `principal` (`id`, `tipoVehiculo`, `placa`, `fechaHora`) VALUES
(1, 'Motocicleta', 'XSX59C', '2025-06-20 16:41:29'),
(2, 'Automovil', 'ADI425', '2025-06-20 16:41:39'),
(6, 'Motocicleta', 'EMD58F', '2025-06-20 16:42:15'),
(7, 'Automovil', 'EVA478', '2025-06-20 16:42:25'),
(12, 'Automovil', 'UDG874', '2025-06-20 16:51:39'),
(13, 'Automovil', 'AUJ148', '2025-07-23 15:43:58'),
(20, 'Automovil', 'XSX598', '2025-07-25 14:41:32'),
(27, 'Bicicleta', '', '2025-09-01 09:24:37');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

DROP TABLE IF EXISTS `tarifas`;
CREATE TABLE IF NOT EXISTS `tarifas` (
  `tipo` varchar(25) NOT NULL,
  `valor` int NOT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tarifas`
--

INSERT INTO `tarifas` (`tipo`, `valor`) VALUES
('Automovil', 3500),
('Motocicleta', 1500),
('Bicicleta', 800);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
