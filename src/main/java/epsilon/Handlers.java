package epsilon;
import static epsilon.Panel.*;
import org.springframework.stereotype.Component;
import epsilon.controllers.C_index;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

@Component
public class Handlers {

    // C_greeting
    public EventHandler<MouseEvent> greeting_next() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {

                // Будет проверка, но пока пропуск

                String input_email = c_greeting.input_email.getText();
                String input_password = c_greeting.input_password.getText();

                print.debag(input_email);
                print.debag(input_password);

                panel.stage.setResizable(true);
                new C_index().initialize();
            }
        };
    }


    // C_index
    public EventHandler<MouseEvent> get_hide() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                panel.stage.hide();
            }
        };
    }
    public EventHandler<MouseEvent> get_resize() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                if(panel.key_fullscreen) {
                    panel.key_fullscreen = false;
                    panel.stage.setFullScreen(false);
                }
                else {
                    panel.key_fullscreen = true;
                    panel.stage.setFullScreen(true);
                }
            }
        };
    }
    public EventHandler<MouseEvent> get_clouse() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                try { epsilon.stop(); } catch(Exception e) { }
            }
        };
    }

    // C_main
    public EventHandler<MouseEvent> move_circle(String side, Circle circle) {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {

                if(side.equals("up")) {
                    c_main.y += 10;
                    print.debag("y+10 :: " + c_main.y + "\n");
                    circle.setCenterY(c_main.y);
                }
                if(side.equals("down")) {
                    c_main.y -= 10;
                    print.debag("y-10 :: " + c_main.y + "\n");
                    circle.setCenterY(c_main.y);
                }
                if(side.equals("right")) {
                    c_main.x += 10;
                    print.debag("x+10 :: " + c_main.x + "\n");
                    circle.setCenterX(c_main.x);
                }
                if(side.equals("left")) {
                    c_main.x -= 10;
                    print.debag("x-10 :: " + c_main.x + "\n");
                    circle.setCenterX(c_main.x);
                }

            }
        };
    }


    // C_decart
    public EventHandler<MouseEvent> move_x() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                c_decart.x = (int) c_decart.slider_x.getValue() * 5;
                c_decart.point.setLayoutX(c_decart.x);
                c_decart.val_x.setText("X = " + c_decart.x);
            }
        };
    }
    public EventHandler<MouseEvent> move_y() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                c_decart.y = (int) c_decart.slider_y.getValue() * 5;
                c_decart.point.setLayoutY(c_decart.y);
                c_decart.val_y.setText("Y = " + c_decart.y);
            }
        };
    }
    public ChangeListener<Number> resizer_gred_2d = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            c_decart.grid_2d_size.setText("Grid_2d_size:\nheight = " + c_decart.grid_2d.getHeight() + "\nwidth = " + c_decart.grid_2d.getWidth());
        }
    };

}