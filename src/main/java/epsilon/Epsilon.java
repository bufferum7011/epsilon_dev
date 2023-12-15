package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import epsilon.controllers.C_main;
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

        // new C_greeting().initialize();
        // new C_index().initialize();
        // new C_main().get_scene("sol");
        // new C_main().initialize();
        new C_main().init_2();
    }

}