package epsilon.controllers;
import static epsilon.Panel.*;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class C_main {

    public double x, y;
    public Slider slider_y, slider_x;
    public double scale_x_y = 1;
    public Scale scale;
    public Translate translate;
    private static final double MIN_SCALE = 0.1;
    private static final double MAX_SCALE = 10.0;
    private static final double SCALE_DELTA = 1.1;

    public Text title = new Text("Декартовая плоскость");

    public HBox pane_title;
    public HBox pane_slider_x;
    public VBox pane_slider_y;
    public Pane pane_center;
    public BorderPane border_pane;

    public void initialize() {

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
            slider_x.setOnMouseClicked(handlers.move_circle("X"));
            slider_x.setOnMouseDragged(handlers.move_circle("X"));
            slider_x.setOnMouseReleased(handlers.move_circle("X"));

            pane_slider_x.getChildren().addAll(slider_x);
            pane_slider_x.getStyleClass().add("pane_slider_x");
        }

        //////////////// Создание сетки с кругом ////////////////
        pane_center = new Pane(); {

            Scale scale = new Scale(1, 1);
            pane_center.getTransforms().add(scale);

            pane_center.heightProperty().addListener(handlers.resizer_grid_2d);
            pane_center.widthProperty().addListener(handlers.resizer_grid_2d);
            pane_center.getChildren().addAll(grid_2d.pane_grid_2d, grid_2d.chart);
            pane_center.getStyleClass().add("pane_center");
            pane_center.setOnScroll(event -> {
                // double delta = event.getDeltaY();
                // double scaleFactor = (delta > 0) ? SCALE_DELTA : 1 / SCALE_DELTA;
    
                // Ограничение масштабирования до определенных границ
                double currentScale = scale.getX();
                print.debag(currentScale + "===");
                if(currentScale * SCALE_DELTA < MIN_SCALE || currentScale * SCALE_DELTA > MAX_SCALE) {
                    return;
                }
                print.debag("=");
                // scale.setPivotX(event.getX());
                // scale.setPivotY(event.getY());
                scale.setX(scale.getX() * SCALE_DELTA);
                scale.setY(scale.getY() * SCALE_DELTA);
                pane_center.getTransforms().add(scale);
            });
        }

        //////////////// Создание ползунка для Y ////////////////
        pane_slider_y = new VBox(); {
            slider_y = new Slider();
            slider_y.setRotate(-90);
            slider_y.setValue(0);
            slider_y.setMin(0);
            slider_y.setMax(100);
            slider_y.setOnMouseClicked(handlers.move_circle("Y"));
            slider_y.setOnMouseDragged(handlers.move_circle("Y"));
            slider_y.setOnMouseReleased(handlers.move_circle("Y"));
            pane_slider_y.getChildren().add(slider_y);


            Spinner<Integer> spinner_function = new Spinner<Integer>(-20, 20, 0);
            spinner_function.valueProperty().addListener((observable, oldValue, newValue) -> {

                // double  y1 = 0,
                //         y2 = 1,
                //         y3 = 2;
                double  x = newValue;
                double  y = x * x;

                grid_2d.functions(x);

                // Функция y = x * x4

            });
            spinner_function.setEditable(true);

            // pane_slider_y

            pane_slider_y.getChildren().addAll(new Label("Функция y(x) = "), spinner_function);
            pane_slider_y.getStyleClass().add("pane_slider_y");
        }

        //////////////// Упаковка и отправка ////////////////
        border_pane = new BorderPane(); {
            border_pane.getStyleClass().add("c_decart");
            border_pane.setCenter(pane_center);
            border_pane.setTop(pane_title);
            border_pane.setBottom(pane_slider_x);
            border_pane.setLeft(pane_slider_y);

            BorderPane.setAlignment(pane_center, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(pane_title, Pos.TOP_CENTER);
            BorderPane.setAlignment(pane_slider_x, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(pane_slider_y, Pos.CENTER_LEFT);
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