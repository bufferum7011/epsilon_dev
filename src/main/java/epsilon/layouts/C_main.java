package epsilon.layouts;
import static epsilon.Panel.*;

import epsilon.handlers.Resize_listener;
import epsilon.handlers.Scroll_listener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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

    public HBox box_title;
    public HBox box_bottom;
    public VBox box_left;
    public Pane box_center;
    public BorderPane root;

    @Override public void default_settings() {
        panel.scene = new Scene(root);
        super.default_settings();
        panel.stage.setHeight(600);
        panel.stage.setWidth(1000);

        // Изменение размеров окна
        Resize_listener resize_listener = new Resize_listener(panel.stage);
        panel.stage.getScene().addEventHandler(MouseEvent.MOUSE_MOVED, resize_listener);
        panel.stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED, resize_listener);
        panel.stage.getScene().addEventHandler(MouseEvent.MOUSE_DRAGGED, resize_listener);
        panel.stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED, resize_listener);
        panel.stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, resize_listener);

        // Скроллинг для сетки
        Scroll_listener scroll_listener = new Scroll_listener();
        box_center.setOnScroll(scroll_listener);

        // Перемещение окна по рабочему столу
        

        panel.stage.show();
    }
    @Override public void initialize() {

        ////////// Создание title //////////
        box_title = new HBox(); {

            Pane spacer = new Pane();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            box_title.getChildren().add(spacer);

            Text title = new Text("Декартовая плоскость");
            box_title.getChildren().add(title);

            Pane spacer_2 = new Pane();
            HBox.setHgrow(spacer_2, Priority.ALWAYS);
            box_title.getChildren().add(spacer_2);

            HBox inner_hBox = new HBox(); {

                Button btn_hide = new Button("━");
                Button btn_resize = new Button("☐");
                Button btn_clouse = new Button("✕");

                btn_hide.getStyleClass().add("box_title_btn");
                btn_resize.getStyleClass().add("box_title_btn");
                btn_clouse.getStyleClass().add("box_title_btn");

                btn_hide.setOnAction(e -> { h_resize_win.win_hide(e); });
                btn_resize.setOnAction(e -> { h_resize_win.win_resize(e); });
                btn_clouse.setOnAction(e -> { h_resize_win.win_clouse(e); });

                Insets insets = new Insets(1, 2, 1, 0);
                HBox.setMargin(btn_hide, insets);
                HBox.setMargin(btn_resize, insets);
                HBox.setMargin(btn_clouse, insets);
                HBox.setMargin(title, insets);
                inner_hBox.setSpacing(10);
                inner_hBox.setAlignment(Pos.CENTER_RIGHT);
                inner_hBox.getChildren().addAll(btn_hide, btn_resize, btn_clouse);
            }

            // box_title.setOnMousePressed(handlers.get_offset());
            // box_title.setOnMouseDragged(handlers.set_offset());
            box_title.getChildren().add(inner_hBox);
            box_title.getStyleClass().add("box_title");
            box_title.setAlignment(Pos.CENTER);
        }

        ////////// Создание ползунка для X //////////
        box_bottom = new HBox(); {
            slider_x = new Slider();
            slider_x.setValue(0);
            slider_x.setMin(0);
            slider_x.setMax(50);
            slider_x.setOnMouseClicked(e -> { h_elements.move_circle(e, "X"); });
            slider_x.setOnMouseDragged(e -> { h_elements.move_circle(e, "X"); });
            slider_x.setOnMouseReleased(e -> { h_elements.move_circle(e, "X"); });

            box_bottom.getChildren().addAll(slider_x);
            box_bottom.getStyleClass().add("box_bottom");
            box_bottom.setAlignment(Pos.CENTER);
        }

        ////////// Создание сетки с кругом //////////
        box_center = new Pane(); {
            box_center.heightProperty().addListener((e1, e2, event) -> { h_resize_win.render_win_resize(event); });
            box_center.widthProperty().addListener((e1, e2, event) -> { h_resize_win.render_win_resize(event); });
            box_center.getChildren().addAll(render.grid_2d, el.circle_parent, render.chart);
        }

        ////////// Создание ползунка для Y //////////
        box_left = new VBox(); {
            slider_y = new Slider();
            slider_y.setRotate(-90);
            slider_y.setValue(0);
            slider_y.setMin(0);
            slider_y.setMax(100);
            slider_y.setOnMouseClicked(e -> { h_elements.move_circle(e, "Y"); });
            slider_y.setOnMouseDragged(e -> { h_elements.move_circle(e, "Y"); });
            slider_y.setOnMouseReleased(e -> { h_elements.move_circle(e, "Y"); });
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
            root.setBottom(box_bottom);
            root.setLeft(box_left);
            root.setTop(box_title);

            BorderPane.setAlignment(box_center, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(box_title, Pos.TOP_CENTER);
            BorderPane.setAlignment(box_bottom, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(box_left, Pos.CENTER_LEFT);
        }

        default_settings();
    }

}