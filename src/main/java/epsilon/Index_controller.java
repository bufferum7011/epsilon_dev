package epsilon;
import static epsilon.Panel.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
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
        hbox.getStyleClass().add("main_header");
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

        Label label_2 = new Label(panel.server_project);

        Button btn_left_2 = new Button("Left");
        Button btn_center_2 = new Button("Center");
        Button btn_right_2 = new Button("Right");

        HBox hbox_2 = new HBox();
        hbox_2.getStyleClass().add("main_header");
        hbox_2.getChildren().add(label_2);
        hbox_2.getChildren().add(btn_left_2);
        hbox_2.getChildren().add(btn_center_2);
        hbox_2.getChildren().add(btn_right_2);
        HBox.setHgrow(hbox_2, Priority.ALWAYS);

        // ============================

        Button btn_file_2 = new Button("Файлы");
        Button btn_cal_2 = new Button("Календарь");
        Button btn_task_2 = new Button("Задачи");
        Button btn_bd_2 = new Button("База данных");

        VBox vBox_2 = new VBox();
        vBox_2.getChildren().add(btn_file_2);
        vBox_2.getChildren().add(btn_cal_2);
        vBox_2.getChildren().add(btn_task_2);
        vBox_2.getChildren().add(btn_bd_2);

        // ============================

        ScrollPane scrollPane = new ScrollPane();

        List<Button> btns = new ArrayList<Button>();
        for(int i = 0; i < 10; i++) {
            btns.add(new Button("Кнопка_" + i + 1));
        }

        AnchorPane anchorPane = new AnchorPane();

        // ============================

        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("main");
        borderPane.setTop(hbox);
        borderPane.setLeft(vBox);
        borderPane.setRight(vBox_2);
        borderPane.setBottom(hbox_2);
        borderPane.setCenter(anchorPane);

        BorderPane.setAlignment(hbox, Pos.TOP_CENTER);
        BorderPane.setAlignment(vBox, Pos.CENTER_LEFT);
        BorderPane.setAlignment(hbox_2, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(vBox_2, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(anchorPane, Pos.CENTER);

        panel.scene = new Scene(borderPane);
        new Default_settings();
    }

}