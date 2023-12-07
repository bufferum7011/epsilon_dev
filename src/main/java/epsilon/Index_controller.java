package epsilon;
import static epsilon.Panel.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Index_controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML public void initialize() { }

    public void index_java() {

        // ============================

        Label label = new Label(panel.server_project);

        Button btn_left = new Button("Left");
        Button btn_center = new Button("Center");
        Button btn_right = new Button("Right");

        HBox hbox = new HBox();
        hbox.getStyleClass().add("null");
        hbox.getChildren().add(label);
        hbox.getChildren().add(btn_left);
        hbox.getChildren().add(btn_center);
        hbox.getChildren().add(btn_right);
        HBox.setHgrow(hbox, Priority.ALWAYS);

        // ============================

        Button btn_file = new Button("Файлы");
        Button btn_cal = new Button("Календарь");
        Button btn_task = new Button("Задачи");
        Button btn_bd = new Button("База данных");

        VBox vBox = new VBox();
        vBox.getChildren().add(btn_file);
        vBox.getChildren().add(btn_cal);
        vBox.getChildren().add(btn_task);
        vBox.getChildren().add(btn_bd);

        // ============================

        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("main");
        BorderPane.setAlignment(hbox, Pos.TOP_CENTER);
        BorderPane.setAlignment(vBox, Pos.CENTER_LEFT);
        borderPane.setTop(hbox);
        borderPane.setLeft(vBox);

        panel.scene = new Scene(borderPane);
        new Default_settings();
    }

}