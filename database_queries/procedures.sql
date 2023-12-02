USE restauracja_db;
DELIMITER $$
 DROP PROCEDURE IF EXISTS get_menu;
 CREATE PROCEDURE get_menu()
 BEGIN
 SELECT cena, nazwa_dania FROM menu INNER JOIN danie ON danie.id_dania = menu.id_dania;
 END $$

DROP PROCEDURE IF EXISTS insert_definicja_produktu;
CREATE PROCEDURE insert_definicja_produktu(IN p_jednostka varchar(10), IN p_nazwa varchar(256))
BEGIN
INSERT INTO definicje_produktow (jednostka, nazwa) VALUES (p_jednostka, p_nazwa);

END; $$

 DROP PROCEDURE IF EXISTS insert_danie;
 CREATE PROCEDURE insert_danie(IN p_nazwa varchar(256))
 BEGIN
 INSERT INTO danie (nazwa_dania) VALUES (p_nazwa);

 END; $$

 DROP PROCEDURE IF EXISTS get_id_dania_by_nazwa;
 CREATE PROCEDURE get_id_dania_by_nazwa(IN p_nazwa varchar(256), OUT p_id_dania INT(10))
 BEGIN
 SELECT id_dania INTO p_id_dania FROM danie WHERE nazwa_dania LIKE p_nazwa;

 END; $$

 DROP PROCEDURE IF EXISTS get_id_definicji_skladnika_by_nazwa;
 CREATE PROCEDURE get_id_definicji_skladnika_by_nazwa(IN p_nazwa varchar(256), OUT p_id_definicji INT(10))
 BEGIN
 SELECT id_definicja INTO p_id_definicji FROM definicje_produktow WHERE nazwa LIKE p_nazwa;
 END; $$


 
  DROP PROCEDURE IF EXISTS add_produkt_to_danie;
  CREATE PROCEDURE add_produkt_to_danie(
     IN p_nazwa_dania varchar(256), 
     IN p_nazwa_skladnika varchar(256), 
     IN p_ilosc float
 )
 BEGIN
 DECLARE v_id_dania int(10);
 DECLARE v_id_definicji_skladnika int(10);
 
  DECLARE input VARCHAR(256);
  SET input = `p_nazwa_dania`;
  CALL get_id_dania_by_nazwa(input, v_id_dania);
  SET input = p_nazwa_skladnika;
  CALL get_id_definicji_skladnika_by_nazwa(input, v_id_definicji_skladnika); 
  INSERT INTO skladniki_dania (zuzywana_ilosc, id_definicji_produktu, danie_id) VALUES (p_ilosc, v_id_definicji_skladnika, v_id_dania);
 
  END; $$
 
 
  DROP PROCEDURE IF EXISTS add_danie_to_menu;
  CREATE PROCEDURE add_danie_to_menu(
     IN nazwa_dania varchar(256), 
     IN p_cena float
 )
 BEGIN
 DECLARE v_id_dania int(10);
 
  DECLARE input VARCHAR(256);
  SET input := nazwa_dania;
  CALL get_id_dania_by_nazwa(input, v_id_dania);
  INSERT INTO menu (cena, id_dania) VALUES (p_cena, v_id_dania);
 
  END; $$
  
  DROP PROCEDURE IF EXISTS add_kelner;
  CREATE PROCEDURE add_kelner(
     IN p_login varchar(256), 
     IN p_haslo varchar(256)
 )
 BEGIN
    DECLARE `_HOST` CHAR(14) DEFAULT '@\'%\'';
    SET `p_login` := CONCAT('\'', REPLACE(TRIM(`p_login`), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\''),
    `p_haslo` := CONCAT('\'', REPLACE(`p_haslo`, CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    SET @`sql` := CONCAT('CREATE USER ', `p_login`, `_HOST`, ' IDENTIFIED BY ', `p_haslo`);
    PREPARE `stmt` FROM @`sql`;
    EXECUTE `stmt`;
    SET @`sql` := CONCAT('GRANT EXECUTE ON PROCEDURE restauracja_db.get_menu TO ', p_login, _HOST); 
    PREPARE `stmt` FROM @`sql`;
    EXECUTE `stmt`;
    DEALLOCATE PREPARE `stmt`;
  FLUSH PRIVILEGES;
  END; $$
 
-- DELIMITER ;

-- CALL insert_definicja_produktu("kg", "sól");
-- CALL insert_danie("chleb i sól");
-- CALL add_produkt_to_danie('chleb i sól', 'sól', 0.01);
-- CALL add_danie_to_menu("chleb i sól", 30.5);
CALL get_menu();
-- CALL getAll();
