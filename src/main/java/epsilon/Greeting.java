package epsilon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Greeting {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button greeting_enter;
    @FXML private Text greeting_title;

    @FXML
    void greeting_enter_press() {
        greeting_title.setText("Hello");
    }

    @FXML
    void initialize() {
        
    }

}
