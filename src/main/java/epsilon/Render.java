package epsilon;
import static epsilon.Panel.*;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class Render {

    public double CENTER_X;
    public double CENTER_Y;
    public double BOX_CENTER_HEIGHT;
    public double BOX_CENTER_WIDTH;
    private final double TERMINATOR = 42.15;
    public Translate box_center_translate;
    public Scale box_center_scale;




    
    public Pane grid_2d = new Pane();
    public Pane chart = new Pane();
    public static Cordinat cordinat = new Cordinat();

    public Render() {}
    public Render(double BOX_CENTER_HEIGHT, double BOX_CENTER_WIDTH) {
        this.BOX_CENTER_WIDTH = BOX_CENTER_WIDTH;
        this.BOX_CENTER_HEIGHT = BOX_CENTER_HEIGHT;
        CENTER_X = (BOX_CENTER_WIDTH  / 2);
        CENTER_Y = (BOX_CENTER_HEIGHT / 2);

        box_center_scale = new Scale(1, -1);
        box_center_translate = new Translate(CENTER_X, CENTER_Y);
    }

    public void create_grid_2d() {

        c_main.box_center.getTransforms().clear();
        c_main.box_center.getTransforms().addAll(box_center_translate, box_center_scale);
        c_main.box_center.getChildren().set(0, grid_2d);

        grid_2d.getChildren().clear();

        ////////// Рисую линию в сторону +X //////////
        for(double x = 0; x < CENTER_X; x += TERMINATOR) {
            Line line = new Line(x, -CENTER_Y, x, BOX_CENTER_HEIGHT);
            line.setStroke(Color.rgb(50, 50, 50));
            grid_2d.getChildren().add(line);
        }

        ////////// Рисую линию в сторону -X //////////
        for(double x = 0; x > -CENTER_X; x -= TERMINATOR) {
            Line line = new Line(x, CENTER_Y, x, -BOX_CENTER_HEIGHT);
            line.setStroke(Color.rgb(50, 50, 50));
            grid_2d.getChildren().add(line);
        }

        ////////// Рисую линию в сторону +Y //////////
        for(double y = 0; y < CENTER_Y; y += TERMINATOR) {
            Line line = new Line(CENTER_X, y, -BOX_CENTER_WIDTH, y);
            line.setStroke(Color.rgb(50, 50, 50));
            grid_2d.getChildren().add(line);
        }

        ////////// Рисую линию в сторону -Y //////////
        for(double y = 0; y > -CENTER_Y; y -= TERMINATOR) {
            Line line = new Line(CENTER_X, y, -BOX_CENTER_WIDTH, y);
            line.setStroke(Color.rgb(50, 50, 50));
            grid_2d.getChildren().add(line);
        }

        ////////// Рисую линии X и Y //////////
        Line line_x = new Line(CENTER_X, 0, -CENTER_X, 0);
            line_x.setStroke(Color.WHITE);
            line_x.setStrokeWidth(1);
            grid_2d.getChildren().add(line_x);
        Line line_y = new Line(0, CENTER_Y, 0, -CENTER_Y);
            line_y.setStroke(Color.WHITE);
            line_y.setStrokeWidth(1);
            grid_2d.getChildren().add(line_y);
    }

    public void functions(double xx) {

        chart.getChildren().clear();

        cordinat.set_list(2);
        
        ArrayList<Cordinat> c = cordinat.list;
        boolean key = true;
        Line line = null;

        for(double i = 0; i < c.size() && c.iterator().hasNext(); i++) {

            int x = (int) Math.round(c.get((int) i).x);
            int y = (int) Math.round(c.get((int) i).y);

            if(key) {
                key = false;

                line = new Line();
                line.setStartX(x);
                line.setStartY(y);

            }
            else {
                key = true;

                line.setEndX(x);
                line.setEndY(y);

                line.setStroke(Color.WHITE);
                line.setStrokeWidth(3);
                chart.getChildren().add(line);

            }
            print.way("(" + x + ")(" + y + ")===");
        }

    }

}

class Cordinat {

    public double x;
    public double y;

    public ArrayList<Cordinat> list = new ArrayList<Cordinat>();
    public final double TERMINATOR = 42.15;

    public Cordinat() {}
    public Cordinat(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set_list(double x) {
        for(double y = -(4 * TERMINATOR); y < 4 * TERMINATOR; y+=TERMINATOR) {
            x = x + 2 * TERMINATOR;
            print.debag("(" + x + "_" + y + ")");
            list.add(new Cordinat(x, y));
        }
    }
    
}