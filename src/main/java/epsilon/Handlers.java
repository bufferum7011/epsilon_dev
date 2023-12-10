package epsilon;

import static epsilon.Panel.panel;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Handlers {

    

    public EventHandler<MouseEvent> get_clouse() {
        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                panel.stage.close();
            }
        };
    }

}