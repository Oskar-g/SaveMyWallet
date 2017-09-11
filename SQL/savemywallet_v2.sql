-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-09-2017 a las 08:05:56
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `savemywallet`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepts`
--

DROP DATABASE IF EXISTS savemywallet;
CREATE DATABASE savemywallet;
use savemywallet;


CREATE TABLE `concepts` (
  `name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concepts`
--

INSERT INTO `concepts` (`name`) VALUES
('cosa'),
('Otra mas'),
('veamos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movements`
--

CREATE TABLE `movements` (
  `id` int(11) NOT NULL,
  `wallet_id` int(11) DEFAULT NULL,
  `concept` varchar(40) DEFAULT NULL,
  `type` varchar(10) NOT NULL,
  `date` date DEFAULT NULL,
  `quantity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `movements`
--

INSERT INTO `movements` (`id`, `wallet_id`, `concept`, `type`, `date`, `quantity`) VALUES
(3, 1, 'veamos', 'ingreso', '2017-09-09', 1000),
(4, 1, 'Otra mas', 'gasto', '2017-09-10', -200),
(5, 9, 'cosa', 'ingreso', '2017-09-10', 300),
(6, 9, 'cosa', 'gasto', '2017-09-07', -250),
(7, 9, 'cosa', 'ingreso', '2017-06-07', 650),
(8, 9, 'cosa', 'ingreso', '2017-08-07', 650),
(9, 9, 'cosa', 'gasto', '2017-08-22', -50);

--
-- Disparadores `movements`
--
DELIMITER $$
CREATE TRIGGER `ins_concept` BEFORE INSERT ON `movements` FOR EACH ROW INSERT IGNORE INTO concepts values(NEW.name_concept)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `name`, `surname`, `email`, `password`) VALUES
(1, 'usuario', 'usuario', 'apellido', 'email@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(2, 'tamara', 'tamara', 'apellido', 'tamara@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(3, 'roger', 'roger', 'apellido', 'roger@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(4, 'oscar', 'oscar', 'apellido', 'oscar@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(5, 'hugo', 'hugo', 'apellido', 'hugo@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(6, 'prueba', 'prueba', 'probao', 'email', '81dc9bdb52d04dc20036dbd8313ed055');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wallets`
--

CREATE TABLE `wallets` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `wallets`
--

INSERT INTO `wallets` (`id`, `user_id`, `name`, `description`) VALUES
(1, 1, 'mi cartera', 'asdasdasd'),
(9, 4, 'mia', 'sisisisisnonono\r\n'),
(12, 4, 'caca', 'sii');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `concepts`
--
ALTER TABLE `concepts`
  ADD PRIMARY KEY (`name`);

--
-- Indices de la tabla `movements`
--
ALTER TABLE `movements`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_wallet` (`wallet_id`,`concept`),
  ADD KEY `id_concept` (`concept`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `wallets`
--
ALTER TABLE `wallets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movements`
--
ALTER TABLE `movements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `wallets`
--
ALTER TABLE `wallets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movements`
--
ALTER TABLE `movements`
  ADD CONSTRAINT `movements_ibfk_1` FOREIGN KEY (`wallet_id`) REFERENCES `wallets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `movements_ibfk_2` FOREIGN KEY (`concept`) REFERENCES `concepts` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `wallets`
--
ALTER TABLE `wallets`
  ADD CONSTRAINT `wallets_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
