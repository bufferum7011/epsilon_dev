package epsilon;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;

public class Render_elements {

    public Render_elements() {
        circle = new Circle();
        circle_parent = circle.create();
    }

    public Circle circle;
    public Group circle_parent;

    public static class Circle {

        public Text lable_x = new Text("X = 0.0");
        public Text lable_y = new Text("Y = 0.0");
        

        public Group create() {
            javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(50, Color.YELLOW);
            VBox vBox = new VBox(lable_x, lable_y);
            vBox.getTransforms().add(new Translate(-10, -10));
            return new Group(circle, vBox);
        }

    }
}