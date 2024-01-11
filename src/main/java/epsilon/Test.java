package epsilon;
import static epsilon.Panel.panel;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test {

    public static Stage primaryStage;
    public void initialize() {
primaryStage = panel.stage;
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

        HBox box_top = new HBox();
        Text top_text = new Text("Some text TOP");
        box_top.getChildren().add(top_text);

        VBox box_left = new VBox();
        Text text_right = new Text("Some text RIGHT");
        box_left.getChildren().add(text_right);

        Pane box_center = new Pane();
        Button btn = new Button("Opacity switch");
        btn.setOnMouseClicked(event -> {
            primaryStage.setOpacity(0.85);
        });
        btn.setOnMouseReleased(event -> {
            primaryStage.setOpacity(1);
        });
        box_center.getChildren().add(btn);

        root.setTop(box_top);
        root.setLeft(box_left);
        root.setCenter(box_center);

        // primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}