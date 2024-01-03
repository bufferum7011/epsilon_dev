package epsilon;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Elements {

    public Elements() {
        circle = new Circle();
        circle_parent = circle.create();
    }

    public Circle circle;
    public Group circle_parent;
}

class Circle {

    public Text lable_x = new Text("X = 0.0");
    public Text lable_y = new Text("Y = 0.0");
    

    public Group create() {
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(20, Color.YELLOW);
        VBox vBox = new VBox(lable_x, lable_y);
        vBox.setScaleY(-1);
        return new Group(circle, vBox);
    }

}