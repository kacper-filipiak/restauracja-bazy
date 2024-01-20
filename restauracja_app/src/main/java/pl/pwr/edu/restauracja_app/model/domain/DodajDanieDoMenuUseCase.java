package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.Danie;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class DodajDanieDoMenuUseCase implements BaseUseCase<Boolean, DodajDanieDoMenuUseCase.Params> {

        DatabaseHelper databaseHelper;

    public DodajDanieDoMenuUseCase(DatabaseHelper databaseHelper) {
            this.databaseHelper = databaseHelper;
        }

        /**
         * @return true if action succeeded and false if error occurred
         */
        public Boolean execute(DodajDanieDoMenuUseCase.Params params) {
            try {
                String query = DatabaseHelper.formatProcedureCallQuery(
                        "dodaj_danie_to_menu",
                        List.of(params.danie().nazwa_dania(), params.danie().cena())
                );
                databaseHelper.executeQuery(query);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
                return false;
            }
            System.out.println("Stage 2");
            params.danie.skladniki().forEach( (definicjaSkladnika, ilosc) -> {
                System.out.println("Adding produkt to danie: " + definicjaSkladnika);
                try {
                    String query = DatabaseHelper.formatProcedureCallQuery(
                            "dodaj_produkt_to_danie",
                            List.of(params.danie().nazwa_dania(), definicjaSkladnika.nazwa(), ilosc)
                    );
                    databaseHelper.executeQuery(query);
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            });
            return true;
        }

    public record Params(Danie danie) {
    }

}