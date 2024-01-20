package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.DefinicjaSkladnika;
import pl.pwr.edu.restauracja_app.model.datamodels.Skladnik;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PobierzSkladnikiUseCase implements BaseUseCase<List<Skladnik>, Void> {
    DatabaseHelper databaseHelper;

    public PobierzSkladnikiUseCase(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public List<Skladnik> execute(Void ignored) {
        List<Skladnik> produktyList = new ArrayList<>();
        String query = DatabaseHelper.formatProcedureCallQuery(
                "get_produkt"
        );
        try {
            databaseHelper.executeQuery(query, resultSet -> {
                try {
                    produktyList.add(new Skladnik(resultSet.getFloat("ilosc"), new DefinicjaSkladnika(resultSet.getString("nazwa"), resultSet.getString("jednostka")), resultSet.getDate("data_waznosci").toLocalDate()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return produktyList;
    }
}