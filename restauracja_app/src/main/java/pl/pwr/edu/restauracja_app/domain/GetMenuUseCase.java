package pl.pwr.edu.restauracja_app.domain;

import pl.pwr.edu.restauracja_app.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.utils.DatabaseRepository;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

public class GetMenuUseCase implements BaseUseCase<Integer, GetMenuUseCase.Params> {

    @Override
    public Integer execute(GetMenuUseCase.Params params) {
        AtomicReference<Integer> result = null;
        try {
            DatabaseRepository.ExecuteQuery("CALL get_menu();", a -> {
                try {
                    result.set(a.getInt(1));
                } catch (SQLException e) {
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