package epsilon.layouts;
import static epsilon.Panel.*;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public abstract class Default_layouts {

    public void default_settings() {

        panel.scene.getStylesheets().add(panel.css);        // Настройка стилей
        panel.stage.setScene(panel.scene);                  // Настройка сцены
        panel.stage.setTitle(panel.server_project);         // Настройка названия приложения
        panel.stage.getIcons().add(new Image(panel.icon));  // Настройка иконки
        panel.stage.initStyle(StageStyle.DECORATED);        // Настройка декорации
        panel.stage.setOpacity(1);                          // Настройка прозрачности

        panel.stage.setMinHeight(500);                      // Настройка минимальной выстоты
        panel.stage.setMinWidth(500);                       // Настройка минимальной ширины
        panel.stage.setMaxHeight(Double.MAX_VALUE);         // Настройка максимальной выстоты
        panel.stage.setMaxWidth(Double.MAX_VALUE);          // Настройка максимальной ширины
        panel.stage.setHeight(550);                         // Настройка высоты окна
        panel.stage.setWidth(1000);                         // Настройка ширины окна
        panel.stage.setX(100);                              // Настройка расположения окна по горизонтали
        panel.stage.setY(100);                              // Настройка расположения окна по высоте

        panel.stage.setResizable(true);                     // Разрешение на изменение размера
        panel.stage.setFullScreen(false);                   // Разрешение на открытие на полный экран
        // stage.centerOnScreen();                          // Располагает окно в центре экрана
    }

    public abstract void initialize();

}