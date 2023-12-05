package epsilon;
import java.io.IOException;
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

        Window window = new Window();
        window.test_1(stage);
    }

}