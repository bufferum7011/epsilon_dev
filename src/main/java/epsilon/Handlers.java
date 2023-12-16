package epsilon;
import static epsilon.Panel.*;
import epsilon.controllers.C_index;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Handlers {

    // Greeting
    public EventHandler<MouseEvent> greeting_next() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent arg0) {
                
                // Будет проверка, но пока пропуск

                panel.stage.setResizable(true);
                new C_index().initialize();
            }
        };
    }


    // Index
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

}