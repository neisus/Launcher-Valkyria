package fr.arinonia.valkyria;

import javafx.application.Application;
import javafx.stage.Stage;

public class FxApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new ValkyriaLauncher().init(stage);
    }
}
