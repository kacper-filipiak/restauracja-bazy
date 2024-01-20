package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.Danie;
import pl.pwr.edu.restauracja_app.model.datamodels.DefinicjaSkladnika;
import pl.pwr.edu.restauracja_app.model.datamodels.Skladnik;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PobierzDanieZMenuUseCase implements BaseUseCase<List<Danie>, Void> {
	DatabaseHelper databaseHelper;

	public PobierzDanieZMenuUseCase(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	public List<Danie> execute(Void ignored) {
		List<Danie> danieList = new ArrayList<>();
		String query = DatabaseHelper.formatProcedureCallQuery(
				"get_menu"
		);
		try {
			databaseHelper.executeQuery(query, resultSet -> {
				try {
					String _query = DatabaseHelper.formatProcedureCallQuery(
							"get_skladniki_dania", List.of(resultSet.getString("nazwa_dania"))
					);
					Map<DefinicjaSkladnika, Float> skladniki = new HashMap<>();
					databaseHelper.executeQuery(_query, skladnik -> {
						try {
							skladniki.put(new DefinicjaSkladnika(skladnik.getString("nazwa"), null), skladnik.getFloat("zuzywana_ilosc"));
						} catch (SQLException e) {
							throw new RuntimeException(e);
						}
					});
					danieList.add(new Danie(resultSet.getString("nazwa_dania"), resultSet.getFloat("cena"), skladniki));
				} catch (SQLException | ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			});
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return danieList;
	}
}