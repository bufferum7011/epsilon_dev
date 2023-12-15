package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class C_greeting {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button greeting_enter;
    @FXML private Text greeting_title;


    @FXML public void greeting_enter_press(ActionEvent event) {
        greeting_title.setText(greeting_enter.getText());
    }


    public void fxml_greeting() throws IOException { new C_main().get_scene("greeting"); }
    @FXML public void initialize() { }

}