package pl.pwr.edu.restauracja_app.old.domain;

import pl.pwr.edu.restauracja_app.old.BaseUseCase;
import pl.pwr.edu.restauracja_app.old.utils.DatabaseRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class GetProductTypesUseCase implements BaseUseCase<ArrayList<String>, GetProductTypesUseCase.Params> {
    @Override
    public ArrayList<String> execute(Params params) {
        ArrayList<String> result = new ArrayList<>();
        try {
            DatabaseRepository.ExecuteQuery("SELECT * FROM typ_produktu", a -> {
                try {
                    result.add(a.getInt(1) + a.getString(2));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static class Params {
    }
}
