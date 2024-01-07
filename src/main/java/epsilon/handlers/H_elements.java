package epsilon.handlers;
import static epsilon.Panel.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class H_elements {

    ////////// move //////////
    public void move_circle(MouseEvent event, String code) {

        if(code.equals("X")) {
            int x = (int) c_main.slider_x.getValue() * 5;
            el.circle_parent.setLayoutX(x);
            el.circle.lable_x.setText("X = " + x);
        }
        if(code.equals("Y")) {
            int y = (int) c_main.slider_y.getValue() * 5;
            el.circle_parent.setLayoutY(y);
            // el.circle.lable_y.setText("Y = " + y);
        }
    }

}