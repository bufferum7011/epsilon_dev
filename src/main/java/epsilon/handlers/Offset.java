package epsilon.handlers;
import static epsilon.Panel.*;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

public class Offset implements EventHandler<MouseEvent> {

    private double HEIGHT;
    private double WIDTH;
    private double x_offset = 0;
    private double y_offset = 0;
    private double delta_x = 0;
    private double delta_y = 0;
    private double mouseEventX = 0;
    private double mouseEventY = 0;

    public boolean allow = true;

    @Override public void handle(MouseEvent event) {
        print.debag("offset\n");
        EventType<? extends MouseEvent> mouse_event_type = event.getEventType();
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_PRESSED)) { get_offset(event); }
        if(allow && mouse_event_type.equals(MouseEvent.MOUSE_DRAGGED)) { set_offset(event); }

    }

    ////////// offset - перетаскивание //////////
    public void get_offset(MouseEvent event) {
        x_offset = event.getSceneX();
        y_offset = event.getSceneY();
    }
    public void set_offset(MouseEvent event) {

        panel.stage.setX(event.getScreenX() - x_offset);
        panel.stage.setY(event.getScreenY() - y_offset);

        // Максимизация окна при перемещении к верхней границе экрана
        // if(panel.stage.getY() <= 0) { panel.stage.setMaximized(true); }
    }

    ////////// stretch - растягивание //////////
    private int indicator = 0;
    public void win_stretch(MouseEvent event, String code) {

        indicator++;
        HEIGHT = panel.stage.getHeight();
        WIDTH = panel.stage.getWidth();
        mouseEventX = event.getX();
        mouseEventY = event.getY();
        if(indicator % 10 == 0) { print.debag("x:" + mouseEventX + "=====y:" + mouseEventY + "\n"); }


        if(code.equals("MOVED")) {
            edit_cursor(event, false);
        }
        if(code.equals("PRESSED")) {
            x_offset = event.getSceneX();
            y_offset = event.getSceneY();
            edit_cursor(event, false);
        }
        if(code.equals("DRAGGED")) {
            delta_x = event.getSceneX() - x_offset;
            print.debag(event.getSceneX() + "=" + x_offset + "\n");
            delta_y = event.getSceneY() - y_offset;
            edit_cursor(event, true);
        }
        if(code.equals("RELEASED")) {
            delta_x = event.getSceneX() - x_offset;
            delta_y = event.getSceneY() - y_offset;
            edit_cursor(event, true);
        }
    }
    private void edit_cursor(MouseEvent event, boolean required_stretch) {

        final double BORDER = 3;

        // верх-лево
        if(BORDER >= mouseEventX && BORDER >= mouseEventY) {
            panel.scene.setCursor(Cursor.NW_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // верх-право
        else if(WIDTH - BORDER <= mouseEventX && BORDER >= mouseEventY) {
            panel.scene.setCursor(Cursor.NE_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // низ-право
        else if(WIDTH - BORDER <= mouseEventX && HEIGHT - BORDER <= mouseEventY) {
            panel.scene.setCursor(Cursor.SE_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // низ-лево
        else if(BORDER >= mouseEventX && HEIGHT - BORDER <= mouseEventY) {
            panel.scene.setCursor(Cursor.SW_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // верх
        else if(BORDER >= mouseEventY) {
            panel.scene.setCursor(Cursor.N_RESIZE);
            if(required_stretch) { stretch_vertical(); }
        }
        // право
        else if(WIDTH - BORDER <= mouseEventX) {
            panel.scene.setCursor(Cursor.E_RESIZE);
            if(required_stretch) { stretch_horizontal(); }
        }
        // низ
        else if(HEIGHT - BORDER <= mouseEventY) {
            panel.scene.setCursor(Cursor.S_RESIZE);
            if(required_stretch) { stretch_vertical(); }
        }
        // лево
        else if(BORDER >= mouseEventX) {
            panel.scene.setCursor(Cursor.W_RESIZE);
            if(required_stretch) { stretch_horizontal(); }
        }
        // середина
        else {
            panel.scene.setCursor(Cursor.DEFAULT);
        }

    }

    private void stretch_horizontal() {

        if(delta_x > 0) {
            panel.stage.setWidth(WIDTH - x_offset);
            print.result("stretch_horizontal=Width--\n");
        }
        else {
            panel.stage.setWidth(WIDTH + x_offset);
            print.result("stretch_horizontal=Width++\n");
        }

    }
    private void stretch_vertical() {

        if(delta_y > 0) {
            panel.stage.setHeight(HEIGHT - y_offset);
            print.result("stretch_vertical=Height--\n");
        }
        else {
            panel.stage.setHeight(HEIGHT + y_offset);
            print.result("stretch_vertical=Height++\n");
        }

    }
}