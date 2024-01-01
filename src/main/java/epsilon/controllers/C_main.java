package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class C_main implements Default_controller {

    public double x, y;
    public Slider slider_y, slider_x;
    public double scale_x_y = 1;
    public Scale scale;
    public Translate translate;


    public Text title = new Text("Декартовая плоскость");
    public Text title_x = new Text("Изменение для X");
    public Text title_y = new Text("Изменение для Y");
    public Text indicator_height = new Text("height = 0.0");
    public Text indicator_width = new Text("width = 0.0");
    public Text grid_2d_size = new Text("Grid_2d_size: ");


    public HBox pane_title;
    public HBox pane_slider_x;
    public VBox pane_slider_y;
    public Pane pane_grid_2d;
    public BorderPane border_pane;

    @Override public void fxml() throws IOException {}
    @Override public void initialize() {

        //////////////// Установка начальных значений ////////////////
        x = 0;
        y = 0;
        scale = new Scale(scale_x_y, scale_x_y * -1);
        translate = new Translate(0, 0);


        //////////////// Создание title ////////////////
        pane_title = new HBox(); {
            pane_title.getStyleClass().add("pane_title");
            pane_title.getChildren().add(title); 
        }


        //////////////// Создание ползунка для X ////////////////
        pane_slider_x = new HBox(); {
            slider_x = new Slider();
            slider_x.setValue(0);
            slider_x.setMin(0);
            slider_x.setMax(50);
            slider_x.setOnMouseClicked(handlers.move_x());
            slider_x.setOnMouseDragged(handlers.move_x());
            slider_x.setOnMouseReleased(handlers.move_x());

            pane_slider_x.getChildren().addAll(title_x, slider_x);
            pane_slider_x.getStyleClass().add("pane_slider_x");
        }

        //////////////// Создание сетки с кругом ////////////////
        pane_grid_2d = new Pane(); {

            pane_grid_2d.heightProperty().addListener(handlers.set_zero_position);
            pane_grid_2d.widthProperty().addListener(handlers.set_zero_position);
            pane_grid_2d.getChildren().add(el.create_cicle());
            pane_grid_2d.getStyleClass().add("pane_center");
        }

        //////////////// Создание ползунка для Y ////////////////
        pane_slider_y = new VBox(); {
            slider_y = new Slider();
            // slider_y.setRotate(-90);
            slider_y.setValue(0);
            slider_y.setMin(0);
            slider_y.setMax(100);
            slider_y.setOnMouseClicked(handlers.move_y());
            slider_y.setOnMouseDragged(handlers.move_y());
            slider_y.setOnMouseReleased(handlers.move_y());

            Spinner<Integer> spinner_y = new Spinner<Integer>(-500, 500, 0, 5);
            Spinner<Integer> spinner_x = new Spinner<Integer>(-500, 500, 0, 5);
            spinner_y.valueProperty().addListener((observable, oldValue, newValue) -> {
                pane_grid_2d.setTranslateY(newValue);
            });
            spinner_x.valueProperty().addListener((observable, oldValue, newValue) -> {
                pane_grid_2d.setTranslateX(newValue);
            });
            spinner_x.setEditable(true);
            spinner_y.setEditable(true);


            RadioButton btn_scale = new RadioButton("Изменить полюса");
            btn_scale.setAccessibleHelp("Изменить полюса_2");
            btn_scale.setSelected(false);
            btn_scale.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if(btn_scale.isSelected()) { pane_grid_2d.setScaleY(-1); }
                else { pane_grid_2d.setScaleY(1); }
            });




            pane_slider_y.getChildren().addAll(slider_y, title_y, grid_2d_size, spinner_y, spinner_x, btn_scale);
            pane_slider_y.getStyleClass().add("pane_slider_y");
        }

        //////////////// Упаковка и отправка ////////////////
        border_pane = new BorderPane(); {
            border_pane.getStyleClass().add("c_decart");
            border_pane.setTop(pane_title);
            border_pane.setBottom(pane_slider_x);
            border_pane.setLeft(pane_slider_y);
            border_pane.setCenter(pane_grid_2d);

            BorderPane.setAlignment(pane_title, Pos.TOP_CENTER);
            BorderPane.setAlignment(pane_slider_x, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(pane_slider_y, Pos.CENTER_LEFT);
            BorderPane.setAlignment(pane_grid_2d, Pos.BOTTOM_CENTER);
        }

        panel.scene = new Scene(border_pane);
        panel.default_settings();
        {
            panel.stage.setHeight(500);
            panel.stage.setWidth(500);
        }
        panel.stage.show();
    }

}