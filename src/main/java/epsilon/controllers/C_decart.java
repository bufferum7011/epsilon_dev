package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class C_decart implements Default_controller {

    public Circle circle;
    public double x, y;
    public Slider slider_y, slider_x;

    @Override public void fxml() throws IOException { }
    @Override public void initialize() {

        //////////////// Установка начальных значений ////////////////
        x = 0;
        y = 0;


        //////////////// Создание title ////////////////
        HBox pane_title = new HBox(); {
                Text title = new Text("Декартовая плоскость");
                    title.setFill(Color.WHITE);
            pane_title.getStyleClass().add("pane_title");
            pane_title.getChildren().add(title);
            pane_title.setMaxHeight(100);
            pane_title.setMinHeight(50);
            pane_title.setMaxWidth(1000);
            pane_title.setMinWidth(800);
        }


        //////////////// Создание ползунка для X ////////////////
        HBox pane_slider_x = new HBox(); {
                Text title_x = new Text("Изменение для X");
                    title_x.setFill(Color.WHITE);
                slider_x = new Slider();
                slider_x.setValue(0);
                slider_x.setMin(0);
                slider_x.setMax(100);
                slider_x.setOnMouseClicked(handlers.move_x());
                slider_x.setOnMouseDragged(handlers.move_x());
                slider_x.setOnMouseReleased(handlers.move_x());
            pane_slider_x.getChildren().addAll(slider_x, title_x);
        }


        //////////////// Создание ползунка для Y ////////////////
        VBox pane_slider_y = new VBox(); {
                Text title_y = new Text("Изменение для Y");
                    title_y.setFill(Color.WHITE);
                slider_y = new Slider();
                slider_y.setRotate(90);
                slider_y.setValue(0);
                slider_y.setMin(0);
                slider_y.setMax(100);
                slider_y.setOnMouseClicked(handlers.move_y());
                slider_y.setOnMouseDragged(handlers.move_y());
                slider_y.setOnMouseReleased(handlers.move_y());
            pane_slider_y.getChildren().addAll(slider_y, title_y);
        }


        //////////////// Создание круга ////////////////
        Pane pane_center = new Pane(); {

            pane_center.getStyleClass().add("pane_center");
                circle = new Circle(); {
                    circle.setCenterX(x);
                    circle.setCenterY(y);
                    circle.setRadius(50);
                    circle.setFill(Color.YELLOW);
                }
            pane_center.getChildren().add(circle);
        }


        //////////////// Упаковка и отправка ////////////////
        BorderPane borderPane = new BorderPane(); {

            borderPane.getStyleClass().add("c_decart");
            borderPane.setTop(pane_title);
            borderPane.setCenter(pane_center);
            borderPane.setBottom(pane_slider_x);
            borderPane.setLeft(pane_slider_y);
        }

        panel.scene = new Scene(borderPane);
        panel.default_settings();

        {
            panel.stage.setHeight(500);
            panel.stage.setWidth(500);
        }

        panel.stage.show();
    }

}