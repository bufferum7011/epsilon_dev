package epsilon.layouts;
import static epsilon.Panel.btns;
import static epsilon.Panel.h_render_el;
import static epsilon.Panel.offset;
import static epsilon.Panel.panel;
import static epsilon.Panel.render;
import static epsilon.Panel.render_el;
import static epsilon.Panel.style_control;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import epsilon.Style_control;
import epsilon.handlers.Centering;
import epsilon.handlers.Resize;
import epsilon.handlers.Scroll;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

public class C_main extends Default_layouts {

    public VBox box_title;
    public StackPane box_bottom;
    public StackPane box_left;
    public Pane box_center;
    public BorderPane root;

    ////////// Decorations //////////
    public Slider slider_y, slider_x;
    public Line delimeter_title;

    @Override public void set_scene(Scene scene) { super.set_scene(scene); }

    @Override public void execute_before(Stage stage) {

        root = new BorderPane();
        set_scene(new Scene(root));
        style_control = new Style_control(stage);

        stage.setHeight(600);
        stage.setWidth(1000);
        super.execute_before(stage);
    }
    @Override public void initialize(Stage stage) {

        ////////// Создание title //////////
        box_title = new VBox(); {

            HBox hBox = new HBox(); {

                Pane spacer = new Pane();
                HBox.setHgrow(spacer, Priority.ALWAYS);

                Text text = new Text("Декартовая плоскость");
                text.setStroke(Color.WHITE);

                Pane spacer_2 = new Pane();
                HBox.setHgrow(spacer_2, Priority.ALWAYS);

                HBox inner_hBox = new HBox(); {

                    String[] imgs = { panel.img_hide, panel.img_resize, panel.img_close };
                    List<Consumer<MouseEvent>> methods = new ArrayList<>();
                    methods.add(e -> btns.win_hide());
                    methods.add(e -> btns.win_resize());
                    methods.add(e -> btns.win_close());

                    for(int i = 0; i < imgs.length; i++) {

                        Rectangle bg = new Rectangle(20, 30, Color.rgb(0, 0, 0, 0));
                        Consumer<MouseEvent> method = methods.get(i);
                        bg.setOnMouseClicked(e -> method.accept(e));

                        ImageView imgView = new ImageView(imgs[i]);
                        imgView.setFitWidth(22);
                        imgView.setFitHeight(22);

                        StackPane btn = new StackPane(bg, imgView);
                        // btn.getStyleClass().add("box_title_btn");
                        // new Style_control<>(btn, "box_title_btn").add();
                        
                        inner_hBox.getChildren().add(btn);
                    }

                    inner_hBox.setSpacing(10);
                    inner_hBox.setAlignment(Pos.CENTER_RIGHT);
                }

                hBox.getChildren().addAll(spacer, text, spacer_2, inner_hBox);
                // box_title.getStyleClass().add("box_title");
                // Pair<T, String> pair = new Pair<T, String>(hbox, "box_title");
                // style_control.add(pair);
                style_control.add(box_title, "box_title");

                hBox.setAlignment(Pos.CENTER);
            }

            delimeter_title = new Line();
            box_title.getChildren().addAll(hBox, delimeter_title);
        }

        ////////// Создание ползунка для X //////////
        box_bottom = new StackPane(); {

            slider_x = new Slider(); {
                slider_x.setValue(0);
                slider_x.setMin(0);
                slider_x.setMax(100);
                slider_x.setMaxSize(200, 20);
                slider_x.setOnMouseClicked(e -> h_render_el.move_circle("X"));
                slider_x.setOnMouseDragged(e -> h_render_el.move_circle("X"));
                slider_x.setOnMouseReleased(e -> h_render_el.move_circle("X"));
            }

            box_bottom.getChildren().addAll(slider_x);
            style_control.add(box_bottom, "box_bottom");
            // style_control.add(box_bottom, "box_bottom");
        }

        ////////// Создание ползунка для Y //////////
        box_left = new StackPane(); {

            slider_y = new Slider(); {
                slider_y.setRotate(-90);
                slider_y.setValue(0);
                slider_y.setMin(0);
                slider_y.setMax(100);
                slider_y.setMaxSize(200, 20);
                slider_y.setOnMouseClicked(e -> h_render_el.move_circle("Y"));
                slider_y.setOnMouseDragged(e -> h_render_el.move_circle("Y"));
                slider_y.setOnMouseReleased(e -> h_render_el.move_circle("Y"));
            }

            box_left.getChildren().add(slider_y);
            // new Style_control<>(box_left, "box_left").add();
        }

        ////////// Создание сетки с кругом //////////
        box_center = new Pane(); { box_center.getChildren().addAll(render.grid_2d, render_el.circle_parent); }

        ////////// Упаковка и отправка //////////
        {

            // new Style_control<>(root, "c_main").add();
            root.setCenter(box_center);
            root.setBottom(box_bottom);
            root.setLeft(box_left);
            root.setTop(box_title);

            BorderPane.setAlignment(box_center, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(box_title, Pos.TOP_CENTER);
            BorderPane.setAlignment(box_bottom, Pos.BOTTOM_CENTER);
            BorderPane.setAlignment(box_left, Pos.CENTER_LEFT);
        }

    }
    @Override public void execute_after(Stage stage) {


        // Изменение размеров окна
        Resize resize = new Resize(stage);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_MOVED, resize);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED, resize);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_DRAGGED, resize);
        stage.getScene().addEventHandler(MouseEvent.MOUSE_RELEASED, resize);

        // Скроллинг для сетки
        Scroll scroll = new Scroll();
        box_center.setOnScroll(scroll);

        // Обработчик для отцентровки сетки
        Centering centering = new Centering();
        box_center.heightProperty().addListener(centering);
        box_center.widthProperty().addListener(centering);

        // Перемещение окна по рабочему столу
        box_title.addEventHandler(MouseEvent.MOUSE_PRESSED, offset);
        box_title.addEventHandler(MouseEvent.MOUSE_DRAGGED, offset);
        box_title.addEventHandler(MouseEvent.MOUSE_RELEASED, offset);
        box_title.addEventHandler(MouseEvent.MOUSE_EXITED, offset);

        style_control.foreach();

        super.execute_after(stage);
    }

}