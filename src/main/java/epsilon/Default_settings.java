package epsilon;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Default_settings {

    private String css = getClass().getResource("/css/styles.css").toExternalForm();

    public void my_stage(Stage stage, Scene scene) {
        
        // scene.setRoot(new TextArea("some text"));
        // scene.getStylesheets().add(css);

        stage.setScene(scene);      // Установка сцены
        stage.setTitle("Epsilon");  // Установка названия приложения
        stage.setHeight(500);       // Установка высоты окна
        stage.setWidth(500);        // Установка ширины окна
        stage.setOpacity(1);        // Установка прозрачности
        stage.centerOnScreen();     // Располагает окно в центре экрана
        stage.setResizable(false);  // Разрешение на изменение размера
        stage.show();
    }


}