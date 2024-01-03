package epsilon;
import static epsilon.Panel.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test {

    private double xOffset = 0;
    private double yOffset = 0;

    public static Stage primaryStage;
    public void initialize() {
        primaryStage = panel.stage;

        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Создаем внешний HBox
        HBox box_title = new HBox();
        box_title.setAlignment(Pos.CENTER);

        // Label "ДЕКАРТОВАЯ ПЛОСКОСТЬ"
        Label label = new Label("ДЕКАРТОВАЯ ПЛОСКОСТЬ");
        StackPane.setAlignment(label, Pos.CENTER); // Размещаем по центру StackPane

        // Пространственный узел для центрирования текста
        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Создаем внутренний HBox для кнопок
        HBox innerHBox = new HBox();
        innerHBox.setSpacing(10);
        innerHBox.setAlignment(Pos.TOP_RIGHT);

        // Создаем кнопки
        Button closeButton = new Button("C");
        closeButton.setOnAction(event -> primaryStage.close());

        Button hideButton = new Button("S");
        hideButton.setOnAction(event -> primaryStage.setIconified(true));

        Button resizeButton = new Button("R");
        resizeButton.setOnAction(event -> {
            if (primaryStage.isMaximized()) {
                primaryStage.setMaximized(false);
            } else {
                primaryStage.setMaximized(true);
            }
        });

        // Добавляем кнопки во внутренний HBox
        innerHBox.getChildren().addAll(closeButton, hideButton, resizeButton);

        // Добавляем элементы во внешний HBox
        box_title.getChildren().addAll(label, spacer, innerHBox);

        // Обработка событий мыши для перетаскивания окна
        box_title.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        box_title.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        Scene scene = new Scene(box_title, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}