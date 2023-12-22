package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class C_index implements Default_controller {

    @Override public void fxml() throws IOException { new C_main().get_scene("index"); }
    @Override public void initialize() {

        HBox hbox = new HBox(); {
            Label label = new Label(panel.server_project);
            Button btn_hide = new Button("_");
            Button btn_resize = new Button("☐");
            Button btn_close = new Button("✕");
            BorderPane borderPane_2 = new BorderPane();

            btn_hide.setOnMousePressed(handlers.get_hide());
            btn_resize.setOnMousePressed(handlers.get_resize());
            btn_close.setOnMousePressed(handlers.get_clouse());

            borderPane_2.setLeft(btn_hide);
            borderPane_2.setCenter(btn_resize);
            borderPane_2.setRight(btn_close);
            BorderPane.setAlignment(borderPane_2, Pos.BASELINE_RIGHT);

            hbox.getStyleClass().add("main_header");
            hbox.getChildren().addAll(label, borderPane_2);
            HBox.setHgrow(hbox, Priority.ALWAYS);
        }


        VBox vBox = new VBox(); {
            Button btn_file = new Button("Файлы");
            Button btn_cal = new Button("Календарь");
            Button btn_task = new Button("Задачи");
            Button btn_bd = new Button("База данных");

            vBox.getChildren().addAll(btn_file, btn_cal, btn_task, btn_bd);
        }


        HBox hbox_2 = new HBox(); {
            Label label_2 = new Label(panel.server_project);
            Button btn_left_2 = new Button("Left");
            Button btn_center_2 = new Button("Center");
            Button btn_right_2 = new Button("Right");

            hbox_2.getStyleClass().add("main_header");
            hbox_2.getChildren().add(label_2);
            hbox_2.getChildren().add(btn_left_2);
            hbox_2.getChildren().add(btn_center_2);
            hbox_2.getChildren().add(btn_right_2);
            HBox.setHgrow(hbox_2, Priority.ALWAYS);
        }


        VBox vBox_2 = new VBox(); {
            Button btn_file_2 = new Button("Файлы");
            Button btn_cal_2 = new Button("Календарь");
            Button btn_task_2 = new Button("Задачи");
            Button btn_bd_2 = new Button("База данных");

            vBox_2.getChildren().addAll(btn_file_2, btn_cal_2, btn_task_2, btn_bd_2);
        }


        ScrollPane scrollPane = new ScrollPane(); {
            VBox vbox_center = new VBox();
            for(int i = 0; i < 50; i++) {
                vbox_center.getChildren().add(new Button("Кнопка " + i));
            }

            scrollPane.setMaxWidth(500);
            scrollPane.setMaxHeight(300);
            scrollPane.setMinWidth(500);
            scrollPane.setMinHeight(300);
            scrollPane.setContent(vbox_center);
        }


        BorderPane borderPane = new BorderPane(); {
            borderPane.getStyleClass().add("main");
            borderPane.setTop(hbox);
            borderPane.setLeft(vBox);
            borderPane.setRight(vBox_2);
            borderPane.setBottom(hbox_2);
            borderPane.setCenter(scrollPane);

            BorderPane.setAlignment(hbox, Pos.TOP_CENTER);
            BorderPane.setAlignment(vBox, Pos.CENTER_LEFT);
            BorderPane.setAlignment(hbox_2, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(vBox_2, Pos.CENTER_RIGHT);
            BorderPane.setAlignment(scrollPane, Pos.CENTER);
        }


        panel.scene = new Scene(borderPane);
        panel.default_settings();
        panel.stage.show();
    }

}