package epsilon;
import static epsilon.Panel.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class Grid_2d {

    public double CENTER_X;
    public double CENTER_Y;
    public double HEIGHT;
    public double WIDTH;

    public Grid_2d(double HEIGHT, double WIDTH) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        CENTER_X = (WIDTH  / 2);
        CENTER_Y = (HEIGHT / 2);

        c_main.pane_grid_2d.getTransforms().clear();
        c_main.pane_grid_2d.getTransforms().add(0, new Translate(CENTER_X, CENTER_Y));
        c_main.pane_grid_2d.getTransforms().add(new Scale(1, -1));

        // draw();
        // create_grid_lines();
    }



    public void draw() { print.way("\n======X=" + CENTER_X + "======Y=" + CENTER_Y + "======\n"); }

    //#region плохой код
    // public void grid() {

    //     int terminator = 50;
    //     boolean key_x = false, key_y = false;
    //     double first = 0;
    //     double second = 0;
    //     double x_aux = 0;
    //     double y_aux = 0;

    //     if(CENTER_X > CENTER_Y) {
    //         key_x = true;
    //         first = CENTER_X;
    //         second = CENTER_Y;
    //         x_aux = first;
    //     }
    //     else {
    //         key_y = true;
    //         first = CENTER_Y;
    //         second = CENTER_X;
    //         y_aux = first;
    //     }

    //     for(int i = 0; i < first / terminator; i++) {
    //         x_aux = terminator - x_aux;
    //         c_decart.pane_grid_2d.getChildren().add(new Line(x_aux, -CENTER_Y, x_aux, CENTER_Y));
    //     }
    // }
    //#endregion плохой код

    public void create_grid_lines() {

        // Линии с разметкой по оси X
        for(double x = CENTER_X + 50; x <= WIDTH; x += 50) {
            Line line = create_metric_line(x, CENTER_Y - 5, x, CENTER_Y + 5);
            Text text = create_metric_value(Double.toString(x - CENTER_X), x - 10, CENTER_Y + 20);
            c_main.pane_grid_2d.getChildren().clear();
            c_main.pane_grid_2d.getChildren().addAll(line, text);
        }
        for(double x = CENTER_X - 50; x >= 0; x -= 50) {
            Line line = create_metric_line(x, CENTER_Y - 5, x, CENTER_Y + 5);
            Text text = create_metric_value(Double.toString(x - CENTER_X), x - 10, CENTER_Y + 20);
            c_main.pane_grid_2d.getChildren().clear();
            c_main.pane_grid_2d.getChildren().addAll(line, text);
        }

        // Линии с разметкой по оси Y
        for(double y = CENTER_Y + 50; y <= HEIGHT; y += 50) {
            Line line = create_metric_line(CENTER_X - 5, y, CENTER_X + 5, y);
            Text text = create_metric_value(Double.toString(CENTER_Y - y), CENTER_X + 10, y + 5);
            c_main.pane_grid_2d.getChildren().clear();
            c_main.pane_grid_2d.getChildren().addAll(line, text);
        }
        for(double y = CENTER_Y - 50; y >= 0; y -= 50) {
            Line line = create_metric_line(CENTER_X - 5, y, CENTER_X + 5, y);
            Text text = create_metric_value(Double.toString(CENTER_Y - y), CENTER_X + 10, y + 5);
            c_main.pane_grid_2d.getChildren().clear();
            c_main.pane_grid_2d.getChildren().addAll(line, text);
        }
    }
    private Line create_metric_line(double startX, double startY, double endX, double endY) {
        return new Line(startX + WIDTH / 2, startY + HEIGHT / 2, endX + WIDTH / 2, endY + HEIGHT / 2);
    }
    private Text create_metric_value(String text, double x, double y) {
        Text label = new Text(text);
        label.setFont(Font.font("Arial", 10));
        label.setFill(Color.WHITE);
        label.setX(x);
        label.setY(y);
        return label;
    }
}