package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class C_main {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML public void initialize() {

        Group group = new Group();

        // Line
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStroke(Color.ORANGE);
        line.setStrokeWidth(5);
        line.setOpacity(0.5);


        group.getChildren().addAll(line);
        panel.scene = new Scene(group);
        panel.default_settings();
    }


    public void fxml_main() throws IOException { get_scene("greeting"); }


    public void get_scene(String fxml) throws IOException {

        panel.scene = new Scene(new FXMLLoader(epsilon.getClass().getResource(fxml + ".fxml")).load());
        panel.scene.getStylesheets().add(panel.css);
        panel.default_settings();
    }

}