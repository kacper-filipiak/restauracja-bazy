package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.DefinicjaSkladnika;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

public class DodajDefinicjeSkladnikaUseCase implements BaseUseCase<Boolean, DodajDefinicjeSkladnikaUseCase.Params> {

    DatabaseHelper databaseHelper;

    public DodajDefinicjeSkladnikaUseCase(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    /**
     * @return true if action succeeded and false if error occurred
     */
    public Boolean execute(Params params) {
        try {
            String query = DatabaseHelper.formatProcedureCallQuery(
                    "insert_definicja_produktu",
                    List.of(params.definicjaSkladnika.jednostka(), params.definicjaSkladnika.nazwa())
            );
            databaseHelper.executeQuery(query, System.out::println);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public record Params(DefinicjaSkladnika definicjaSkladnika) {
    }

}