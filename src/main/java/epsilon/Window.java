package epsilon;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Window {

    private static Scene scene;
    
    public void Window_1(Stage stage) {
        // установка надписи
        Text text = new Text("Hello METANIT.COM!");
        text.setLayoutY(80); // установка положения надписи по оси Y
        text.setLayoutX(80); // установка положения надписи по оси X
        
        Group group = new Group(text);
        
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }

    public void Window_2(Stage stage) {
        Group root = new Group();
        


        scene = new Scene(root, 500, 1000);
        

        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle("Epsilon");
        stage.show();
    }
}
