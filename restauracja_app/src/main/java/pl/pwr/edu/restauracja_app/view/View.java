package pl.pwr.edu.restauracja_app.view;

import java.util.function.Consumer;

public interface View {

	/**
	 * 
	 * @param onZatwierdz
	 */
	void View(Consumer<String[]> onZatwierdz);

}