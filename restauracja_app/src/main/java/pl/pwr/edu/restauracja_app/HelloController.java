package pl.pwr.edu.restauracja_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.pwr.edu.restauracja_app.domain.GetProductTypesUseCase;

import java.util.ArrayList;


public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
    //welcomeText.setText("Welcome to JavaFX Application!");
        GetProductTypesUseCase useCase = new GetProductTypesUseCase();
        GetProductTypesUseCase.Params params = new GetProductTypesUseCase.Params();
        ArrayList<String> result = useCase.execute(params);
        if(result.isEmpty()) {
            welcomeText.setText("Empty response");
        } else {
            welcomeText.setText(result.stream().reduce((x, y) -> x + y).toString());
        }
    }

    @FXML
    protected void onDataReceived(String data) {welcomeText.setText(data + welcomeText.getText());}
}