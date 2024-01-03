package epsilon;
import static epsilon.Panel.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Handlers {

    ////////// Greeting //////////
    public EventHandler<MouseEvent> greeting_next() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {

                // Будет проверка, но пока пропуск
                String input_email = c_greeting.input_email.getText();
                String input_password = c_greeting.input_password.getText();

                print.debag(input_email);
                print.debag(input_password);

                panel.stage.setResizable(true);
                c_main.initialize();
            }
        };
    }

    ////////// C_main decorations //////////
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
                try { panel.stop(); } catch(Exception e) { }
            }
        };
    }

    ////////// Elements //////////
    public EventHandler<MouseEvent> move_circle(String code) {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                if(code.equals("X")) {
                    int x = (int) c_main.slider_x.getValue() * 5;
                    el.circle_parent.setLayoutX(x);
                    el.circle.lable_x.setText("X = " + x);
                }
                if(code.equals("Y")) {
                    int y = (int) c_main.slider_y.getValue() * 5;
                    el.circle_parent.setLayoutY(y);
                    el.circle.lable_y.setText("Y = " + y);
                }
            }
        };
    }

    ////////// Render //////////
    public ChangeListener<Number> render_win_resizer = new ChangeListener<Number>() {

        @Override public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            render = new Render(c_main.box_center.getHeight(), c_main.box_center.getWidth());
            render.create_grid_2d();
        }
    };

}