package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import epsilon.controllers.Default_controller;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test implements Default_controller {

    public static Stage primaryStage;
    @Override public void fxml() throws IOException { }
    @Override public void initialize() {
        primaryStage = panel.stage;

    }
    
}