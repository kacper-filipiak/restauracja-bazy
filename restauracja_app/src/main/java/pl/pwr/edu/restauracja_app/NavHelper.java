package pl.pwr.edu.restauracja_app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import pl.pwr.edu.restauracja_app.presenter.AdminPresenter;
import pl.pwr.edu.restauracja_app.presenter.LoginPresenter;

import java.io.IOException;
import java.util.HashMap;

public class NavHelper {

	private HashMap<String, Pane> screenMap = new HashMap<>();
	private Scene main;

	public NavHelper(Scene main) {
		this.main = main;
	}
	public void navigateTo(String name) {
		if (screenMap.containsKey(name)) {
			activate(name);
		} else {
			throw new IllegalArgumentException("Expected registered view name");
		}
	}

	public void addScreen(String name, String filename, Object controller) throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Applikacja.class.getResource(filename));
			fxmlLoader.setController(controller);
			screenMap.put(name, fxmlLoader.load());
		} catch (IOException ignored) {

		}
	}

	private void removeScreen(String name){
		screenMap.remove(name);
	}

	private void activate(String name){
		main.setRoot( screenMap.get(name) );
	}
}