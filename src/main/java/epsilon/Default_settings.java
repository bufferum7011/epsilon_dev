package epsilon;
import static epsilon.Panel.*;

import javafx.stage.StageStyle;

public class Default_settings {

    public Default_settings() {
        
        panel.scene.getStylesheets().setAll(panel.css);

        panel.stage.setScene(panel.scene);  // Установка сцены
        panel.stage.setTitle("Epsilon");    // Установка названия приложения
        panel.stage.setHeight(500);         // Установка высоты окна
        panel.stage.setWidth(500);          // Установка ширины окна
        panel.stage.setOpacity(1);          // Установка прозрачности
        panel.stage.initStyle(StageStyle.DECORATED);
        panel.stage.centerOnScreen();       // Располагает окно в центре экрана
        panel.stage.setResizable(true);     // Разрешение на изменение размера
        panel.stage.show();
    }


}