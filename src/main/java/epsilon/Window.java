package epsilon;
import static epsilon.Panel.*;
import javafx.geometry.Pos;
import javafx.scene.Group;
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
import javafx.stage.StageStyle;

public class Window {

    private static Scene scene;

    public void test_1(Stage stage) {

        // установка надписи
        Text text = new Text("Hello METANIT.COM!");

        // Group group = new Group(text);
        HBox hBox = new HBox(text);
        Scene scene = new Scene(hBox);

        // new Default_settings(stage, scene);
        stage.setScene(scene);      // Установка сцены
        stage.setTitle("Epsilon");  // Установка названия приложения
        stage.setHeight(500);       // Установка высоты окна
        stage.setWidth(500);        // Установка ширины окна
        stage.show();
    }
    public void test_2(Stage stage) {

        Group root = new Group();

        scene = new Scene(root, 500, 1000);

        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle("Epsilon");
        stage.show();
    }
    public void test_3(Stage stage) {

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
        scene.setRoot(borderPane);

        // pane = new Pane();
        // pane.getChildren().addAll(circle);
        // pane.getChildren().addAll(text);
        new Default_settings(stage, scene);
    }
    public void index(Stage stage) {

        Text text = new Text("Обычный текст");
        Button btn = new Button("Кнопка");

        HBox hbox = new HBox();
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        // hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
        
        VBox vBox = new VBox();

        // Group group = new Group(vBox, hBox);
        
        // AnchorPane anchor_pane = new AnchorPane(group);
        // anchor_pane.setStyle(panel.css);
        // anchor_pane.getChildren().add(text);
        // anchor_pane.

        // Button left = new Button("Left");
        // Button center = new Button("Center");
        // Button right = new Button("Right");
        // BorderPane.setAlignment(left, Pos.CENTER);
        // BorderPane.setAlignment(center, Pos.CENTER);
        // BorderPane.setAlignment(right, Pos.TOP_RIGHT);

        
         
        // stage.setScene(new Scene(root, 300, 150));
        stage.setTitle("BorderPane in JavaFX");
        stage.show();
    }


}