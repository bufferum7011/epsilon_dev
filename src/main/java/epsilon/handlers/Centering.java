package epsilon.handlers;
import static epsilon.Panel.*;
import epsilon.Render;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Centering implements ChangeListener<Number> {

    @Override public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
        render = new Render(c_main.box_center.getHeight(), c_main.box_center.getWidth());
        render.create_grid_2d();
    }

}