package epsilon;
import static epsilon.Panel.*;
import javafx.stage.Stage;
//#region error
// import java.io.IOException;
// import epsilon.controllers.Default_controller;
// import javafx.scene.Group;
// import javafx.scene.Scene;
// import javafx.scene.control.Spinner;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.paint.PhongMaterial;
// import javafx.application.Application;
// import javafx.geometry.Bounds;
// import javafx.geometry.Insets;
// import javafx.scene.control.Label;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.Pane;
// import javafx.scene.layout.StackPane;
// import javafx.scene.shape.Box;
// import javafx.scene.shape.Line;
// import javafx.scene.text.Font;
// import javafx.scene.text.Text;
// import javafx.scene.transform.Rotate;
// import javafx.scene.transform.Translate;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.Pane;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Line;
// import javafx.scene.text.Font;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;
// import javafx.stage.StageStyle;
//#endregion

public class Test {

    // private static final int WIDTH = 400;
    // private static final int HEIGHT = 400;
    // private static Pane planePane;

    public static Stage primaryStage;
    public void initialize() {
        primaryStage = panel.stage;

        //#region error
        // primaryStage.initStyle(StageStyle.UNDECORATED);

        // BorderPane root = new BorderPane();

        // // Верхний контейнер - белый текст
        // Text topText = createText("Верхний", Color.WHITE);
        // BorderPane.setAlignment(topText, javafx.geometry.Pos.CENTER);
        // root.setTop(topText);
        // // Создаем пользовательскую декорацию с кнопками
        // // CustomDecoration decoration = new CustomDecoration(primaryStage);
        // // root.setTop(decoration);

        // // Левый контейнер - темно-синий фон и белый текст
        // BorderPane leftPane = new BorderPane();
        // leftPane.setPrefWidth(200);
        // leftPane.setStyle("-fx-background-color: darkblue;");
        // Text leftText = createText("Левый", Color.WHITE);
        // BorderPane.setAlignment(leftText, javafx.geometry.Pos.CENTER);
        // leftPane.setCenter(leftText);
        // root.setLeft(leftPane);

        // // Нижний контейнер - темно-синий фон и белый текст
        // Text bottomText = createText("Нижний", Color.WHITE);
        // BorderPane.setAlignment(bottomText, javafx.geometry.Pos.CENTER);
        // root.setBottom(bottomText);

        
        // planePane = new Pane();

        // // Создаем линии для осей X и Y с белым цветом
        // Line xAxis = createLine(-WIDTH / 2, 0, WIDTH / 2, 0, Color.WHITE);
        // Line yAxis = createLine(0, -HEIGHT / 2, 0, HEIGHT / 2, Color.WHITE);

        // planePane.getChildren().addAll(xAxis, yAxis);

        // BorderPane.setMargin(planePane, new javafx.geometry.Insets(10)); // Добавляем отступы вокруг плоскости
        // root.setCenter(planePane);

        // // Центрирование нуля в плоскости
        // planePane.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
        //     double centerX = newValue.getWidth() / 2;
        //     double centerY = newValue.getHeight() / 2;
        //     // topText.setZeroPosition(centerX, centerY);
        // });

        // // Разметка на линиях
        // createGridLines();

        // // Цвет фона центрального контейнера
        // root.setStyle("-fx-background-color: #333333;");

        // Scene scene = new Scene(root, WIDTH, HEIGHT);

        // primaryStage.setTitle("Декартова плоскость");
        // primaryStage.setScene(scene);
        // primaryStage.show();

        //#endregion
    }

    //#region error
    // private Text createText(String text, Color color) {
    //     Text t = new Text(text);
    //     t.setFill(color);
    //     t.setFont(Font.font("Arial", 16));
    //     return t;
    // }

    // private Line createLine(double startX, double startY, double endX, double endY, Color color) {
    //     Line line = new Line(startX + WIDTH / 2, startY + HEIGHT / 2, endX + WIDTH / 2, endY + HEIGHT / 2);
    //     line.setStroke(color);
    //     return line;
    // }

    // private Text createLabel(String text, double x, double y) {
    //     Text label = new Text(text);
    //     label.setFont(Font.font("Arial", 10));
    //     label.setFill(Color.WHITE);
    //     label.setX(x);
    //     label.setY(y);
    //     return label;
    // }

    // private void createGridLines() {
    //     double centerX = WIDTH / 2;
    //     double centerY = HEIGHT / 2;

    //     // Линии с разметкой по оси X
    //     for(double x = centerX + 50; x <= WIDTH; x += 50) {
    //         Line line = createLine(x, centerY - 5, x, centerY + 5, Color.WHITE);
    //         planePane.getChildren().add(line);

    //         Text text = createLabel(Double.toString(x - centerX), x - 10, centerY + 20);
    //         planePane.getChildren().add(text);
    //     }

    //     for(double x = centerX - 50; x >= 0; x -= 50) {
    //         Line line = createLine(x, centerY - 5, x, centerY + 5, Color.WHITE);
    //         planePane.getChildren().add(line);

    //         Text text = createLabel(Double.toString(x - centerX), x - 10, centerY + 20);
    //         planePane.getChildren().add(text);
    //     }

    //     // Линии с разметкой по оси Y
    //     for(double y = centerY + 50; y <= HEIGHT; y += 50) {
    //         Line line = createLine(centerX - 5, y, centerX + 5, y, Color.WHITE);
    //         planePane.getChildren().add(line);

    //         Text text = createLabel(Double.toString(centerY - y), centerX + 10, y + 5);
    //         planePane.getChildren().add(text);
    //     }

    //     for(double y = centerY - 50; y >= 0; y -= 50) {
    //         Line line = createLine(centerX - 5, y, centerX + 5, y, Color.WHITE);
    //         planePane.getChildren().add(line);

    //         Text text = createLabel(Double.toString(centerY - y), centerX + 10, y + 5);
    //         planePane.getChildren().add(text);
    //     }
    // }
    //#endregion
}