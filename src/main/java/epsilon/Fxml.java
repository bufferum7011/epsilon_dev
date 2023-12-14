package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Fxml {

    public static void setRoot(String fxml) throws IOException {
        panel.scene.setRoot(loadFXML(fxml));
    }
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Epsilon.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public void greeting() throws IOException {

        panel.scene = new Scene(loadFXML("greeting"));
        panel.scene.getStylesheets().add(panel.css);
        panel.default_settings();
    }
    public void index() throws IOException {

        panel.scene = new Scene(loadFXML("index"));
        panel.scene.getStylesheets().add(panel.css);
        panel.default_settings();
    }
    public void sol() throws IOException {

        panel.scene = new Scene(loadFXML("index"));
        panel.scene.getStylesheets().add(panel.css);
        panel.default_settings();
    }

}