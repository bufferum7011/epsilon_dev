package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class C_decart implements Default_controller {

    @Override public void fxml() throws IOException { }
    @Override public void initialize() {
        
        Line line = new Line(); {
            line.setStartX(200);
            line.setStartY(200);
            line.setEndX(500);
            line.setEndY(200);
            line.setStroke(Color.ORANGE);
            line.setStrokeWidth(5);
            line.setOpacity(1);
            line.setRotate(45);
        }

        Group root = new Group();
        root.getChildren().addAll(line);

        panel.scene = new Scene(root);
        panel.default_settings();
        panel.stage.show();
    }

}