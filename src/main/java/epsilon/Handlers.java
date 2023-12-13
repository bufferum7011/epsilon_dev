package epsilon;
import static epsilon.Panel.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Handlers {

    public EventHandler<MouseEvent> get_hide() {
        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                panel.stage.hide();
            }
        };
    }
    public EventHandler<MouseEvent> get_resize() {
        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
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

            @Override
            public void handle(MouseEvent arg0) {
                panel.stage.close();
            }
        };
    }

}