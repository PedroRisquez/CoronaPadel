-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2020 a las 11:56:11
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coronapadel`
--
CREATE DATABASE IF NOT EXISTS `coronapadel` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `coronapadel`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administracion`
--

CREATE TABLE `administracion` (
  `idAdministracion` int(11) NOT NULL,
  `dniAdministrador` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `administracion`
--

INSERT INTO `administracion` (`idAdministracion`, `dniAdministrador`, `nombre`) VALUES
(7, '49135819P', 'FIDP'),
(8, '49135819E', 'FNDP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacionglobal`
--

CREATE TABLE `clasificacionglobal` (
  `idClasificacionGlobal` int(11) NOT NULL,
  `idAdministracion` int(11) DEFAULT NULL,
  `dni` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `puntuacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clasificacionglobal`
--

INSERT INTO `clasificacionglobal` (`idClasificacionGlobal`, `idAdministracion`, `dni`, `puntuacion`) VALUES
(29, 7, '49135819N', 0),
(30, 7, '49135819D', 0),
(31, 7, '49135811E', 0),
(32, 7, '49135819A', 0),
(33, 7, '49135819J', 0),
(34, 7, '49135819F', 0),
(35, 7, '19316812Z', 0),
(36, 7, '12309843A', 0),
(37, 8, '12053730P', 0),
(38, 8, '09346812N', 0),
(39, 8, '22211144K', 0),
(40, 8, '10493858K', 0),
(41, 7, '11155532D', 0),
(42, 7, '99988876J', 0),
(43, 7, '19667137F', 0),
(44, 7, '90709695A', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `competicion`
--

CREATE TABLE `competicion` (
  `idCompeticion` int(11) NOT NULL,
  `idAdministracion` int(11) DEFAULT NULL,
  `dni` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `formato` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `nPartidos` int(15) NOT NULL,
  `nParejas` int(15) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `privada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `competicion`
--

INSERT INTO `competicion` (`idCompeticion`, `idAdministracion`, `dni`, `formato`, `fechaInicio`, `fechaFin`, `nPartidos`, `nParejas`, `nombre`, `descripcion`, `privada`) VALUES
(17, 7, '49135819P', 'Liga', '2020-06-06 12:00:00', '2020-07-12 12:00:00', 12, 4, 'Liga Sevillana', 'Liga provincial', 1),
(18, 8, '49135819E', 'Liga', '2020-06-07 12:00:00', '2020-07-18 12:00:00', 12, 4, 'Liga de Dos Hermanas', 'Liga publica nazarena', 0),
(19, 7, '49135819P', 'Liga', '2020-06-13 12:00:00', '2020-09-20 12:00:00', 30, 6, 'Torneo UPO', 'Torneo de la EPS', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pareja`
--

CREATE TABLE `pareja` (
  `idPareja` int(11) NOT NULL,
  `dni1` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dni2` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pareja`
--

INSERT INTO `pareja` (`idPareja`, `dni1`, `dni2`, `nombre`) VALUES
(15, '49135819N', '49135819D', 'Daniel y Nerea'),
(16, '49135811E', '49135819A', 'Araceli y Andres'),
(17, '49135819J', '49135819F', 'Fernando y Javier'),
(18, '19316812Z', '12309843A', 'Alfonso y Pepe'),
(19, '12053730P', '09346812N', 'Pepa y Pupu'),
(20, '22211144K', '10493858K', 'Manu y Manuel'),
(21, '11155532D', '99988876J', 'Juan y Andres'),
(22, '19667137F', '90709695A', 'Adrian Y Hector'),
(23, '17493753X', '89095172H', 'Ivan y Fernando');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE `partido` (
  `idPartido` int(11) NOT NULL,
  `idCompeticion` int(11) DEFAULT NULL,
  `dniArbitro` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `duracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `partido`
--

INSERT INTO `partido` (`idPartido`, `idCompeticion`, `dniArbitro`, `fechaInicio`, `duracion`) VALUES
(102, 17, '55555555E', '2020-06-06 12:00:00', 0),
(103, 17, '55555555E', '2020-06-06 12:00:00', 0),
(104, 17, '55555555E', '2020-06-06 12:00:00', 0),
(105, 17, '55555555E', '2020-06-07 12:00:00', 0),
(106, 17, '55555555E', '2020-06-07 12:00:00', 0),
(107, 17, '55555555E', '2020-06-07 12:00:00', 0),
(108, 17, '55555555E', '2020-06-13 12:00:00', 0),
(109, 17, '55555555E', '2020-06-13 12:00:00', 0),
(110, 17, '55555555E', '2020-06-13 12:00:00', 0),
(111, 17, '55555555E', '2020-06-14 12:00:00', 0),
(112, 17, '55555555E', '2020-06-14 12:00:00', 0),
(113, 17, '55555555E', '2020-06-14 12:00:00', 0),
(114, 18, '49135819M', '2020-06-07 12:00:00', 0),
(115, 18, '49135819M', '2020-06-13 12:00:00', 0),
(116, 18, '49135819M', '2020-06-14 12:00:00', 0),
(117, 18, '49135819M', '2020-06-20 12:00:00', 0),
(118, 18, '49135819M', '2020-06-21 12:00:00', 0),
(119, 18, '49135819M', '2020-06-27 12:00:00', 0),
(120, 18, '49135819M', '2020-06-28 12:00:00', 0),
(121, 18, '49135819M', '2020-07-04 12:00:00', 0),
(122, 18, '49135819M', '2020-07-05 12:00:00', 0),
(123, 18, '49135819M', '2020-07-11 12:00:00', 0),
(124, 18, '49135819M', '2020-07-12 12:00:00', 0),
(125, 18, '49135819M', '2020-07-18 12:00:00', 0),
(126, 19, '09693767K', '2020-06-13 12:00:00', 0),
(127, 19, '09693767K', '2020-06-14 12:00:00', 0),
(128, 19, '09693767K', '2020-06-20 12:00:00', 0),
(129, 19, '09693767K', '2020-06-21 12:00:00', 0),
(130, 19, '09693767K', '2020-06-27 12:00:00', 0),
(131, 19, '09693767K', '2020-06-28 12:00:00', 0),
(132, 19, '09693767K', '2020-07-04 12:00:00', 0),
(133, 19, '09693767K', '2020-07-05 12:00:00', 0),
(134, 19, '09693767K', '2020-07-11 12:00:00', 0),
(135, 19, '09693767K', '2020-07-12 12:00:00', 0),
(136, 19, '09693767K', '2020-07-18 12:00:00', 0),
(137, 19, '09693767K', '2020-07-19 12:00:00', 0),
(138, 19, '09693767K', '2020-07-25 12:00:00', 0),
(139, 19, '09693767K', '2020-07-26 12:00:00', 0),
(140, 19, '09693767K', '2020-08-01 12:00:00', 0),
(141, 19, '09693767K', '2020-08-02 12:00:00', 0),
(142, 19, '09693767K', '2020-08-08 12:00:00', 0),
(143, 19, '09693767K', '2020-08-09 12:00:00', 0),
(144, 19, '09693767K', '2020-08-15 12:00:00', 0),
(145, 19, '09693767K', '2020-08-16 12:00:00', 0),
(146, 19, '09693767K', '2020-08-22 12:00:00', 0),
(147, 19, '09693767K', '2020-08-23 12:00:00', 0),
(148, 19, '09693767K', '2020-08-29 12:00:00', 0),
(149, 19, '09693767K', '2020-08-30 12:00:00', 0),
(150, 19, '09693767K', '2020-09-05 12:00:00', 0),
(151, 19, '09693767K', '2020-09-06 12:00:00', 0),
(152, 19, '09693767K', '2020-09-12 12:00:00', 0),
(153, 19, '09693767K', '2020-09-13 12:00:00', 0),
(154, 19, '09693767K', '2020-09-19 12:00:00', 0),
(155, 19, '09693767K', '2020-09-20 12:00:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pista`
--

CREATE TABLE `pista` (
  `idPista` int(11) NOT NULL,
  `idAdministracion` int(11) DEFAULT NULL,
  `localizacion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipoDeCubierta` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipoDePista` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipoDeSuelo` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pista`
--

INSERT INTO `pista` (`idPista`, `idAdministracion`, `localizacion`, `tipoDeCubierta`, `tipoDePista`, `tipoDeSuelo`) VALUES
(4, 7, 'Calle Isaac Peral 32', 'Semi-covered', 'Wall', 'Concrete'),
(5, 7, 'Calle Costurera 1', 'Outdoors', 'Glass', 'Concrete'),
(6, 8, 'Calle Vistazul 36', 'Semi-covered', 'Glass', 'Resin'),
(7, 8, 'La Motilla', 'Outdoors', 'Wall', 'Grass');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ranking`
--

CREATE TABLE `ranking` (
  `idRanking` int(11) NOT NULL,
  `idCompeticion` int(11) DEFAULT NULL,
  `idPareja` int(11) DEFAULT NULL,
  `puntuacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ranking`
--

INSERT INTO `ranking` (`idRanking`, `idCompeticion`, `idPareja`, `puntuacion`) VALUES
(26, 17, 15, 0),
(27, 17, 16, 0),
(28, 17, 17, 0),
(29, 17, 18, 0),
(30, 18, 19, 0),
(31, 18, 20, 0),
(32, 19, 21, 0),
(33, 19, 22, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE `resultado` (
  `idResultado` int(11) NOT NULL,
  `idPartido` int(11) DEFAULT NULL,
  `idParejaLocal` int(11) DEFAULT NULL,
  `idParejaVisitante` int(11) DEFAULT NULL,
  `puntuacionLocal` int(11) NOT NULL,
  `puntuacionVisitante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `resultado`
--

INSERT INTO `resultado` (`idResultado`, `idPartido`, `idParejaLocal`, `idParejaVisitante`, `puntuacionLocal`, `puntuacionVisitante`) VALUES
(103, 102, 15, 16, 0, 0),
(104, 103, 15, 17, 0, 0),
(105, 104, 15, 18, 0, 0),
(106, 105, 16, 15, 0, 0),
(107, 106, 16, 17, 0, 0),
(108, 107, 16, 18, 0, 0),
(109, 108, 17, 15, 0, 0),
(110, 109, 17, 16, 0, 0),
(111, 110, 17, 18, 0, 0),
(112, 111, 18, 15, 0, 0),
(113, 112, 18, 16, 0, 0),
(114, 113, 18, 17, 0, 0),
(115, 114, 19, 20, 0, 0),
(116, 115, 20, 19, 0, 0),
(117, 116, NULL, NULL, 0, 0),
(118, 117, NULL, NULL, 0, 0),
(119, 118, NULL, NULL, 0, 0),
(120, 119, NULL, NULL, 0, 0),
(121, 120, NULL, NULL, 0, 0),
(122, 121, NULL, NULL, 0, 0),
(123, 122, NULL, NULL, 0, 0),
(124, 123, NULL, NULL, 0, 0),
(125, 124, NULL, NULL, 0, 0),
(126, 125, NULL, NULL, 0, 0),
(127, 126, 21, 22, 0, 0),
(128, 127, 22, 21, 0, 0),
(129, 128, NULL, NULL, 0, 0),
(130, 129, NULL, NULL, 0, 0),
(131, 130, NULL, NULL, 0, 0),
(132, 131, NULL, NULL, 0, 0),
(133, 132, NULL, NULL, 0, 0),
(134, 133, NULL, NULL, 0, 0),
(135, 134, NULL, NULL, 0, 0),
(136, 135, NULL, NULL, 0, 0),
(137, 136, NULL, NULL, 0, 0),
(138, 137, NULL, NULL, 0, 0),
(139, 138, NULL, NULL, 0, 0),
(140, 139, NULL, NULL, 0, 0),
(141, 140, NULL, NULL, 0, 0),
(142, 141, NULL, NULL, 0, 0),
(143, 142, NULL, NULL, 0, 0),
(144, 143, NULL, NULL, 0, 0),
(145, 144, NULL, NULL, 0, 0),
(146, 145, NULL, NULL, 0, 0),
(147, 146, NULL, NULL, 0, 0),
(148, 147, NULL, NULL, 0, 0),
(149, 148, NULL, NULL, 0, 0),
(150, 149, NULL, NULL, 0, 0),
(151, 150, NULL, NULL, 0, 0),
(152, 151, NULL, NULL, 0, 0),
(153, 152, NULL, NULL, 0, 0),
(154, 153, NULL, NULL, 0, 0),
(155, 154, NULL, NULL, 0, 0),
(156, 155, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `dni` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombreCompleto` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `clave` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `sexo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `rol` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ladoDeJuego` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fotoPerfil` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`dni`, `nombreCompleto`, `usuario`, `clave`, `email`, `sexo`, `rol`, `categoria`, `ladoDeJuego`, `fotoPerfil`) VALUES
('09346812N', 'Pepa', 'pepa', '￼ﾉ{hￆh￥j&￲\0￫￉ﾻ', 'pepa@gmail.com', 'Other', 'Player', 'Year 8-9', 'Right', NULL),
('09693767K', 'Alberto Gomez', 'albergom', '=ﾌ￡cﾝ<tT￺￳T!Q￁', 'albergom@gmail.com', 'F', 'Referee', NULL, NULL, NULL),
('10493858K', 'Manuel Molina', 'manumo', '+Lￇﾐￃﾍﾠￜ6aV96ﾦ', 'manu@gmail.com', 'M', 'Player', 'Year 8-9', 'Backhand', NULL),
('11155532D', 'Andres Chacon', 'andresch', 'ﾰ&ￍ￞<ￚ￟e9ﾭﾮUﾮGﾞn', 'andresch@gmail.com', 'M', 'Player', 'Year 8-9', 'Right', NULL),
('12053730P', 'Pupu', 'pupu', '9zhﾩￅﾘ￩2`ￃ￵ﾭF,)', 'pupu@gmail.com', 'M', 'Player', 'Year 8-9', 'Both', NULL),
('12309843A', 'Alfonso Gonzalez', 'alfon', '7Aﾸrﾊ￶ﾼ￸ﾕ￯ￒ}3￦x', 'alfon@gmail.com', 'M', 'Player', 'Year 8-9', 'Backhand', NULL),
('17493753X', 'Ivan Santos', 'ivansan', '#ￏ￠￈ﾗￍ￸ﾹ￳ﾅJ{+R', 'ivansan@gmail.com', 'F', 'Player', 'Year 8-9', 'Backhand', NULL),
('19316812Z', 'pepe', 'pepe', '*e\0!\"￠ﾌGTﾥlPﾜ', 'pepe@itmola.com', 'M', 'Player', 'Year 8-9', 'Backhand', NULL),
('19667137F', 'Hector Moreno', 'hectormo', '>?ﾜ￺p￩￿￤ﾆￜ￡ﾯ￳S', 'hectormo@gmail.com', 'M', 'Player', 'Year 8-9', 'Right', NULL),
('22211144K', 'Manuel Jesus Dominguez', 'manujdom', 'ﾬￌￔﾆﾚ￯ￓﾖﾔￄh￑ﾔ', 'manujdom@gmail.com', 'F', 'Player', 'Year 8-9', 'Both', NULL),
('49135811E', 'Araceli Calvillo Soriano', 'araceli123', 'ﾶ￪zￕu￹aﾻ￙ﾴU ', 'araceli@gmail.com', 'M', 'Player', 'Senior', 'Ambos', NULL),
('49135819A', 'Juan Andres Venegas Cortes', 'javencor', '￳TﾮnC￟C2\r\nCￊQﾽk>', 'javencor@gmail.com', 'M', 'Jugador', NULL, NULL, NULL),
('49135819D', 'Daniel Emilio Luque Lopez', 'deluqlop', 'ﾤ>ﾯﾜ3ﾗ￺Atﾽﾣeￛ', 'deluqnos@gmail.com', 'M', 'Jugador', NULL, NULL, NULL),
('49135819E', 'Pedro Risquez Calvillo', 'priscal', '￭ﾗￔ﾿ﾵￔNSh￩ﾃﾬ￰a￰', 'pedrorisquez@hotmail.com', 'M', 'Administrador', NULL, NULL, NULL),
('49135819F', 'Fernando Melgar', 'fmel', 'ﾭrￇﾔﾛs￼ﾤHOﾉﾏ', 'fmel@gmail.com', 'M', 'Jugador', 'Senior', 'Derecha', NULL),
('49135819J', 'Javier Rodriguez Bermudo', 'jrodber', 'ﾡ￷ﾺ￲$ch￶￘￝ﾻￖﾸ	￵', 'jrodber@gmail.com', 'M', 'Jugador', NULL, NULL, NULL),
('49135819M', 'Manuel Gandul Perez', 'mganper', '￑>ﾤﾟ=￲?[;ￍￎZvx', 'mganper@gmail.com', 'M', 'Arbitro', NULL, NULL, ''),
('49135819N', 'Nerea Marquez Egea', 'nmarege', '4ﾙSySu\\ﾬ￑ﾸ￮E0￩', 'nmarege@gmail.com', 'F', 'Jugador', NULL, NULL, NULL),
('49135819P', 'Paula Melgar Guerra', 'pmelgue', 'fYﾗzBqYoﾴq6￾`H9ﾖ', 'paulamelgar24@gmail.com', 'F', 'Administrador', NULL, NULL, NULL),
('55555555E', 'Eduardo', 'edu', '6ﾎﾙﾟSﾞﾹﾋX￶￲ﾏs￸￢', 'edu@gmail.com', 'H', 'Arbitro', NULL, NULL, NULL),
('89095172H', 'Fernando Moreno', 'fermor', '￙ﾅ>￘E7ﾲﾠ1ﾌHAﾯ', 'fermor@gmail.com', 'M', 'Player', 'Year 8-9', 'Right', NULL),
('90709695A', 'Adrian Vazquez', 'adrivaz', 'ﾠr\'ﾗﾸﾷ~ﾔOﾶ<Q￾ﾩ', 'adrivaz@gmail.com', 'M', 'Player', 'Year 8-9', 'Right', NULL),
('99988876J', 'Juan Alberto Gallardo', 'jagalgom', '^ﾒg8GRK\0rlￛ}@￘\0', 'juanal@gmail.com', 'M', 'Player', 'Year 8-9', 'Right', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administracion`
--
ALTER TABLE `administracion`
  ADD PRIMARY KEY (`idAdministracion`),
  ADD KEY `FK_dniAdministrador` (`dniAdministrador`) USING BTREE;

--
-- Indices de la tabla `clasificacionglobal`
--
ALTER TABLE `clasificacionglobal`
  ADD PRIMARY KEY (`idClasificacionGlobal`),
  ADD KEY `FK_idAdministracion` (`idAdministracion`),
  ADD KEY `FK_dni` (`dni`) USING BTREE;

--
-- Indices de la tabla `competicion`
--
ALTER TABLE `competicion`
  ADD PRIMARY KEY (`idCompeticion`),
  ADD KEY `FK_idAdministracion` (`idAdministracion`),
  ADD KEY `FK_dni` (`dni`);

--
-- Indices de la tabla `pareja`
--
ALTER TABLE `pareja`
  ADD PRIMARY KEY (`idPareja`),
  ADD KEY `FK_dni1` (`dni1`) USING BTREE,
  ADD KEY `FK_dni2` (`dni2`) USING BTREE;

--
-- Indices de la tabla `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`idPartido`),
  ADD KEY `FK_idCompeticion` (`idCompeticion`),
  ADD KEY `FK_dniArbitro` (`dniArbitro`);

--
-- Indices de la tabla `pista`
--
ALTER TABLE `pista`
  ADD PRIMARY KEY (`idPista`),
  ADD KEY `FK_idAdministracion` (`idAdministracion`);

--
-- Indices de la tabla `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`idRanking`),
  ADD KEY `FK_idCompeticion` (`idCompeticion`),
  ADD KEY `FK_idPareja` (`idPareja`);

--
-- Indices de la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD PRIMARY KEY (`idResultado`),
  ADD KEY `FK_resultado` (`idPartido`,`idParejaLocal`,`idParejaVisitante`),
  ADD KEY `idParejaLocal` (`idParejaLocal`),
  ADD KEY `idParejaVisitante` (`idParejaVisitante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administracion`
--
ALTER TABLE `administracion`
  MODIFY `idAdministracion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `clasificacionglobal`
--
ALTER TABLE `clasificacionglobal`
  MODIFY `idClasificacionGlobal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `competicion`
--
ALTER TABLE `competicion`
  MODIFY `idCompeticion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `pareja`
--
ALTER TABLE `pareja`
  MODIFY `idPareja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `partido`
--
ALTER TABLE `partido`
  MODIFY `idPartido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=186;

--
-- AUTO_INCREMENT de la tabla `pista`
--
ALTER TABLE `pista`
  MODIFY `idPista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ranking`
--
ALTER TABLE `ranking`
  MODIFY `idRanking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `resultado`
--
ALTER TABLE `resultado`
  MODIFY `idResultado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administracion`
--
ALTER TABLE `administracion`
  ADD CONSTRAINT `administracion_ibfk_1` FOREIGN KEY (`dniAdministrador`) REFERENCES `usuario` (`dni`);

--
-- Filtros para la tabla `clasificacionglobal`
--
ALTER TABLE `clasificacionglobal`
  ADD CONSTRAINT `clasificacionglobal_ibfk_1` FOREIGN KEY (`idAdministracion`) REFERENCES `administracion` (`idAdministracion`) ON DELETE SET NULL,
  ADD CONSTRAINT `clasificacionglobal_ibfk_2` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`) ON DELETE SET NULL;

--
-- Filtros para la tabla `competicion`
--
ALTER TABLE `competicion`
  ADD CONSTRAINT `competicion_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`) ON DELETE SET NULL,
  ADD CONSTRAINT `competicion_ibfk_2` FOREIGN KEY (`idAdministracion`) REFERENCES `administracion` (`idAdministracion`) ON DELETE SET NULL;

--
-- Filtros para la tabla `pareja`
--
ALTER TABLE `pareja`
  ADD CONSTRAINT `pareja_ibfk_1` FOREIGN KEY (`dni1`) REFERENCES `usuario` (`dni`) ON DELETE SET NULL,
  ADD CONSTRAINT `pareja_ibfk_2` FOREIGN KEY (`dni2`) REFERENCES `usuario` (`dni`) ON DELETE SET NULL;

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `partido_ibfk_1` FOREIGN KEY (`idCompeticion`) REFERENCES `competicion` (`idCompeticion`),
  ADD CONSTRAINT `partido_ibfk_2` FOREIGN KEY (`dniArbitro`) REFERENCES `usuario` (`dni`);

--
-- Filtros para la tabla `pista`
--
ALTER TABLE `pista`
  ADD CONSTRAINT `pista_ibfk_1` FOREIGN KEY (`idAdministracion`) REFERENCES `administracion` (`idAdministracion`) ON DELETE SET NULL;

--
-- Filtros para la tabla `ranking`
--
ALTER TABLE `ranking`
  ADD CONSTRAINT `ranking_ibfk_1` FOREIGN KEY (`idPareja`) REFERENCES `pareja` (`idPareja`),
  ADD CONSTRAINT `ranking_ibfk_2` FOREIGN KEY (`idCompeticion`) REFERENCES `competicion` (`idCompeticion`);

--
-- Filtros para la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD CONSTRAINT `resultado_ibfk_1` FOREIGN KEY (`idParejaLocal`) REFERENCES `pareja` (`idPareja`),
  ADD CONSTRAINT `resultado_ibfk_2` FOREIGN KEY (`idParejaVisitante`) REFERENCES `pareja` (`idPareja`),
  ADD CONSTRAINT `resultado_ibfk_3` FOREIGN KEY (`idPartido`) REFERENCES `partido` (`idPartido`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
