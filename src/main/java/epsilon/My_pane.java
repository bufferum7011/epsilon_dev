package epsilon;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class My_pane {
    
    public My_pane() {

        Circle circle = new Circle(50);
        circle.setFill(Color.rgb(122, 122, 122));
        circle.setStroke(Color.AQUA);
        circle.setStrokeWidth(10);


        Text text = new Text("Hello world!");
        text.setStyle("-fx-fill: green;");


        VBox pane = new VBox();
        // pane.getChildren().addAll(text);
        // pane.getChildren().addAll(circle);


        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(pane);

        // ===============================
        // pane = new Pane();
        // pane.getChildren().addAll(circle);
        // pane.getChildren().addAll(text);

    }

    private Object pane;
    public Object get_pane() { return pane; }
    
}