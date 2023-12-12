import pytest

from mysql.connector import connect


def test_connection():
    with connect(host="localhost", user="root", password="root") as connection:
        assert connection.is_connected()


def test_select():
    with connect(host="localhost", user="root", password="root") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

def test_insert():
    with connect(host="localhost", user="root", password="root") as connection:
        result = connection.cursor().execute("SELECT 1;")
        assert result.fetchone()[0] == 1

