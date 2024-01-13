package epsilon.layouts;
import static epsilon.Panel.panel;
import static epsilon.Panel.print;

import java.util.Iterator;

import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class Default_layouts {

    // Variables
    private Scene scene;

    public void set_scene(Scene scene)  { this.scene = scene; }

    public static void start(Stage stage, Default_layouts layout) {
        layout.execute_before(stage);
        layout.initialize(stage);
        layout.execute_after(stage);
    }
    public void execute_before(Stage stage) {

        stage.initStyle(StageStyle.UNDECORATED);    // Настройка декорации
        stage.setOpacity(1);                        // Настройка прозрачности

        stage.setMinHeight(400);                    // Настройка минимальной выстоты
        stage.setMinWidth(700);                     // Настройка минимальной ширины
        stage.setMaxHeight(Screen.getPrimary().getBounds().getHeight()); // Настройка максимальной выстоты
        stage.setMaxWidth(Screen.getPrimary().getBounds().getWidth()); // Настройка максимальной ширины
        stage.setHeight(550);                       // Настройка высоты окна
        stage.setWidth(1000);                       // Настройка ширины окна
        stage.setX(100);                            // Настройка расположения окна по горизонтали
        stage.setY(100);                            // Настройка расположения окна по высоте

        stage.setResizable(true);                   // Разрешение на изменение размера
        stage.setFullScreen(false);                 // Разрешение на открытие на полный экран

        scene.getStylesheets().add(panel.css);      // Настройка стилей
        stage.setScene(scene);                      // Настройка сцены
    }
    public abstract void initialize(Stage stage);
    public void execute_after(Stage stage) { stage.show(); }

}