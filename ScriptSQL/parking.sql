CREATE DATABASE parking;
USE parking;
DROP TABLE conductor;

CREATE TABLE conductor(
	id_conductor INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(55) NOT NULL,
    apellido VARCHAR(55) NOT NULL,
    dni VARCHAR(8) NOT NULL,
    nroBrevete VARCHAR(55) NOT NULL,
    id_auto INT,
    PRIMARY KEY (id_conductor),
    CONSTRAINT FK_conductor_auto
    FOREIGN KEY (id_auto) 
    REFERENCES auto(id_auto)
);

CREATE TABLE estacionamiento(
	id_estacionamiento INT NOT NULL,
    hora_entrada VARCHAR(55) NOT NULL,
    hora_salida VARCHAR(8) NOT NULL,
    pago VARCHAR(55) NOT NULL,
    id_auto INT,
    PRIMARY KEY (id_estacionamiento),
	CONSTRAINT FK_estacionamiento_auto
    FOREIGN KEY (id_auto)
    REFERENCES auto(id_auto)
);

CREATE TABLE auto(
	id_auto INT NOT NULL,
    placa VARCHAR(55) NOT NULL,
    color VARCHAR(55),
    PRIMARY KEY (id_auto)
);

INSERT INTO conductor (nombre, apellido, dni, nroBrevete, id_auto) VALUES ('Juan2', 'Perez', '235235', '234262', 1);
INSERT INTO conductor (nombre, apellido, dni, nroBrevete, id_auto) VALUES('qrqwqw','qasag','2342','2342342',0);



INSERT INTO auto VALUES(1, 'ASVASDA', 'Blanco');
INSERT INTO auto VALUES(2, 'AGASDAGF', 'Rojo');
INSERT INTO auto VALUES(3, 'SGSD', 'Negro');