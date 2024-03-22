DROP DATABASE IF EXISTS db_library;
CREATE DATABASE IF NOT EXISTS db_library;
USE db_library;

/*
Paso 1: Crear las Tablas en la Base de Datos

 Crear la tabla Autores: id, nombre, nacionalidad.
 Crear la tabla libros : id, titulo, año de publicación, precio, id autor.
 Establecer la relacion entre estas dos entidades.
*/

CREATE TABLE authors(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    nationality VARCHAR(30)
);

CREATE TABLE books(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    year_of_publication INT,
    price DOUBLE,
    id_author INT,
    FOREIGN KEY (id_author) REFERENCES authors(id) ON DELETE CASCADE
);

# ADD DATA
INSERT INTO authors(name, nationality) 
VALUES ("MIGUEL DE CERVANTES", "Spanish"),
("MARQUÉS DE SADE","French");

INSERT INTO books(title, year_of_publication, price, id_author)
VALUES
("Crimes of Love",1800,90000,2),
("Philosophy in the Bedroom and Other Stories", 1965, 60000,2),
("Don Quixote", 1605, 120000,1);
