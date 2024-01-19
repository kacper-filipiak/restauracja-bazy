package pl.pwr.edu.restauracja_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pwr.edu.restauracja_app.model.datamodels.Rola;
import pl.pwr.edu.restauracja_app.model.datamodels.Uzytkownik;
import pl.pwr.edu.restauracja_app.model.domain.AktualizujDefinicjeSkladnikaUseCase;
import pl.pwr.edu.restauracja_app.model.domain.DodajDefinicjeSkladnikaUseCase;
import pl.pwr.edu.restauracja_app.model.domain.PobierzDefinicjeSkladnikaUseCase;
import pl.pwr.edu.restauracja_app.model.domain.UsunDefinicjeSkladnikaUseCase;
import pl.pwr.edu.restauracja_app.model.utils.DatabaseHelper;
import pl.pwr.edu.restauracja_app.model.utils.UserHelper;
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
		UserHelper userHelper = new UserHelper(new Uzytkownik("root", "root", Rola.Admin, true));
		DatabaseHelper databaseHelper = new DatabaseHelper(userHelper);
		adminPresenter = new AdminPresenter(
				navHelper,
				new DodajDefinicjeSkladnikaUseCase(databaseHelper),
				new UsunDefinicjeSkladnikaUseCase(databaseHelper),
				new PobierzDefinicjeSkladnikaUseCase(databaseHelper),
				new AktualizujDefinicjeSkladnikaUseCase(databaseHelper)
		);
		navHelper.addScreen("login-view", "login-view.fxml", loginPresenter);
		navHelper.addScreen("admin-menu-view", "admin-menu-view.fxml", adminPresenter);
		navHelper.addScreen("dodaj-definicje-skladnika-view", "dodaj-definicje-skladnika-view.fxml", adminPresenter);
		navHelper.addScreen("usun-definicje-skladnika-view", "usun-definicje-skladnika-view.fxml", adminPresenter);
		navHelper.addScreen("edytuj-definicja-skladnika-view", "edytuj-definicja-skladnika-view.fxml", adminPresenter);
		navHelper.navigateTo("admin-menu-view");
		stage.show();
	}


	public static void main(String[] args) {
		launch();
	}
}