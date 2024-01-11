package epsilon.handlers;
import static epsilon.Panel.*;

public class H_render_el {

    ////////// move //////////
    public void move_circle(String code) {

        if(code.equals("X")) {
            int x = (int) c_main.slider_x.getValue();
            render_el.circle_parent.setLayoutX(x);
            render_el.circle.lable_x.setText("X = " + x);
        }
        if(code.equals("Y")) {
            int y = (int) c_main.slider_y.getValue();
            render_el.circle_parent.setLayoutY(y);
            render_el.circle.lable_y.setText("Y = " + y);
        }
    }

}