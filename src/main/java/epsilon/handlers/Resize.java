package epsilon.handlers;
import static epsilon.Panel.*;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Resize implements EventHandler<MouseEvent> {

    private Stage stage;
    private Cursor cursorEvent = Cursor.DEFAULT;
    private int border = 3;
    private double startX = 0;
    private double startY = 0;

    public Resize(Stage stage) { this.stage = stage; }

    @Override public void handle(MouseEvent event) {

        print.debag("Resize\n");
        EventType<? extends MouseEvent> mouseEventType = event.getEventType();
        Scene scene = stage.getScene();

        // offset.allow = false;

        double mouseEventX = event.getSceneX();
        double mouseEventY = event.getSceneY();
        double sceneWidth = scene.getWidth();
        double sceneHeight = scene.getHeight();

        if(MouseEvent.MOUSE_MOVED.equals(mouseEventType)) {
            if(mouseEventX < border && mouseEventY < border) {
                cursorEvent = Cursor.NW_RESIZE;
            }
            else if(mouseEventX < border && mouseEventY > sceneHeight - border) {
                cursorEvent = Cursor.SW_RESIZE;
            }
            else if(mouseEventX > sceneWidth - border && mouseEventY < border) {
                cursorEvent = Cursor.NE_RESIZE;
            }
            else if(mouseEventX > sceneWidth - border && mouseEventY > sceneHeight - border) {
                cursorEvent = Cursor.SE_RESIZE;
            }
            else if(mouseEventX < border) {
                cursorEvent = Cursor.W_RESIZE;
            }
            else if(mouseEventX > sceneWidth - border) {
                cursorEvent = Cursor.E_RESIZE;
            }
            else if(mouseEventY < border) {
                cursorEvent = Cursor.N_RESIZE;
            }
            else if(mouseEventY > sceneHeight - border) {
                cursorEvent = Cursor.S_RESIZE;
            }
            else {
                cursorEvent = Cursor.DEFAULT;
            }

            scene.setCursor(cursorEvent);
        }
        else if(MouseEvent.MOUSE_PRESSED.equals(mouseEventType)) {
            startX = stage.getWidth() - mouseEventX;
            startY = stage.getHeight() - mouseEventY;
        }
        else if(MouseEvent.MOUSE_DRAGGED.equals(mouseEventType)) {
            if(!Cursor.DEFAULT.equals(cursorEvent)) {
                if(!Cursor.W_RESIZE.equals(cursorEvent) && !Cursor.E_RESIZE.equals(cursorEvent)) {

                    double minHeight = stage.getMinHeight() > (border * 2) ? stage.getMinHeight() : (border * 2);

                    if(Cursor.NW_RESIZE.equals(cursorEvent) || Cursor.N_RESIZE.equals(cursorEvent) || Cursor.NE_RESIZE.equals(cursorEvent)) {
                        if(stage.getHeight() > minHeight || mouseEventY < 0) {
                            stage.setHeight(stage.getY() - event.getScreenY() + stage.getHeight());
                            stage.setY(event.getScreenY());
                        }
                    }
                    else {
                        if(stage.getHeight() > minHeight || mouseEventY + startY - stage.getHeight() > 0) {
                            stage.setHeight(mouseEventY + startY);
                        }
                    }
                }

                if(!Cursor.N_RESIZE.equals(cursorEvent) && !Cursor.S_RESIZE.equals(cursorEvent)) {

                    double minWidth = stage.getMinWidth() > (border * 2) ? stage.getMinWidth() : (border * 2);

                    if(Cursor.NW_RESIZE.equals(cursorEvent) || Cursor.W_RESIZE.equals(cursorEvent) || Cursor.SW_RESIZE.equals(cursorEvent)) {
                        if(stage.getWidth() > minWidth || mouseEventX < 0) {
                            stage.setWidth(stage.getX() - event.getScreenX() + stage.getWidth());
                            stage.setX(event.getScreenX());
                        }
                    }
                    else {
                        if(stage.getWidth() > minWidth || mouseEventX + startX - stage.getWidth() > 0) {
                            stage.setWidth(mouseEventX + startX);
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
    
}