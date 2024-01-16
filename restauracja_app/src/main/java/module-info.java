module pl.pwr.edu.restauracja_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.internal.vm.compiler;

    opens pl.pwr.edu.restauracja_app to javafx.fxml;
    exports pl.pwr.edu.restauracja_app;
    exports pl.pwr.edu.restauracja_app.old;
    opens pl.pwr.edu.restauracja_app.old to javafx.fxml;
    exports pl.pwr.edu.restauracja_app.presenter;
}