package epsilon;
import static epsilon.Panel.*;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test {

    private double xOffset = 0;
    private double yOffset = 0;

    public static Stage primaryStage;
    public void initialize() {
        primaryStage = panel.stage;

        Pane root = new Pane();
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Добавление обработчиков событий
        root.setOnMousePressed(win_stretch_2_1());
        root.setOnMouseDragged(win_stretch_2_2());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public EventHandler<MouseEvent> win_stretch_2_1() {
    
        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                // Определение текущего положения курсора окна при зажиме мышки
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        };
    }
    public EventHandler<MouseEvent> win_stretch_2_2() {
    
        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                // Вычисление перемещения мышки для растягивания окна
                double deltaX = event.getSceneX() - xOffset;
                double deltaY = event.getSceneY() - yOffset;

                // Определение стороны, в которую нужно растянуть окно
                Stage stage = (Stage) ((Pane) event.getSource()).getScene().getWindow();
                if (deltaY < 0) {
                    stage.setHeight(stage.getHeight() - deltaY);
                } else {
                    stage.setHeight(stage.getHeight() + deltaY);
                }
                if (deltaX < 0) {
                    stage.setWidth(stage.getWidth() - deltaX);
                } else {
                    stage.setWidth(stage.getWidth() + deltaX);
                }

                // Обновление новых координат курсора
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

                // Установка курсора на "расширение" при растягивании окна
                stage.getScene().setCursor(Cursor.SE_RESIZE); // Пример курсора, можно изменить
            }
        };
    }

}