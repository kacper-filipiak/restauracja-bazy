package pl.pwr.edu.restauracja_app.old.utils;

import java.sql.*;
import java.util.function.Consumer;

public class DatabaseRepository {
    public static void ExecuteQuery(String query, Consumer<ResultSet> onEach) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/restauracja_db", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                onEach.accept(rs);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
