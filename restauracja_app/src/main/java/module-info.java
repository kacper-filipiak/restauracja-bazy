module pl.pwr.edu.restauracja_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens pl.pwr.edu.restauracja_app to javafx.fxml;
    exports pl.pwr.edu.restauracja_app;
}