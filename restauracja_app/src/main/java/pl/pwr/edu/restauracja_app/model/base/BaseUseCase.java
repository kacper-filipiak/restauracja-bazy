package pl.pwr.edu.restauracja_app.model.base;

public interface BaseUseCase<R, P> {

	/**
	 * 
	 * @param params - parameters passed to use case
	 */
	R execute(P params);

}