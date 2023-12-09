package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window {

    public static void setRoot(String fxml) throws IOException {
        panel.scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Epsilon.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void test_1(Stage stage) {

        Circle circle = new Circle(50);
        circle.setFill(Color.rgb(122, 122, 122));
        circle.setStroke(Color.AQUA);
        circle.setStrokeWidth(10);

        Text text = new Text("Hello world!");
        text.setStyle("-fx-fill: green;");

        VBox pane = new VBox();
        // pane.getChildren().addAll(text);
        // pane.getChildren().addAll(circle);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(pane);
        panel.scene.setRoot(borderPane);

        // pane = new Pane();
        // pane.getChildren().addAll(circle);
        // pane.getChildren().addAll(text);
        new Default_settings();
    }
    public void index_fxml() throws IOException {

        panel.scene = new Scene(loadFXML("sol"));
        panel.scene.getStylesheets().add(panel.css);
        new Default_settings();
    }
    public void greeting() throws IOException {

        panel.scene = new Scene(loadFXML("greeting"));
        panel.scene.getStylesheets().add(panel.css);
        new Default_settings();
    }


}