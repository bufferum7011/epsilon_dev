package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Greeting_controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button greeting_enter;
    @FXML private Text greeting_title;

    @FXML
    public void greeting_enter_press() throws IOException {
        Window window = new Window();
        window.index_fxml();
    }

    @FXML
    public void initialize() {
        
    }

    

}
