package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.Skladnik;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class DodajSkladnikUseCase implements BaseUseCase<Boolean, DodajSkladnikUseCase.Params> {

    DatabaseHelper databaseHelper;

    public DodajSkladnikUseCase(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    /**
     * @return true if action succeeded and false if error occurred
     */
    public Boolean execute(DodajSkladnikUseCase.Params params) {
        try {
            String query = DatabaseHelper.formatProcedureCallQuery(
                    "dodaj_produkt",
                    List.of(params.skladnik.definicja().nazwa(), params.skladnik.ilosc(), Date.valueOf(params.skladnik.dataWaznosci()))
            );
            databaseHelper.executeQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public record Params(
            Skladnik skladnik
    ) {
    }

}