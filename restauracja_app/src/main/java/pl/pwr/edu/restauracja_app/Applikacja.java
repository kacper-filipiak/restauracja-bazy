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

	private NavHelper navHelper;
	private LoginPresenter loginPresenter = new LoginPresenter();
	private AdminPresenter adminPresenter;
	private KelnerPresenter kelnerPresenter;
	private KucharzPresenter kucharzPresenter;
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Applikacja.class.getResource("login-view.fxml"));
		fxmlLoader.setController(loginPresenter);
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		scene.getStylesheets().add("pl/pwr/edu/restauracja_app/style.css");
		stage.setTitle("Restauracja");
		stage.setScene(scene);
		navHelper = new NavHelper(scene);
		adminPresenter = new AdminPresenter(navHelper);
		navHelper.addScreen("login-view", "login-view.fxml", loginPresenter);
		navHelper.addScreen("admin-menu-view", "admin-menu-view.fxml", adminPresenter);
		navHelper.addScreen("dodaj-definicje-skladnika-view", "dodaj-definicje-skladnika-view.fxml", adminPresenter);
		navHelper.navigateTo("admin-menu-view");
		stage.show();
	}


	public static void main(String[] args) {
		launch();
	}
}