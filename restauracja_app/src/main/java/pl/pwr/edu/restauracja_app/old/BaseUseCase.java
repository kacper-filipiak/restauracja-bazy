package pl.pwr.edu.restauracja_app.old;

public interface BaseUseCase<T, P> {
    T execute(P params);
}
