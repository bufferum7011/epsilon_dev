package epsilon;
import static epsilon.Panel.*;
import epsilon.controllers.C_main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

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
                new C_main().initialize();
            }
        };
    }


    // title
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
                // try { panel.stop(); } catch(Exception e) { }
            }
        };
    }

    // cicle
    public EventHandler<MouseEvent> move_x() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                c_main.x = (int) c_main.slider_x.getValue() * 5;
                el.point.setLayoutX(c_main.x);
                el.val_x.setText("X = " + c_main.x);
            }
        };
    }
    public EventHandler<MouseEvent> move_y() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                c_main.y = (int) c_main.slider_y.getValue() * 5;
                el.point.setLayoutY(c_main.y);
                el.val_y.setText("Y = " + c_main.y);
            }
        };
    }

    // c_main
    public ChangeListener<Number> set_zero_position = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            grid_2d = new Grid_2d(c_main.pane_grid_2d.getHeight(), c_main.pane_grid_2d.getWidth());
        }
    };

}