package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.DefinicjaSkladnika;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PobierzDefinicjeSkladnikaUseCase implements BaseUseCase<List<DefinicjaSkladnika>, Void> {
	DatabaseHelper databaseHelper;

	public PobierzDefinicjeSkladnikaUseCase(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	public List<DefinicjaSkladnika> execute(Void ignored) {
		List<DefinicjaSkladnika> definicjaSkladnikaList = new ArrayList<>();
		try {
			String query = DatabaseHelper.formatProcedureCallQuery(
					"get_definicje_skladnika"
			);
			databaseHelper.executeQuery(query, resultSet -> {
				try {
					definicjaSkladnikaList.add(new DefinicjaSkladnika(resultSet.getString("nazwa"), resultSet.getString("jednostka") ));
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			});
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return definicjaSkladnikaList;
	}

}