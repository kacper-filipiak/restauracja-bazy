package pl.pwr.edu.restauracja_app.model.base;

import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;

public interface BaseUseCase<R, P> {

	DatabaseHelper databaseHelper = new DatabaseHelper();

	/**
	 * 
	 * @param params - parameters passed to use case
	 */
	R execute(P params);

}