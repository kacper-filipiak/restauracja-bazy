package pl.pwr.edu.restauracja_app.model.utils;

import java.sql.*;
import java.util.function.Consumer;

public class DatabaseHelper {
	UserHelper userHelper;

	/**
	 * 
	 * @param query
	 * @param onEach
	 */
	public void executeQuery(String query, Consumer<ResultSet> onEach) throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/restauracja_db", userHelper.getUzytkownik().nazwa(), userHelper.getUzytkownik().haslo());
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
	public DatabaseHelper(UserHelper _userHelper) {
		userHelper = _userHelper;
	}

}