package epsilon;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {

        System.out.println("Launching Application");
        launch();
    }

    @Override
    public void init() throws Exception {

        System.out.println("Application inits");
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException {

        System.out.println("Application starts");

        Window window = new Window();
        window.Window_1(stage);
        // window.Window_2(stage);
    }

    @Override
    public void stop() throws Exception {

        System.out.println("Application stops");
        super.stop();
    }

}