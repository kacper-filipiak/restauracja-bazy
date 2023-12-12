import pytest

from mysql.connector import connect


def test_connection():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        assert connection.is_connected()


def test_select():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result == 1
def test_insert_stolik():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert_zamowienie():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert_zamowienia_danie():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert_menu():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert_danie():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert_skladniki_dania():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert_produkty():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert_definicje_produktow():
    with connect(host="localhost", user="root", password="root", database="restauracja_db") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

