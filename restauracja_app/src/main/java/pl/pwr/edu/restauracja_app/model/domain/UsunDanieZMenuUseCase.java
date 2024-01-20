package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

public class UsunDanieZMenuUseCase implements BaseUseCase<Boolean, UsunDanieZMenuUseCase.Params> {
    DatabaseHelper databaseHelper;

    public UsunDanieZMenuUseCase(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    /**
     * @return true if action succeeded and false if error occurred
     */
    public Boolean execute(UsunDanieZMenuUseCase.Params params) {
        try {
            String query = DatabaseHelper.formatProcedureCallQuery(
                    "usun_pozycje_z_menu",
                    List.of(params.nazwaDania)
            );
            databaseHelper.executeQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public record Params(String nazwaDania) {
    }
}