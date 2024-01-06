package epsilon;
import static epsilon.Panel.*;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test {

    private double xOffset = 0;
    private double yOffset = 0;

    public static Stage primaryStage;
    public void initialize() {
        primaryStage = panel.stage;

        primaryStage.initStyle(StageStyle.UNDECORATED);

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #FFFFFF;");

        Scene scene = new Scene(root, 300, 200);
        scene.setFill(Color.TRANSPARENT);

        // Управляем изменением размера окна при зажатии курсора мыши на его краях и углах
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            double dx = event.getSceneX() - xOffset;
            double dy = event.getSceneY() - yOffset;

            double newWidth = primaryStage.getWidth();
            double newHeight = primaryStage.getHeight();
            double newX = primaryStage.getX();
            double newY = primaryStage.getY();

            if (event.getSource() instanceof AnchorPane) {
                AnchorPane rootPane = (AnchorPane) event.getSource();
                if (event.getX() <= 5) { // Изменение левого края
                    newWidth -= dx;
                    newX += dx;
                } else if (event.getX() >= rootPane.getWidth() - 5) { // Изменение правого края
                    newWidth += dx;
                }

                if (event.getY() <= 5) { // Изменение верхнего края
                    newHeight -= dy;
                    newY += dy;
                } else if (event.getY() >= rootPane.getHeight() - 5) { // Изменение нижнего края
                    newHeight += dy;
                }
            }

            primaryStage.setX(newX);
            primaryStage.setY(newY);
            primaryStage.setWidth(newWidth);
            primaryStage.setHeight(newHeight);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}