package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Epsilon extends Application {

    @Override public void init() throws Exception {

        print.result("[Application inits]\n");
        super.init();
    }
    @Override public void stop() throws Exception {

        print.result("[Application stops]\n");
        super.stop();
    }
    @Override public void start(Stage stage) throws IOException {

        print.result("[Application starts]\n");
        panel.stage = stage;

        // c_greeting.initialize();
        // c_index.initialize();
        // c_main.initialize();

        c_decart.initialize();
        // c_main.get_scene("sol");
        // c_main.init_2();
    }

}