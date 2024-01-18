package pl.pwr.edu.restauracja_app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;

public class NavHelper {

	private final HashMap<String, Pane> screenMap = new HashMap<>();
	private final Scene main;

	public Node getFromCurrentSceneById(String id) {
		return main.lookup("#" + id);
	}

	public NavHelper(Scene main) {
		this.main = main;
	}
	public void navigateTo(String name) {
		if (screenMap.containsKey(name)) {
			activate(name);
		} else {
			throw new IllegalArgumentException("Expected registered view name, got: " + name);
		}
	}

	public void addScreen(String name, String filename, Object controller) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Applikacja.class.getResource(filename));
			fxmlLoader.setController(controller);
			screenMap.put(name, fxmlLoader.load());
		} catch (IOException e) {
			System.err.println("Can't read view file: " + filename + "\n" + e.getMessage());
		}
	}

	private void activate(String name){
		main.setRoot( screenMap.get(name) );
	}

}