USE restauracja_db;
DELIMITER $$

DROP PROCEDURE IF EXISTS weryfikuj_produkt;
CREATE PROCEDURE weryfikuj_produkt(IN p_ilosc FLOAT, IN p_data_waznosci Date)
BEGIN
	IF p_ilosc < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ilosc produktu musi byc nie ujemna';
	END IF;
	IF p_data_waznosci < GET_DATE() THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Produkt juz przeterminowany';
	END IF;
END; $$

DROP PROCEDURE IF EXISTS weryfikuj_skladnik_dania;
CREATE PROCEDURE weryfikuj_skladnik_dania(IN p_zuzywana_ilosc FLOAT)
BEGIN
	IF p_zuzywana_ilosc < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ilosc produktu musi byc nie ujemna';
	END IF;
END; $$


DROP TRIGGER IF EXISTS weryfikuj_produkt_insert;
CREATE TRIGGER weryfikuj_produkt_insert 
BEFORE INSERT ON produkty FOR EACH ROW 
BEGIN 
	CALL weryfikuj_produkt(NEW.ilosc, NEW.data_waznosci);
END; $$

DROP TRIGGER IF EXISTS weryfikuj_produkt_update;
CREATE TRIGGER weryfikuj_produkt_update 
BEFORE UPDATE ON produkty FOR EACH ROW 
BEGIN 
	CALL weryfikuj_produkt(NEW.ilosc, NEW.data_waznosci);
END; $$

DROP TRIGGER IF EXISTS weryfikuj_skladnik_dania_insert;
CREATE TRIGGER weryfikuj_skladnik_dania_insert 
BEFORE INSERT ON skladniki_dania FOR EACH ROW 
BEGIN 
	CALL weryfikuj_skladnik_dania(NEW.zuzywana_ilosc);
END; $$

DROP TRIGGER IF EXISTS weryfikuj_skladnik_dania_update;
CREATE TRIGGER weryfikuj_skladnik_dania_update 
BEFORE UPDATE ON skladniki_dania FOR EACH ROW 
BEGIN 
	CALL weryfikuj_skladnik_dania(NEW.zuzywana_ilosc);
END; $$




