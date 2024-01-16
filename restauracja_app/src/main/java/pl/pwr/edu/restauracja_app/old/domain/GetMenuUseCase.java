package pl.pwr.edu.restauracja_app.old.domain;

import pl.pwr.edu.restauracja_app.old.BaseUseCase;
import pl.pwr.edu.restauracja_app.old.utils.DatabaseRepository;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;


public class GetMenuUseCase implements BaseUseCase<Integer, GetMenuUseCase.Params> {

    @Override
    public Integer execute(GetMenuUseCase.Params params) {
        AtomicReference<Integer> result = null;
        try {
            DatabaseRepository.ExecuteQuery("SELECT 1;", a -> {
                try {
                    result.set(a.getInt(1));
                } catch (SQLException e) {
                    System.out.println(e.getLocalizedMessage());
                    throw new RuntimeException(e);
                }
            });
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result.get();
    }

    public static class Params {
    }
}