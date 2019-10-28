CREATE DATABASE parking;
USE parking;
#DROP TABLE conductor;
#DROP DATABASE parking;

CREATE TABLE persona(
	id_persona INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(55) NOT NULL,
    apellido VARCHAR(55) NOT NULL,
    dni VARCHAR(8) NOT NULL,
    nro_licencia VARCHAR(55) NOT NULL,
    PRIMARY KEY (id_persona),
    UNIQUE (id_persona)
    
);

CREATE TABLE aparcamiento(
	id_aparcamiento INT NOT NULL AUTO_INCREMENT,
    id_persona INT NOT NULL,
    hora_entrada VARCHAR(55) NOT NULL,
    pago VARCHAR(55) NOT NULL,
	hora_salida VARCHAR(55),
    PRIMARY KEY (id_aparcamiento),
	CONSTRAINT FK_aparcamiento_persona
    FOREIGN KEY (id_persona)
    REFERENCES persona(id_persona)
);

CREATE TABLE vehiculo(
	id_vehiculo INT NOT NULL AUTO_INCREMENT,
    id_persona INT NOT NULL,
    marca VARCHAR(55),
    placa VARCHAR(55) NOT NULL,
    color VARCHAR(55),
    PRIMARY KEY (id_vehiculo),
    CONSTRAINT FK_vehiculo_persona
    FOREIGN KEY (id_persona) 
    REFERENCES persona(id_persona),
	UNIQUE (id_persona)
);

INSERT INTO persona (nombre, apellido, dni, nro_licencia) VALUES ('Jesus', 'Carrion', '74051212', 'T1123Z');
INSERT INTO persona (nombre, apellido, dni, nro_licencia) VALUES('Michael','Angelo','74082212','T1523Z');
INSERT INTO persona (nombre, apellido, dni, nro_licencia) VALUES('Tolkien','Howard','74082222','T1423Z');

SELECT * FROM persona;

INSERT INTO vehiculo (id_persona, marca, placa, color) VALUES(1, 'Rolls-Royce', 'B427-422', 'Blanco');
INSERT INTO vehiculo (id_persona, marca, placa, color) VALUES(2, 'Alfa Romeo', 'A415-422', 'Rojo');
INSERT INTO vehiculo (id_persona, marca, placa, color) VALUES(3, 'Tesla', 'C725-422', 'Negro');

SELECT * FROM vehiculo;

SELECT id_vehiculo, nombre, apellido,marca,placa,color
FROM vehiculo
INNER JOIN persona ON vehiculo.id_persona = persona.id_persona
ORDER BY id_vehiculo

