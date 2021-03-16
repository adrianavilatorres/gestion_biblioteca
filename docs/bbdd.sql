CREATE DATABASE gestion_biblioteca CHARACTER SET utf16 COLLATE utf16_spanish_ci;

USE gestion_biblioteca;

CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` varchar(12) UNIQUE NOT NULL,
  `password` varchar(20) NOT NULL,
  `userType` varchar(20) NOT NULL
);

CREATE TABLE `libros` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `editorial` varchar(30) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `anno_publicacion` date NOT NULL,
  `isbn` varchar(10) UNIQUE NOT NULL
);

CREATE TABLE `prestamos` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `usuario_id`  int UNIQUE NOT NULL,
  `prorroga` date NOT NULL,
  `estado` varchar(20) NOT NULL,
  `libro_id` int UNIQUE NOT NULL,
FOREIGN KEY (`libro_id`) REFERENCES `libros` (`id`) ON DELETE CASCADE,
FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
);

CREATE TABLE `reseñas` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `estrellas`  int(1) NOT NULL,
  `comentario` varchar(100) NOT NULL,
  `usuario_id`  int UNIQUE NOT NULL,
  `fecha` date NOT NULL,
  `libro_id` int  NOT NULL,
FOREIGN KEY (`libro_id`) REFERENCES `libros` (`id`) ON DELETE CASCADE,
FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
);



INSERT INTO `usuarios` (`username`, `password`,`userType`) VALUES
('adrian', 'adrian','alumno'),
('samuel', 'samuel','profesor'),
('admin', 'admin','admin'),
('russell','delgado','alumno'),
('claudio','blazquez','alumno'),
('alberto','martos','alumno'),
('sergio','lapaz','alumno'),
('antonio','muñoz','alumno'),
('federico','garcia','admin'),
('leo','messi','profesor');

INSERT INTO `libros` (`editorial`, `titulo`, `anno_publicacion`, `isbn`) VALUES
('SM', 'Programacion I', '2017-01-25', '148759852A'),
('ANAYA', 'Paginas Web', '2012-07-14', '968741200B'),
('Panini', 'Ofimatica', '2013-02-01', '968741200C'),
('Galera', 'Seguridad Informatica', '2016-04-25', '962991200D'),
('Neo', 'Redes', '2017-05-13', '960091200E'),
('Literatura', 'Sistemas operativos monopuestos', '2018-09-09', '918741200F'),
('PlanetaLibros', 'Sistemas operativos en red', '2015-12-19', '968366200G'),
('Sportula', 'Montaje', '2019-01-28', '968187200H'),
('Ooso', 'Android', '2017-10-04', '961231200I'),
('Herder', 'FOL', '2016-6-16', '968699200J');

INSERT INTO `prestamos` (`fecha_inicio`, `fecha_fin`, `usuario_id`, `prorroga`, `estado`, `libro_id`) VALUES
('2020-02-08', '2020-02-14', 1, '2020-02-17', 'Excelente', 1);
INSERT INTO `prestamos` (`fecha_inicio`, `fecha_fin`, `usuario_id`, `prorroga`, `estado`, `libro_id`) VALUES
('2020-02-08', '2020-02-14', 2, '2020-02-17', 'Excelente', 2);


INSERT INTO `reseñas` (`estrellas`, `comentario`, `usuario_id`, `fecha`, `libro_id`) VALUES
(4, 'El libro es muy didactico', 1, '2020-02-17', 1);
INSERT INTO `reseñas` (`estrellas`, `comentario`, `usuario_id`, `fecha`, `libro_id`) VALUES
(4, 'El libro es muy didactico', 2, '2020-02-17', 2);