package pl.pwr.edu.restauracja_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pwr.edu.restauracja_app.model.domain.DodajDanieDoMenuUseCase;
import pl.pwr.edu.restauracja_app.old.App;
import pl.pwr.edu.restauracja_app.old.HelloController;
import pl.pwr.edu.restauracja_app.presenter.*;

import java.io.IOException;

public class Applikacja extends Application {

	private LoginPresenter loginPresenter;
	private AdminPresenter adminPresenter = new AdminPresenter();
	private KelnerPresenter kelnerPresenter;
	private KucharzPresenter kucharzPresenter;
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Applikacja.class.getResource("admin-menu-view.fxml"));
		fxmlLoader.setController(adminPresenter);
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		scene.getStylesheets().add("pl/pwr/edu/restauracja_app/style.css");
		stage.setTitle("Admin menu");
		stage.setScene(scene);
		stage.show();
	}


	public static void main(String[] args) {
		launch();
	}
}