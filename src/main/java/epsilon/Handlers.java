package epsilon;
import static epsilon.Panel.*;

import java.awt.Color;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Handlers {

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

}