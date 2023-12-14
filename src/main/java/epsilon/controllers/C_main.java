package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import epsilon.Epsilon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class C_main {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML public void initialize() {}


    public void fxml_main() throws IOException { get_scene("greeting"); }


    public void get_scene(String fxml) throws IOException {

        panel.scene = new Scene(new FXMLLoader(Epsilon.class.getResource(fxml + ".fxml")).load());
        panel.scene.getStylesheets().add(panel.css);
        panel.default_settings();
    }

}