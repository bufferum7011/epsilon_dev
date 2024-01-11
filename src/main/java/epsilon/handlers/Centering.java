package epsilon.handlers;
import static epsilon.Panel.c_main;
import static epsilon.Panel.panel;
import static epsilon.Panel.render;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Centering implements ChangeListener<Number> {

    @Override public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
        render.create_grid_2d();

        // Line line = new Line(0, 0, panel.stage.getWidth(), 0);
        // line.setStroke(Color.WHITE);
        // line.setStrokeWidth(1);
        // c_main.box_title.getChildren().remove(1);
        // c_main.box_title.getChildren().add(line);
    }

}