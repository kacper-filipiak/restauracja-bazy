package pl.pwr.edu.restauracja_app.model.utils;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class DatabaseHelper {
    UserHelper userHelper;

    /**
     * @param query
     * @param onEach
     */
    public void executeQuery(String query, Consumer<ResultSet> onEach) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://" + userHelper.getUzytkownik().nazwa() + ":" + userHelper.getUzytkownik().haslo() + "@[::1]:3306/restauracja_db?protocol=tcp&allowPublicKeyRetrieval=true&useSSL=false");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                onEach.accept(rs);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public DatabaseHelper(UserHelper _userHelper) {
        userHelper = _userHelper;
    }

    static public String formatProcedureCallQuery(String procedureName) {
        return formatProcedureCallQuery(procedureName, Collections.emptyList());
    }
    static public String formatProcedureCallQuery(String procedureName, List<Object> parameters) {
        if (!parameters.isEmpty()) {
            return "CALL " + procedureName + "('" + parameters.stream().reduce((acc, elem) -> acc + "', '" + elem).get() + "');";
        } else {
            return "CALL " + procedureName + "();";
        }
    }
}