package epsilon.handlers;
import static epsilon.Panel.*;
import epsilon.Render;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Centering implements ChangeListener<Number> {

    @Override public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
        render.create_grid_2d();
    }

}