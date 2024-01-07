package epsilon.handlers;
import static epsilon.Panel.panel;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class Offset implements EventHandler<MouseEvent> {

    public boolean allow = true;
    private double mouse_event_x = 0;
    private double mouse_event_y = 0;

    @Override public void handle(MouseEvent event) {

        EventType<? extends MouseEvent> mouse_event_type = event.getEventType();
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_PRESSED)) {

            panel.stage.setOpacity(0.85);
            mouse_event_x = event.getSceneX();
            mouse_event_y = event.getSceneY();
        }
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_DRAGGED)) {

            panel.stage.setOpacity(0.85);
            panel.stage.setX(event.getScreenX() - mouse_event_x);
            panel.stage.setY(event.getScreenY() - mouse_event_y);

            // Максимизация окна при перемещении к верхней границе экрана
            // if(panel.stage.getY() <= 0) { panel.stage.setMaximized(true); }
        }
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_RELEASED)) {
            panel.stage.setOpacity(1);
        }
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_EXITED)) {
            panel.stage.setOpacity(1);
        }

    }

}