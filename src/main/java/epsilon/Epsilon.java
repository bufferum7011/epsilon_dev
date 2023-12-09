package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Epsilon extends Application {

    public void start() { launch(); }
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
        // window.index_fxml();

        Index_controller index_controller = new Index_controller();
        index_controller.index_java();
    }

}