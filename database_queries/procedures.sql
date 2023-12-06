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


 
  DROP PROCEDURE IF EXISTS dodaj_produkt_to_danie;
  CREATE PROCEDURE dodaj_produkt_to_danie(
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
 
 
  DROP PROCEDURE IF EXISTS dodaj_danie_to_menu;
  CREATE PROCEDURE dodaj_danie_to_menu(
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
  
  DROP PROCEDURE IF EXISTS wyswietl_zamowienia;
  CREATE PROCEDURE wyswietl_zamowienia()
  BEGIN
    SELECT * FROM zamowienia 
    INNER JOIN zamowienia_danie ON zamowienia_danie.zamowienia_id = zamowienia.id_zamowienia 
    INNER JOIN danie ON danie.id_dania = zamowienia_danie.danie_id 
    WHERE zamowienia.status_zamowienia = 1;
  END; $$
   
  DROP PROCEDURE IF EXISTS ustaw_status_zamowienia;
  CREATE PROCEDURE ustaw_status_zamowienia(IN p_id_zamowienia INT(10), IN p_status INT(3))
  BEGIN
    UPDATE zamowienia SET status_zamowienia = p_status WHERE id_zmowienia = p_id_zamowienia;
  END; $$
   

  DROP PROCEDURE IF EXISTS ustaw_status_do_wydania;
  CREATE PROCEDURE ustaw_status_do_wydania(IN p_id_zamowienia INT(10))
  BEGIN
   CALL ustaw_status_zamowienia(p_id_zamowienia, 1); 
  END; $$
 
  DROP PROCEDURE IF EXISTS ustaw_status_wydane;
  CREATE PROCEDURE ustaw_status_wydane(IN p_id_zamowienia INT(10))
  BEGIN
   CALL ustaw_status_zamowienia(p_id_zamowienia, 2); 
  END; $$
  
  DROP PROCEDURE IF EXISTS utworz_zamowienie;
  CREATE PROCEDURE utworz_zamowienie(IN p_id_stolika INT(10))
  BEGIN
    INSERT INTO zamowienia (id_stolika) VALUES (p_id_stolika);
    SELECT LAST_INSERT_ID();
  END; $$

  DROP PROCEDURE IF EXISTS dodaj_danie_do_zamowienia;
  CREATE PROCEDURE dodaj_danie_do_zamowienia(IN p_id_zamowienia INT(10), IN nazwa_dania VARCHAR(256))
  BEGIN
  DECLARE v_id_dania int(10);
 
  DECLARE input VARCHAR(256);
  SET input = `p_nazwa_dania`;
  CALL get_id_dania_by_nazwa(input, v_id_dania);
  INSERT INTO zamowienia_danie (id_zamowienia, id_dania) VALUES (p_id_zamowienia, v_id_dania);
  END; $$

  DROP PROCEDURE IF EXISTS sprawdz_dostepnosc_skladnika;
  CREATE PROCEDURE sprawdz_dostepnosc_skladnika(IN p_nazwa_skladnika VARCHAR(256), IN p_ilosc FLOAT)
  BEGIN
    SELECT IF(SUM(ilosc)>p_ilosc,TRUE,FALSE) AS dostepny FROM produkty INNER JOIN definicje_produktow ON produkty.id_definicja = definicje_produktow.id_definicja WHERE nazwa LIKE p_nazwa_skladnika GROUP BY definicje_produktow.id_definicja;
  END; $$

 
  DROP PROCEDURE IF EXISTS wygeneruj_rachunek;
  CREATE PROCEDURE wygeneruj_rachunek(IN p_id_zamowienia INT(10))
  BEGIN
    SELECT SUM(cena) FROM menu INNER JOIN zamowienia_danie ON danie_id = id_dania WHERE zamowienia_id = p_id_zamowienia;
  END; $$
 
  DROP PROCEDURE IF EXISTS ustaw_status_stolika;
  CREATE PROCEDURE ustaw_status_stolika(IN p_id_stolika INT(10), IN p_status INT(2))
  BEGIN
    UPDATE stoliki SET status_stolika = p_status WHERE id_stolika = p_id_stolika;
  END; $$
 
  DROP PROCEDURE IF EXISTS zwolnij_stolik;
  CREATE PROCEDURE zwolnij_stolik(IN p_id_stolika INT(10))
  BEGIN
    CALL ustaw_status_stolika(p_id_stolika);
  END; $$
 
  DROP PROCEDURE IF EXISTS zajmij_stolik;
  CREATE PROCEDURE zajmij_stolik(IN p_id_stolika INT(10))
  BEGIN
    CALL ustaw_status_stolika(p_id_stolika);
  END; $$

  DROP PROCEDURE IF EXISTS dodaj_produkt;
  CREATE PROCEDURE dodaj_produkt(IN p_nazwa VARCHAR(256), IN p_ilosc FLOAT, IN p_data_waznosci DATE)
  BEGIN
  DECLARE v_id_definicji_skladnika int(10);
  DECLARE input VARCHAR(256);
  SET input = p_nazwa_skladnika;
  CALL get_id_definicji_skladnika_by_nazwa(input, v_id_definicji_skladnika); 
  INSERT INTO produkty (ilosc, id_definicja, data_waznosci) VALUES (p_ilosc, v_id_definicji_skladnika, p_data_waznosci);
  END; $$

  DROP PROCEDURE IF EXISTS get_skladniki_dania;
  CREATE PROCEDURE get_skladniki_dania(IN p_nazwa VARCHAR(256))
  BEGIN
  DECLARE v_id_dania int(10);
  DECLARE input VARCHAR(256);
  SET input = p_nazwa;
  CALL get_id_dania_by_nazwa(input, v_id_dania); 
  SELECT definicje_produktow.nazwa, zuzywana_ilosc FROM definicje_produktow 
  INNER JOIN skladniki_dania ON id_definicja = id_definicji_produktu 
  INNER JOIN danie ON danie.id_dania = v_id_dania;
  END; $$




  -- Przyznanie dostepu do procedury uzytkownikowi
  DROP PROCEDURE IF EXISTS grant_access_to_procedure;
  CREATE PROCEDURE grant_access_to_procedure(IN p_login VARCHAR(256), IN p_host VARCHAR(14), IN p_procedura VARCHAR(256))
  BEGIN
    SET @`sql` := CONCAT('GRANT EXECUTE ON PROCEDURE restauracja_db.', p_procedura,' TO ', p_login, p_host); 
    PREPARE `stmt` FROM @`sql`;
    EXECUTE `stmt`;
    DEALLOCATE PREPARE `stmt`;
END; $$
 
-- Dodanie urzytkownika o roli kelner
  DROP PROCEDURE IF EXISTS dodaj_kelner;
  CREATE PROCEDURE dodaj_kelner(
     IN p_login varchar(256), 
     IN p_haslo varchar(256)
 )
 BEGIN
    -- Wybor adresu hosta (akceptuj wszystkie)
    DECLARE `_HOST` CHAR(14) DEFAULT '@\'%\'';
    SET `p_login` := CONCAT('\'', REPLACE(TRIM(`p_login`), CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\''),
    `p_haslo` := CONCAT('\'', REPLACE(`p_haslo`, CHAR(39), CONCAT(CHAR(92), CHAR(39))), '\'');
    -- Dodanie urzytkownika do bazy danych
    SET @`sql` := CONCAT('CREATE USER ', `p_login`, `_HOST`, ' IDENTIFIED BY ', `p_haslo`);
    PREPARE `stmt` FROM @`sql`;
    EXECUTE `stmt`;
    -- Nadanie dostepu do procedur
    CALL grant_access_to_procedure(p_login, _HOST, 'get_menu');
    CALL grant_access_to_procedure(p_login, _HOST, 'dodaj_danie_do_zamowienia');
    CALL grant_access_to_procedure(p_login, _HOST, 'ustaw_status_wydane');
    CALL grant_access_to_procedure(p_login, _HOST, 'utworz_zamowienie');
    CALL grant_access_to_procedure(p_login, _HOST, 'wygeneruj_rachunek');
    CALL grant_access_to_procedure(p_login, _HOST, 'zajmij_stolik');
    CALL grant_access_to_procedure(p_login, _HOST, 'zwolnij_stolik');
    CALL grant_access_to_procedure(p_login, _HOST, 'sprawdz_dostepnosc_skladnika');
    CALL grant_access_to_procedure(p_login, _HOST, 'get_skladniki_dania');
    -- Zaaplikowanie dostepow
  FLUSH PRIVILEGES;
  END; $$
 
  -- Dodanie urzytkownika o roli kucharz  
  DROP PROCEDURE IF EXISTS dodaj_kucharz;
  CREATE PROCEDURE dodaj_kelner(
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
    CALL grant_access_to_procedure(p_login, _HOST, 'get_skladniki_dania');
    CALL grant_access_to_procedure(p_login, _HOST, 'ustaw_status_do_wydania');
    CALL grant_access_to_procedure(p_login, _HOST, 'wyswietl_zamowienia');
  FLUSH PRIVILEGES;
  END; $$
   
-- DELIMITER ;

-- CALL insert_definicja_produktu("kg", "sól");
-- CALL insert_danie("chleb i sól");
-- CALL dodaj_produkt_to_danie('chleb i sól', 'sól', 0.01);
-- CALL dodaj_danie_to_menu("chleb i sól", 30.5);
CALL get_menu();
-- CALL getAll();
