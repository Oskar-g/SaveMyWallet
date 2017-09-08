-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-09-2017 a las 06:59:42
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
  `name_concept` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concepts`
--

INSERT INTO `concepts` (`name_concept`) VALUES
('papapa'),
('roger trolasho');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movements`
--

CREATE TABLE `movements` (
  `id_movement` int(11) NOT NULL,
  `id_wallet` int(11) DEFAULT NULL,
  `name_concept` varchar(40) DEFAULT NULL,
  `date_movement` date DEFAULT NULL,
  `quantity` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `movements`
--

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
  `id_user` int(11) NOT NULL,
  `name_user` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `name_user`, `surname`, `email`, `password`) VALUES
(1, 'usuario', 'apellido', 'email@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(2, 'tamara', 'apellido', 'tamara@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(3, 'roger', 'apellido', 'roger@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(4, 'oscar', 'apellido', 'oscar@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(5, 'hugo', 'apellido', 'hugo@email.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(6, 'prueba', 'probao', 'email', '81dc9bdb52d04dc20036dbd8313ed055');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wallets`
--

CREATE TABLE `wallets` (
  `id_wallet` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `name_wallet` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `concepts`
--
ALTER TABLE `concepts`
  ADD PRIMARY KEY (`name_concept`);

--
-- Indices de la tabla `movements`
--
ALTER TABLE `movements`
  ADD PRIMARY KEY (`id_movement`),
  ADD KEY `id_wallet` (`id_wallet`,`name_concept`),
  ADD KEY `id_concept` (`name_concept`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Indices de la tabla `wallets`
--
ALTER TABLE `wallets`
  ADD PRIMARY KEY (`id_wallet`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movements`
--
ALTER TABLE `movements`
  MODIFY `id_movement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `wallets`
--
ALTER TABLE `wallets`
  MODIFY `id_wallet` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
