package epsilon;
import static epsilon.Panel.*;
import javafx.stage.StageStyle;

public class Default_settings {

    public Default_settings() {
        
        panel.scene.getStylesheets().add(panel.css);

        panel.stage.setScene(panel.scene);  // Настройка сцены
        panel.stage.setTitle("Epsilon");    // Настройка названия приложения
        // panel.stage.getIcons().add(panel.icon); // Настройка иконки
        panel.stage.setHeight(500);         // Настройка высоты окна
        panel.stage.setWidth(500);          // Настройка ширины окна
        panel.stage.setOpacity(1);          // Настройка прозрачности
        panel.stage.initStyle(StageStyle.DECORATED); // Настройка рамки окна
        panel.stage.centerOnScreen();       // Располагает окно в центре экрана
        panel.stage.setResizable(true);     // Разрешение на изменение размера
        panel.stage.show();
    }


}