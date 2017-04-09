drop database if exists Rubrica;
create database if not exists Rubrica
	default character set utf8
    default collate utf8_unicode_ci;

use Rubrica;

CREATE TABLE IF NOT EXISTS Telefono (
	id int not null auto_increment,
    modello VARCHAR(15) NOT NULL,
    size VARCHAR(64),
    weight INT(4),
    marca VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Utente (
    idUt INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL,
    cognome VARCHAR(20) NOT NULL,
    indirizzo VARCHAR(30),
    telefono VARCHAR(10) NOT NULL unique,
    email VARCHAR(30),
    idTel int NOT NULL,
    PRIMARY KEY (idUt),
    CONSTRAINT fk_modelloTel FOREIGN KEY (idTel) REFERENCES Telefono(id)
);