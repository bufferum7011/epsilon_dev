package epsilon;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Elements {

    public Elements() {}

    //////////////// cicle ////////////////
    public Group point;
    public Text val_x = new Text("X = 0.0");
    public Text val_y = new Text("Y = 0.0");
    public Group create_cicle() {
        VBox vBox = new VBox(val_x, val_y);
        vBox.setScaleY(-1);
        point = new Group(new Circle(20, Color.YELLOW), vBox);
        return new Group(new Circle(20, Color.YELLOW), vBox);
    }

}