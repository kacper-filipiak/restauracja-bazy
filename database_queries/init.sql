CREATE DATABASE IF NOT EXISTS restauracja_db;
USE restauracja_db;

CREATE TABLE IF NOT EXISTS  role (
  id_roli int(10) NOT NULL AUTO_INCREMENT, 
  nazwa   varchar(256) UNIQUE, 
  PRIMARY KEY (id_roli));
CREATE TABLE IF NOT EXISTS uzytkownicy (
  id_uzytkownika int(10) NOT NULL AUTO_INCREMENT, 
  login          varchar(256) UNIQUE, 
  haslo          varchar(256), 
  rola           int(10), 
  id_roli int(10) NOT NULL, 
  PRIMARY KEY (id_uzytkownika),
  FOREIGN KEY (id_roli) REFERENCES role (id_roli));
CREATE TABLE IF NOT EXISTS stoliki (
  id_stolika     int(10) NOT NULL AUTO_INCREMENT, 
  status_stolika int(2), 
  PRIMARY KEY (id_stolika));
CREATE TABLE IF NOT EXISTS zamowienia (
  id_zamowienia     int(10) NOT NULL AUTO_INCREMENT, 
  id_stolika        int(10), 
  status_zamowienia int(3) DEFAULT 1, 
  data_zamowienia   DATETIME DEFAULT CURRENT_TIMESTAMP, 
  stoliki           int(10) NOT NULL, 
  PRIMARY KEY (id_zamowienia),
  FOREIGN KEY (stoliki) REFERENCES stoliki (id_stolika));
CREATE TABLE IF NOT EXISTS  definicje_produktow (
  id_definicja int(10) NOT NULL AUTO_INCREMENT, 
  jednostka    varchar(10), 
  nazwa        varchar(256) UNIQUE, 
  PRIMARY KEY (id_definicja));
CREATE TABLE IF NOT EXISTS produkty (
  id_produkt                         int(10) NOT NULL AUTO_INCREMENT, 
  typ                                int(10), 
  ilosc                              float, 
  data_waznosci                      date, 
  id_definicja int(10) NOT NULL, 
  PRIMARY KEY (id_produkt),
  FOREIGN KEY (id_definicja) REFERENCES definicje_produktow (id_definicja));
CREATE TABLE IF NOT EXISTS  danie (
  id_dania    int(10) NOT NULL AUTO_INCREMENT, 
  nazwa_dania varchar(256) UNIQUE, 
  PRIMARY KEY (id_dania));
CREATE TABLE IF NOT EXISTS menu (
  id_dania int(10) NOT NULL, 
  cena     int(10), 
  PRIMARY KEY (id_dania),
  FOREIGN KEY (id_dania) REFERENCES danie (id_dania));

CREATE TABLE IF NOT EXISTS  skladniki_dania (
  id_definicji_produktu int(10) NOT NULL, 
  zuzywana_ilosc        float, 
  danie_id                 int(10) NOT NULL, 
  PRIMARY KEY (id_definicji_produktu, 
  danie_id),
  FOREIGN KEY (danie_id) REFERENCES danie (id_dania) ON DELETE CASCADE,
  FOREIGN KEY (id_definicji_produktu) REFERENCES definicje_produktow (id_definicja));
CREATE TABLE IF NOT EXISTS  zamowienia_danie (
  zamowienia_id int(10) NOT NULL, 
  danie_id           int(10) NOT NULL, 
  PRIMARY KEY (zamowienia_id, 
  danie_id),
  FOREIGN KEY (zamowienia_id) REFERENCES zamowienia (id_zamowienia),
  FOREIGN KEY (danie_id) REFERENCES danie (id_dania));

