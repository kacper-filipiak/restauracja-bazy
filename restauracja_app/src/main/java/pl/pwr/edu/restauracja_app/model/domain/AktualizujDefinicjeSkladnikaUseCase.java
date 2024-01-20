package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.DefinicjaSkladnika;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

public class AktualizujDefinicjeSkladnikaUseCase implements BaseUseCase<Boolean, AktualizujDefinicjeSkladnikaUseCase.Params> {

    DatabaseHelper databaseHelper;
    public AktualizujDefinicjeSkladnikaUseCase(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }
    public Boolean execute(Params params) {
        try {
            String query = DatabaseHelper.formatProcedureCallQuery(
                    "update_definicje_skladnika",
                    List.of(params.poprzedniaNazwaDefinicji, params.definicjaSkladnika.nazwa(), params.definicjaSkladnika.jednostka())
            );
            databaseHelper.executeQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public record Params(

            DefinicjaSkladnika definicjaSkladnika,
            String poprzedniaNazwaDefinicji) {

    }

}