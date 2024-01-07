package epsilon.handlers;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Resize implements EventHandler<MouseEvent> {

    private Stage stage;
    private Scene scene;
    private Cursor cursor_event;
    private double BORDER = 4;
    private double HEIGHT;
    private double WIDTH;
    private double delta_x = 0;
    private double delta_y = 0;
    private double mouse_event_x;
    private double mouse_event_y;

    public Resize(Stage stage) {
        this.stage = stage;
        scene = stage.getScene();
    }

    @Override public void handle(MouseEvent event) {

        EventType<? extends MouseEvent> mouse_event_type = event.getEventType();

        // offset.allow = false;

        mouse_event_x = event.getSceneX();
        mouse_event_y = event.getSceneY();
        HEIGHT = stage.getHeight();
        WIDTH = stage.getWidth();

        if(mouse_event_type.equals(MouseEvent.MOUSE_MOVED)) { edit_cursor(); }
        else if(mouse_event_type.equals(MouseEvent.MOUSE_PRESSED)) {
            delta_x = WIDTH - mouse_event_x;
            delta_y = HEIGHT - mouse_event_y;
        }
        else if(mouse_event_type.equals(MouseEvent.MOUSE_DRAGGED)) {

            // Блоки if - блокирует resizing без подходящего курсора
            if(!cursor_event.equals(Cursor.DEFAULT)) {
                if(!cursor_event.equals(Cursor.W_RESIZE) && !cursor_event.equals(Cursor.E_RESIZE)) {

                    double min_height = stage.getMinHeight() > (BORDER * 2) ? stage.getMinHeight() : (BORDER * 2);

                    if(cursor_event.equals(Cursor.NW_RESIZE) || cursor_event.equals(Cursor.N_RESIZE) || cursor_event.equals(Cursor.NE_RESIZE)) {
                        if(HEIGHT > min_height || mouse_event_y < 0) {
                            stage.setHeight(stage.getY() - event.getScreenY() + HEIGHT);
                            stage.setY(event.getScreenY());
                        }
                    }
                    else {
                        if(HEIGHT > min_height || mouse_event_y + delta_y - HEIGHT > 0) {
                            stage.setHeight(mouse_event_y + delta_y);
                        }
                    }
                }

                if(!cursor_event.equals(Cursor.N_RESIZE) && !cursor_event.equals(Cursor.S_RESIZE)) {

                    double min_width = stage.getMinWidth() > (BORDER * 2) ? stage.getMinWidth() : (BORDER * 2);

                    if(cursor_event.equals(Cursor.NW_RESIZE) || cursor_event.equals(Cursor.W_RESIZE) || cursor_event.equals(Cursor.SW_RESIZE)) {
                        if(WIDTH > min_width || mouse_event_x < 0) {
                            stage.setWidth(stage.getX() - event.getScreenX() + WIDTH);
                            stage.setX(event.getScreenX());
                        }
                    }
                    else {
                        if(WIDTH > min_width || mouse_event_x + delta_x - WIDTH > 0) {
                            stage.setWidth(mouse_event_x + delta_x);
                        }
                    }
                }
            }
        }
        else {
            scene.setCursor(Cursor.DEFAULT);
            // offset.allow = true;
        }
    }

    private void edit_cursor() {

        // верх-лево
        if(BORDER >= mouse_event_x && BORDER >= mouse_event_y) {
            scene.setCursor(Cursor.NW_RESIZE);
        }
        // верх-право
        else if(WIDTH - BORDER <= mouse_event_x && BORDER >= mouse_event_y) {
            scene.setCursor(Cursor.NE_RESIZE);
        }
        // низ-право
        else if(WIDTH - BORDER <= mouse_event_x && HEIGHT - BORDER <= mouse_event_y) {
            scene.setCursor(Cursor.SE_RESIZE);
        }
        // низ-лево
        else if(BORDER >= mouse_event_x && HEIGHT - BORDER <= mouse_event_y) {
            scene.setCursor(Cursor.SW_RESIZE);
        }
        // верх
        else if(BORDER >= mouse_event_y) {
            scene.setCursor(Cursor.N_RESIZE);
        }
        // право
        else if(WIDTH - BORDER <= mouse_event_x) {
            scene.setCursor(Cursor.E_RESIZE);
        }
        // низ
        else if(HEIGHT - BORDER <= mouse_event_y) {
            scene.setCursor(Cursor.S_RESIZE);
        }
        // лево
        else if(BORDER >= mouse_event_x) {
            scene.setCursor(Cursor.W_RESIZE);
        }
        // середина
        else {
            scene.setCursor(Cursor.DEFAULT);
        }

        cursor_event = scene.getCursor();

    }
    
}