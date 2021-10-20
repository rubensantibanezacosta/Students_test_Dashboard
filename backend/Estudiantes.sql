-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 18-10-2021 a las 13:58:07
-- Versión del servidor: 8.0.26-0ubuntu0.20.04.3
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Estudiantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `califications`
--

CREATE TABLE `califications` (
  `subjectid` int NOT NULL,
  `studentdni` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `year` int NOT NULL,
  `calification` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `califications`
--

INSERT INTO `califications` (`subjectid`, `studentdni`, `year`, `calification`) VALUES
(1, '444444444', 2021, 9.63);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `students`
--

CREATE TABLE `students` (
  `dni` varchar(15) NOT NULL,
  `surname` varchar(500) NOT NULL,
  `name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `students`
--

INSERT INTO `students` (`dni`, `surname`, `name`) VALUES
('444444444', 'Matinnez Gomez', 'David'),
('444444445', 'Martinez Perez', 'Angel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subjects`
--

CREATE TABLE `subjects` (
  `idsubject` int NOT NULL,
  `name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `subjects`
--

INSERT INTO `subjects` (`idsubject`, `name`) VALUES
(1, 'PGL'),
(2, 'PGV'),
(3, 'PGV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `years`
--

CREATE TABLE `years` (
  `year` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `years`
--

INSERT INTO `years` (`year`) VALUES
(2020),
(2021);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `califications`
--
ALTER TABLE `califications`
  ADD PRIMARY KEY (`subjectid`,`studentdni`,`year`),
  ADD UNIQUE KEY `year_califications_year` (`year`),
  ADD KEY `dni_dni_califications` (`studentdni`),
  ADD KEY `subjec_califications_subject` (`subjectid`);

--
-- Indices de la tabla `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`idsubject`);

--
-- Indices de la tabla `years`
--
ALTER TABLE `years`
  ADD PRIMARY KEY (`year`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `califications`
--
ALTER TABLE `califications`
  MODIFY `subjectid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `subjects`
--
ALTER TABLE `subjects`
  MODIFY `idsubject` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `califications`
--
ALTER TABLE `califications`
  ADD CONSTRAINT `FK_dni_califications` FOREIGN KEY (`studentdni`) REFERENCES `students` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_subject_califications` FOREIGN KEY (`subjectid`) REFERENCES `subjects` (`idsubject`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_year_califications` FOREIGN KEY (`year`) REFERENCES `years` (`year`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
