package pl.pwr.edu.restauracja_app.old;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.pwr.edu.restauracja_app.old.domain.GetMenuUseCase;



public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        GetMenuUseCase useCase = new GetMenuUseCase();
        GetMenuUseCase.Params params = new GetMenuUseCase.Params();
        Integer result = useCase.execute(params);
            welcomeText.setText(result == null ? "NULL" : result.toString());
    }

    @FXML
    protected void onDataReceived(String data) {welcomeText.setText(data + welcomeText.getText());}
}