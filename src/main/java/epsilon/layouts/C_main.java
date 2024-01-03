package epsilon.layouts;
import static epsilon.Panel.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class C_main extends Default_layouts {

    ////////// Variables //////////
    public Slider slider_y, slider_x;
    public double scale_x_y = 1;
    public Scale scale;
    public Translate translate;
    private static final double MIN_SCALE = 0.1;
    private static final double MAX_SCALE = 10.0;
    private static final double SCALE_DELTA = 1.1;

    public HBox box_title;
    public HBox box_bottom;
    public VBox box_left;
    public Pane box_center;
    public BorderPane root;

    @Override public void default_settings() {
        panel.scene = new Scene(root);
        super.default_settings();
        panel.stage.setHeight(500);
        panel.stage.setWidth(500);
        panel.stage.show();
    }
    @Override public void initialize() {

        ////////// Создание title //////////
        box_title = new HBox(); {
            Text title = new Text("Декартовая плоскость");

            box_title.getChildren().add(title);
            box_title.getStyleClass().add("box_title"); 
        }


        ////////// Создание ползунка для X //////////
        box_bottom = new HBox(); {
            slider_x = new Slider();
            slider_x.setValue(0);
            slider_x.setMin(0);
            slider_x.setMax(50);
            slider_x.setOnMouseClicked(handlers.move_circle("X"));
            slider_x.setOnMouseDragged(handlers.move_circle("X"));
            slider_x.setOnMouseReleased(handlers.move_circle("X"));

            box_bottom.getChildren().addAll(slider_x);
            box_bottom.getStyleClass().add("box_bottom");
        }

        ////////// Создание сетки с кругом //////////
        box_center = new Pane(); {
            box_center.heightProperty().addListener(handlers.render_win_resizer);
            box_center.widthProperty().addListener(handlers.render_win_resizer);
            box_center.getChildren().addAll(render.grid_2d, el.circle_parent, render.chart);
            box_center.setOnScroll(event -> {
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
                box_center.getTransforms().add(scale);
            });
        }

        ////////// Создание ползунка для Y //////////
        box_left = new VBox(); {
            slider_y = new Slider();
            slider_y.setRotate(-90);
            slider_y.setValue(0);
            slider_y.setMin(0);
            slider_y.setMax(100);
            slider_y.setOnMouseClicked(handlers.move_circle("Y"));
            slider_y.setOnMouseDragged(handlers.move_circle("Y"));
            slider_y.setOnMouseReleased(handlers.move_circle("Y"));
            box_left.getChildren().add(slider_y);


            Spinner<Integer> spinner_function = new Spinner<Integer>(-20, 20, 0);
            spinner_function.valueProperty().addListener((observable, oldValue, newValue) -> {
                render.functions(newValue);
            });
            spinner_function.setEditable(true);

            box_left.getChildren().addAll(new Label("Функция y(x) = "), spinner_function);
            box_left.getStyleClass().add("box_left");
        }

        ////////// Упаковка и отправка //////////
        root = new BorderPane(); {
            root.getStyleClass().add("c_main");
            root.setCenter(box_center);
            root.setTop(box_title);
            root.setBottom(box_bottom);
            root.setLeft(box_left);

            BorderPane.setAlignment(box_center, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(box_title, Pos.TOP_CENTER);
            BorderPane.setAlignment(box_bottom, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(box_left, Pos.CENTER_LEFT);
        }

        default_settings();
    }

}