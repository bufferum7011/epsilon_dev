package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;

import epsilon.controllers.Control_greeting;
import epsilon.controllers.Index;
import javafx.application.Application;
import javafx.stage.Stage;

public class Epsilon extends Application {

    @Override public void init() throws Exception {

        System.out.println("Application inits");
        super.init();
    }
    @Override public void stop() throws Exception {

        System.out.println("Application stops");
        super.stop();
    }
    @Override public void start(Stage stage) throws IOException {

        System.out.println("Application starts");
        panel.stage = stage;

        // Window window = new Window();
        // Fxml fxml = new Fxml();

        // window.index();

        // fxml.index();
        // fxml.sol();
        // fxml.greeting();
        new Index().initialize();
    }

}