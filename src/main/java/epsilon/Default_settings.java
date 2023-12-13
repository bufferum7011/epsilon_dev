package epsilon;
import static epsilon.Panel.*;
import javafx.stage.StageStyle;

public class Default_settings {

    public Default_settings() {

        panel.scene.getStylesheets().add(panel.css);

        panel.stage.setScene(panel.scene);          // Настройка сцены
        panel.stage.setTitle(panel.server_project); // Настройка названия приложения
        panel.stage.initStyle(StageStyle.DECORATED);// Настройка рамки окна
        panel.stage.setMinHeight(550);              // Настройка минимальной выстоты
        panel.stage.setMinWidth(1000);              // Настройка минимальной ширины
        panel.stage.setHeight(550);                 // Настройка высоты окна
        panel.stage.setWidth(1000);                 // Настройка ширины окна
        panel.stage.setX(100);                      // Настройка расположения окна по горизонтали
        panel.stage.setY(100);                      // Настройка расположения окна по высоте
        panel.stage.centerOnScreen();               // Располагает окно в центре экрана
        panel.stage.setResizable(true);             // Разрешение на изменение размера

        // panel.stage.setFullScreen(false);           // Разрешение на открытие на полный экран
        // panel.stage.setOpacity(1);                  // Настройка прозрачности
        // panel.stage.getIcons().add(panel.icon);     // Настройка иконки
        panel.stage.show();
    }

}