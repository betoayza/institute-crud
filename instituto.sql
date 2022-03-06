-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-11-2020 a las 00:18:21
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `instituto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alumnos`
--

CREATE TABLE `Alumnos` (
  `id_alumno` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(30) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Alumnos`
--

INSERT INTO `Alumnos` (`id_alumno`, `nombre`, `apellido`) VALUES
(3, 'Beto', 'Ayza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `AlumnosMaterias`
--

CREATE TABLE `AlumnosMaterias` (
  `id_alumno` int(11) NOT NULL,
  `id_materia` int(11) NOT NULL,
  `id_profesor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `AlumnosMaterias`
--

INSERT INTO `AlumnosMaterias` (`id_alumno`, `id_materia`, `id_profesor`) VALUES
(3, 8, 9),
(3, 7, 11),
(3, 2, 7),
(3, 13, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Materias`
--

CREATE TABLE `Materias` (
  `id_materia` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Materias`
--

INSERT INTO `Materias` (`id_materia`, `nombre`) VALUES
(2, 'Programacion II'),
(3, 'Tecnical Digitales I'),
(5, 'Geografia'),
(6, 'Sistemas I'),
(7, 'Modelos'),
(8, 'Algebra'),
(9, 'Programacion I'),
(10, 'Programacion III'),
(11, 'Algebra II'),
(12, 'Tecnicas Digitales II'),
(13, 'Lengua');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MateriasCorrelativas`
--

CREATE TABLE `MateriasCorrelativas` (
  `id_materia` int(11) NOT NULL,
  `id_materia_correlativa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `MateriasCorrelativas`
--

INSERT INTO `MateriasCorrelativas` (`id_materia`, `id_materia_correlativa`) VALUES
(2, 9),
(10, 2),
(11, 8),
(12, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ProfeMaterias`
--

CREATE TABLE `ProfeMaterias` (
  `id_profesor` int(11) NOT NULL,
  `id_materia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ProfeMaterias`
--

INSERT INTO `ProfeMaterias` (`id_profesor`, `id_materia`) VALUES
(7, 2),
(8, 10),
(9, 8),
(10, 11),
(11, 7),
(7, 9),
(12, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Profesores`
--

CREATE TABLE `Profesores` (
  `id_profesor` int(11) NOT NULL,
  `nombre_apellido` varchar(100) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Profesores`
--

INSERT INTO `Profesores` (`id_profesor`, `nombre_apellido`) VALUES
(5, 'Cachito Prof'),
(6, 'Piripicha Prof'),
(7, 'Calvo'),
(8, 'Diego Corsi'),
(9, 'Boole Prof'),
(10, 'Pascal Prof'),
(11, 'Sofi Hernandez'),
(12, 'Pepito Prof');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Alumnos`
--
ALTER TABLE `Alumnos`
  ADD PRIMARY KEY (`id_alumno`);

--
-- Indices de la tabla `AlumnosMaterias`
--
ALTER TABLE `AlumnosMaterias`
  ADD KEY `id_alumno` (`id_alumno`);

--
-- Indices de la tabla `Materias`
--
ALTER TABLE `Materias`
  ADD PRIMARY KEY (`id_materia`);

--
-- Indices de la tabla `MateriasCorrelativas`
--
ALTER TABLE `MateriasCorrelativas`
  ADD KEY `id_materia` (`id_materia`);

--
-- Indices de la tabla `ProfeMaterias`
--
ALTER TABLE `ProfeMaterias`
  ADD KEY `id_profesor` (`id_profesor`);

--
-- Indices de la tabla `Profesores`
--
ALTER TABLE `Profesores`
  ADD PRIMARY KEY (`id_profesor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Alumnos`
--
ALTER TABLE `Alumnos`
  MODIFY `id_alumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Materias`
--
ALTER TABLE `Materias`
  MODIFY `id_materia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `Profesores`
--
ALTER TABLE `Profesores`
  MODIFY `id_profesor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
