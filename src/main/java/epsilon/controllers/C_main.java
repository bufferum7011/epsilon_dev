package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class C_main implements Default_controller {

    @Override public void fxml() throws IOException { get_scene("greeting"); }
    @Override public void initialize() {

        Group group = new Group();

        // Text
        Text text = new Text();
        text.setText("WHOOOOOA!!!");
        text.setX(50);
        text.setY(50);
        text.setFill(Color.RED);
        text.setFont(new Font("Verdana", 20));
        group.getChildren().add(text);

        // Line
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStroke(Color.ORANGE);
        line.setStrokeWidth(5);
        line.setOpacity(1);
        line.setRotate(45);
        group.getChildren().add(line);

        // Rectangle прямоугольник
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(100);
        rectangle.setFill(Color.GHOSTWHITE);
        rectangle.setX(0);
        rectangle.setY(0);
        rectangle.setStrokeWidth(20);
        rectangle.setStroke(Color.SANDYBROWN);
        group.getChildren().add(rectangle);

        // Polygon/Traingle триугольник
        Polygon traingle = new Polygon();
        traingle.getPoints().setAll(
            200.0, 200.0,
            300.0, 300.0,
            200.0, 300.0
        );
        traingle.setFill(Color.PURPLE);
        group.getChildren().add(traingle);

        // Circle круг
        Circle circle = new Circle();
        circle.setCenterX(300);
        circle.setCenterY(300);
        circle.setRadius(50);
        circle.setFill(Color.BLACK);
        group.getChildren().add(circle);

        // Image
        ImageView imageView = new ImageView(new Image("/img_sys/icon.png"));
        imageView.setX(400);
        imageView.setY(400);
        group.getChildren().add(imageView);

        panel.scene = new Scene(group);
        panel.default_settings();
        panel.stage.show();
    }

    public void get_scene(String fxml) throws IOException {

        panel.scene = new Scene(new FXMLLoader(epsilon.getClass().getResource(fxml + ".fxml")).load());
        panel.scene.getStylesheets().add(panel.css);
        panel.default_settings();
    }

    public static Circle circle;
    public double x = 300;
    public double y = 300;

    public void init_2() {

        // Circle круг
        circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(50);
        circle.setFill(Color.BLACK);

        Button btn_up = new Button("UP");
        Button btn_down = new Button("DOWN");
        Button btn_left = new Button("LEFT");
        Button btn_right = new Button("RIGHT");

        btn_up.setOnMousePressed(handlers.move_circle("up", circle));
        btn_down.setOnMousePressed(handlers.move_circle("down", circle));
        btn_left.setOnMousePressed(handlers.move_circle("left", circle));
        btn_right.setOnMousePressed(handlers.move_circle("right", circle));

        Pane pane = new Pane(circle);
        pane.setMaxHeight(600);
        pane.setMaxWidth(600);
        pane.getStyleClass().add("my_pane_for_circle");


        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("cicle");

        borderPane.setTop(btn_up);
        borderPane.setBottom(btn_down);
        borderPane.setLeft(btn_left);
        borderPane.setRight(btn_right);
        borderPane.setCenter(pane);

        BorderPane.setAlignment(btn_up, Pos.TOP_CENTER);
        BorderPane.setAlignment(btn_down, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(btn_left, Pos.CENTER_LEFT);
        BorderPane.setAlignment(btn_right, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(pane, Pos.CENTER);

        panel.scene = new Scene(borderPane);
        panel.default_settings();
        panel.stage.show();
    }

}