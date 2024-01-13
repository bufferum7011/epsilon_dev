package epsilon.layouts;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Default_layouts {

    private VBox root;

    @Override public void set_scene(Scene scene) { super.set_scene(scene); }

    @Override public void execute_before(Stage stage) {

        root = new VBox();
        set_scene(new Scene(root));
        super.execute_before(stage);
    }
    @Override public void initialize(Stage primaryStage) {

    }
    @Override public void execute_after(Stage stage) {
        super.execute_after(stage);
    }
}