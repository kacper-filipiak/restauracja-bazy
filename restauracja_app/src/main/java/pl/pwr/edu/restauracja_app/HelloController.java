package pl.pwr.edu.restauracja_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.pwr.edu.restauracja_app.domain.GetMenuUseCase;



public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
    //welcomeText.setText("Welcome to JavaFX Application!");
        GetMenuUseCase useCase = new GetMenuUseCase();
        GetMenuUseCase.Params params = new GetMenuUseCase.Params();
        Integer result = useCase.execute(params);
            welcomeText.setText(result.toString());
    }

    @FXML
    protected void onDataReceived(String data) {welcomeText.setText(data + welcomeText.getText());}
}