package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

public class UsunDefinicjeSkladnikaUseCase implements BaseUseCase<Boolean, UsunDefinicjeSkladnikaUseCase.Params> {
    DatabaseHelper databaseHelper;

    public UsunDefinicjeSkladnikaUseCase(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    /**
     * @return true if action succeeded and false if error occurred
     */
    public Boolean execute(UsunDefinicjeSkladnikaUseCase.Params params) {
        try {
            String query = DatabaseHelper.formatProcedureCallQuery(
                    "usun_definicje_skladnika",
                    List.of(params.nazwaDefinicjiSkladnika)
            );
            databaseHelper.executeQuery(query, System.out::println);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public record Params(String nazwaDefinicjiSkladnika) {
    }

}