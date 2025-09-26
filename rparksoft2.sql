-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 26-09-2025 a las 22:31:30
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
-- Base de datos: `rparksoft2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

DROP TABLE IF EXISTS `facturas`;
CREATE TABLE IF NOT EXISTS `facturas` (
  `id` int NOT NULL,
  `id_vehiculo` varchar(255) NOT NULL,
  `id_tarifa` int NOT NULL,
  `fecha_hora_ingreso` datetime NOT NULL,
  `fecha_hora_salida` datetime NOT NULL,
  `valor_pagar` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_vehiculo` (`id_vehiculo`(250)),
  KEY `id_tarifa` (`id_tarifa`),
  KEY `id_vehiculo_2` (`id_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`id`, `id_vehiculo`, `id_tarifa`, `fecha_hora_ingreso`, `fecha_hora_salida`, `valor_pagar`) VALUES
(1, 'XSX59C', 1, '2025-09-18 10:06:43', '2025-09-18 15:38:49', 9000),
(2, '222222-1', 9, '2025-09-18 10:41:52', '2025-09-18 15:53:22', 0),
(3, 'XSX59C', 4, '2025-09-18 15:52:24', '2025-09-18 15:59:06', 9000),
(4, '222222-1', 9, '2025-09-18 16:02:38', '2025-09-18 16:03:02', 0),
(5, 'XSX59C', 1, '2025-09-18 15:12:36', '2025-09-18 16:13:52', 3000),
(6, '222222-1', 9, '2025-09-18 15:12:44', '2025-09-18 16:14:06', 0),
(7, '222222-1', 9, '2025-09-18 16:15:44', '2025-09-19 12:16:17', 0),
(8, '222222-1', 3, '2025-09-19 12:17:34', '2025-09-22 08:59:15', 55200),
(9, 'XSX59C', 1, '2025-09-19 12:17:55', '2025-09-22 08:58:50', 103500),
(18, 'XSX59C', 4, '2025-09-22 09:20:53', '2025-09-22 09:21:17', 0),
(19, '222222-1', 3, '2025-09-22 09:22:46', '2025-09-22 10:37:47', 1600);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id`, `usuario`, `contrasena`) VALUES
(1, 'funcionario', 's2010'),
(2, 'administrador', 's2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

DROP TABLE IF EXISTS `servicios`;
CREATE TABLE IF NOT EXISTS `servicios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_vehiculo` varchar(255) NOT NULL,
  `id_tarifa` int NOT NULL,
  `fecha_hora_ingreso` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_vehiculo` (`id_vehiculo`),
  KEY `id_tarifa` (`id_tarifa`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id`, `id_vehiculo`, `id_tarifa`, `fecha_hora_ingreso`) VALUES
(20, '222222-1', 9, '2025-09-22 10:38:07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

DROP TABLE IF EXISTS `tarifas`;
CREATE TABLE IF NOT EXISTS `tarifas` (
  `id` int NOT NULL,
  `codigo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descripcion_por_vehiculo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `precio_unitario` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tarifas`
--

INSERT INTO `tarifas` (`id`, `codigo`, `descripcion_por_vehiculo`, `tipo`, `precio_unitario`) VALUES
(1, '1MH', 'Motocicleta', 'Hora', 1500),
(2, '2AH', 'Automovil', 'Hora', 3000),
(3, '3BH', 'Bicicleta', 'Hora', 800),
(4, '4MD', 'Motocicleta', 'Dia', 9000),
(5, '5AD', 'Automovil', 'Dia', 20000),
(6, '6BD', 'Bicicleta', 'Dia', 5000),
(7, '7MM', 'Motocicleta', 'Membresia mensual', 120000),
(8, '8AM', 'Automovil', 'Membresia mensual', 220000),
(9, '9BM', 'Bicicleta', 'Membresia mensual', 60000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `documento` varchar(25) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `membresia` tinyint(1) NOT NULL,
  `fecha_hora_membresia` datetime NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`documento`, `nombre`, `telefono`, `correo`, `membresia`, `fecha_hora_membresia`) VALUES
('111111', 'Roberto Rosero', '3174989271', 'rr', 0, '2025-09-17 16:35:38'),
('222222', 'Eliana Agredo', '44512156165', 'ea', 1, '2025-09-22 09:22:40');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
CREATE TABLE IF NOT EXISTS `vehiculos` (
  `placa` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `marca` varchar(250) NOT NULL,
  `usuario_id` varchar(25) NOT NULL,
  PRIMARY KEY (`placa`),
  KEY `usuario_id` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`placa`, `tipo`, `color`, `marca`, `usuario_id`) VALUES
('222222-1', 'Bicicleta', 'blanco', 'GMS', '222222'),
('XSX59C', 'Motocicleta', 'azul', 'TVS', '111111');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`placa`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facturas_ibfk_2` FOREIGN KEY (`id_tarifa`) REFERENCES `tarifas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_ibfk_1` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`placa`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `servicios_ibfk_2` FOREIGN KEY (`id_tarifa`) REFERENCES `tarifas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`documento`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
