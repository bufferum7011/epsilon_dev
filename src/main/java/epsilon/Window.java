package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    public void index_java(Stage stage) {

        Button left = new Button("Left");
        Button center = new Button("Center");
        Button right = new Button("Right");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(left, center, right);

        Button btn1 = new Button("Файлы");
        Button btn2 = new Button("Календарь");
        Button btn3 = new Button("Задачи");
        Button btn4 = new Button("База данных");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(btn1);
        vBox.getChildren().addAll(btn2);
        vBox.getChildren().addAll(btn3);
        vBox.getChildren().addAll(btn4);

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(hbox);
        borderPane.getChildren().addAll(vBox);
        BorderPane.setAlignment(hbox, Pos.TOP_CENTER);
        BorderPane.setAlignment(vBox, Pos.BASELINE_LEFT);

        AnchorPane anchorPane = new AnchorPane();
        // anchorPane.setStyle(css);
        anchorPane.getStyleClass().add("main");
        anchorPane.getChildren().addAll(hbox);
        anchorPane.getChildren().addAll(vBox);

        Scene scene = new Scene(anchorPane);
        new Default_settings();
    }
    public void index_fxml(Stage stage) throws IOException {

        panel.scene = new Scene(loadFXML("index"));
        panel.scene.getStylesheets().add(panel.css);
        new Default_settings();
    }
    public void greeting(Stage stage) throws IOException {

        panel.scene = new Scene(loadFXML("greeting"));
        panel.scene.getStylesheets().add(panel.css);
        new Default_settings();
    }


}