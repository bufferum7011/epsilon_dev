package epsilon.handlers;
import static epsilon.Panel.c_main;
import static epsilon.Panel.panel;
import static epsilon.Panel.style_control;

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

            // style_control.remove("c_main");
            // style_control.add("c_main_opacity");
            // c_main.box_title.setOpacity(1);
            // mouse_event_x = event.getSceneX();
            // mouse_event_y = event.getSceneY();
        }
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_DRAGGED)) {

            // style_control.remove("c_main");
            // style_control.add("c_main_opacity");

            // panel.scene.getStylesheets().add("c_main_opacity");
            // c_main.box_title.setOpacity(1);
            // panel.stage.setX(event.getScreenX() - mouse_event_x);
            // panel.stage.setY(event.getScreenY() - mouse_event_y);

            // Максимизация окна при перемещении к верхней границе экрана
            // if(panel.stage.getY() <= 0) { panel.stage.setMaximized(true); }
        }
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_RELEASED)) {
            // style_control.remove("c_main_opacity");
            // style_control.add("c_main");
            // c_main.box_title.setOpacity(1);
            // style_control.foreach();
        }
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_EXITED)) {
            // style_control.remove("c_main_opacity");
            // style_control.add("c_main");
            // c_main.box_title.setOpacity(1);
        }

    }

}