CREATE DATABASE IF NOT EXISTS restauracja_db;
USE restauracja_db;

CREATE TABLE IF NOT EXISTS menu (
  id_dania int(10) NOT NULL AUTO_INCREMENT, 
  cena     int(10), 
  PRIMARY KEY (id_dania));

CREATE TABLE IF NOT EXISTS role (
  id_roli int(10) NOT NULL AUTO_INCREMENT, 
  nazwa   varchar(256), 
 PRIMARY KEY (id_roli));
 
CREATE TABLE IF NOT EXISTS stoliki (
  id_stolika     int(10) NOT NULL AUTO_INCREMENT, 
  status_stolika int(2), 
  PRIMARY KEY (id_stolika));

CREATE TABLE IF NOT EXISTS definicje_produktów (
  id_definicja int(10) NOT NULL AUTO_INCREMENT, 
  jednostka    varchar(10), 
  nazwa        varchar(256), 
  PRIMARY KEY (id_definicja));


CREATE TABLE IF NOT EXISTS uzytkownicy (
  id_uzytkownika int(10) NOT NULL AUTO_INCREMENT, 
  login          varchar(256), 
  haslo          varchar(256), 
  id_roli int(10) NOT NULL ,
  FOREIGN KEY (id_roli) REFERENCES role (id_roli), 
  PRIMARY KEY (id_uzytkownika) 
  );

CREATE TABLE IF NOT EXISTS zamowienia (
  id_zamowienia     int(10) NOT NULL AUTO_INCREMENT, 
  status_zamowienia int(3), 
  data_zamowienia   int(10), 
  id_stolika           int(10) NOT NULL, 
  FOREIGN KEY (id_stolika) REFERENCES stoliki (id_stolika), 
  PRIMARY KEY (id_zamowienia) 
  );

CREATE TABLE IF NOT EXISTS produkty (
  id_produkt                         int(10) NOT NULL AUTO_INCREMENT, 
  typ                                int(10), 
  ilosc                              int(10), 
  data_waznosci                      date, 
  id_definicji_produktu int(10) NOT NULL, 
  PRIMARY KEY (id_produkt), 
  FOREIGN KEY (id_definicji_produktu) REFERENCES definicje_produktów (id_definicja));

CREATE TABLE IF NOT EXISTS danie (
  id_dania    int(10) NOT NULL AUTO_INCREMENT, 
  nazwa_dania varchar(256), 
  id_zamowienia  int(10) NOT NULL, 
  id_menu        int(10) NOT NULL, 
  PRIMARY KEY (id_dania), 
  FOREIGN KEY (id_menu) REFERENCES menu (id_dania), 
  FOREIGN KEY (id_zamowienia) REFERENCES zamowienia (id_zamowienia));

CREATE TABLE IF NOT EXISTS skladniki_dania (
  id_skladnika_dania              int(10) NOT NULL AUTO_INCREMENT, 
  zuzywana_ilosc        int(10), 
  id_definicji_produktu   int(10) NOT NULL, 
  id_dania                 int(10) NOT NULL, 
  PRIMARY KEY (id_skladnika_dania),
  FOREIGN KEY (id_dania) REFERENCES danie (id_dania),
  FOREIGN KEY (id_definicji_produktu) REFERENCES definicje_produktów (id_definicja));
  
