package pl.pwr.edu.restauracja_app.base;

public interface BaseUseCase<T, P> {
    T execute(P params);
}
