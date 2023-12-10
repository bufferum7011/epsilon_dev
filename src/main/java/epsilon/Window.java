package epsilon;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window {

    public static void setRoot(String fxml) throws IOException {
        panel.scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Epsilon.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void test_1(Stage stage) {

        Circle circle = new Circle(50);
        circle.setFill(Color.rgb(122, 122, 122));
        circle.setStroke(Color.AQUA);
        circle.setStrokeWidth(10);

        Text text = new Text("Hello world!");
        text.setStyle("-fx-fill: green;");

        VBox pane = new VBox();
        // pane.getChildren().addAll(text);
        // pane.getChildren().addAll(circle);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(pane);
        panel.scene.setRoot(borderPane);

        // pane = new Pane();
        // pane.getChildren().addAll(circle);
        // pane.getChildren().addAll(text);
        new Default_settings();
    }
    public void index_fxml() throws IOException {

        panel.scene = new Scene(loadFXML("sol"));
        panel.scene.getStylesheets().add(panel.css);
        new Default_settings();
    }
    public void greeting() throws IOException {

        panel.scene = new Scene(loadFXML("greeting"));
        panel.scene.getStylesheets().add(panel.css);
        new Default_settings();
    }


    public void index_java() {

        // ============================

        Label label = new Label(panel.server_project);

        Button btn_left = new Button("Left");
        Button btn_center = new Button("Center");
        Button btn_right = new Button("Right");

        Button btn_hide = new Button("_");
        Button btn_resize = new Button("☐");
        Button btn_close = new Button("×");

        BorderPane borderPane_2 = new BorderPane();
        borderPane_2.setLeft(btn_hide);
        borderPane_2.setCenter(btn_resize);
        borderPane_2.setRight(btn_close);

        btn_hide.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                panel.stage.hide();
            }
        });
        btn_resize.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(panel.key_fullscreen) {
                    panel.key_fullscreen = false;
                    panel.stage.setFullScreen(false);
                }
                else {
                    panel.key_fullscreen = true;
                    panel.stage.setFullScreen(true);
                }

            }
        });
        btn_close.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                panel.stage.close();
            }
        });

        HBox hbox = new HBox();
        hbox.getStyleClass().add("main_header");
        hbox.getChildren().add(label);
        hbox.getChildren().add(btn_left);
        hbox.getChildren().add(btn_center);
        hbox.getChildren().add(btn_right);
        hbox.getChildren().add(borderPane_2);
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

        VBox vbox_center = new VBox();
        for(int i = 0; i < 50; i++) {
            vbox_center.getChildren().add(new Button("Кнопка " + i));
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxWidth(500);
        scrollPane.setMaxHeight(300);
        scrollPane.setMinWidth(500);
        scrollPane.setMinHeight(300);
        scrollPane.setContent(vbox_center);

        // ============================

        BorderPane borderPane = new BorderPane();
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

        panel.scene = new Scene(borderPane);
        new Default_settings();
    }


}