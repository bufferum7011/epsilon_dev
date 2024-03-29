package epsilon;
import static epsilon.Panel.c_main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class Render {

    ////////// box_center ////////// 
    public double CENTER_X;
    public double CENTER_Y;
    public double BOX_CENTER_HEIGHT;
    public double BOX_CENTER_WIDTH;
    public Translate box_center_translate;
    public Scale box_center_scale;

    ////////// grid_2d //////////
    private final double TERMINATOR = 50;
    public Pane grid_2d = new Pane();

    public void create_grid_2d() {

        this.BOX_CENTER_WIDTH = c_main.box_center.getWidth();
        this.BOX_CENTER_HEIGHT = c_main.box_center.getHeight();
        CENTER_X = (BOX_CENTER_WIDTH  / 2);
        CENTER_Y = (BOX_CENTER_HEIGHT / 2);
        double delimeter = 10;

        box_center_scale = new Scale(1, -1);
        box_center_translate = new Translate(CENTER_X, CENTER_Y);

        c_main.box_center.getTransforms().clear();
        c_main.box_center.getTransforms().addAll(box_center_translate, box_center_scale);
        c_main.box_center.getChildren().set(0, grid_2d);

        grid_2d.getChildren().clear();

        ////////// Рисую линию в сторону +X //////////
        for(double x = 0; x < CENTER_X; x += TERMINATOR) {
            Line line = new Line(x, -CENTER_Y, x, BOX_CENTER_HEIGHT);
            line.setStroke(Color.rgb(50, 50, 50));

            Line line_short = new Line(x, -5, x, 5);
            line_short.setStroke(Color.WHITE);

            Text text = new Text((int) x / delimeter + ""); {
                text.setStrokeWidth(1);
                text.setX(x - 5);
                text.setY(15);
                text.setStroke(Color.WHITE);
            }
            grid_2d.getChildren().addAll(line, line_short, text);
        }

        ////////// Рисую линию в сторону -X //////////
        for(double x = 0; x > -CENTER_X; x -= TERMINATOR) {
            Line line = new Line(x, CENTER_Y, x, -BOX_CENTER_HEIGHT);
            line.setStroke(Color.rgb(50, 50, 50));

            Line line_short = new Line(x, -5, x, 5);
            line_short.setStroke(Color.WHITE);

            Text text = new Text((int) x / delimeter + ""); {
                text.setStrokeWidth(1);
                text.setX(x - 5);
                text.setY(15);
                text.setStroke(Color.WHITE);
            }

            grid_2d.getChildren().addAll(line, line_short, text);
        }

        ////////// Рисую линию в сторону +Y //////////
        for(double y = 0; y < CENTER_Y; y += TERMINATOR) {
            Line line = new Line(CENTER_X, y, -BOX_CENTER_WIDTH, y);
            line.setStroke(Color.rgb(50, 50, 50));

            Line line_short = new Line(-5, y, 5, y);
            line_short.setStroke(Color.WHITE);

            Text text = new Text((int) y / delimeter + ""); {
                text.setStrokeWidth(1);
                text.setX(15);
                text.setY(y - 5);
                text.setStroke(Color.WHITE);
            }

            grid_2d.getChildren().addAll(line, line_short, text);
        }

        ////////// Рисую линию в сторону -Y //////////
        for(double y = 0; y > -CENTER_Y; y -= TERMINATOR) {
            Line line = new Line(CENTER_X, y, -BOX_CENTER_WIDTH, y);
            line.setStroke(Color.rgb(50, 50, 50));

            Line line_short = new Line(-5, y, 5, y);
            line_short.setStroke(Color.WHITE);

            Text text = new Text((int) y / delimeter + ""); {
                text.setStrokeWidth(1);
                text.setX(15);
                text.setY(y - 5);
                text.setStroke(Color.WHITE);
            }

            grid_2d.getChildren().addAll(line, line_short, text);
        }

        ////////// Рисую линии X и Y //////////
        Line line_x = new Line(CENTER_X, 0, -CENTER_X, 0); {
            line_x.setStroke(Color.WHITE);
            line_x.setStrokeWidth(1);
            grid_2d.getChildren().add(line_x);
        }
        Line line_y = new Line(0, CENTER_Y, 0, -CENTER_Y); {
            line_y.setStroke(Color.WHITE);
            line_y.setStrokeWidth(1);
            grid_2d.getChildren().add(line_y);
        }

    }

}