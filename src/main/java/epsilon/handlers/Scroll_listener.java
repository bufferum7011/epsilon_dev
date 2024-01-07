package epsilon.handlers;
import static epsilon.Panel.render;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

public class Scroll_listener implements EventHandler<ScrollEvent> {

    private final double MIN_SCALE = 0.1;
    private final double MAX_SCALE = 10.0;
    private final double SCALE_DELTA = 1.1;

    @Override public void handle(ScrollEvent event) {
        double scaleFactor = (event.getDeltaY() > 0) ? SCALE_DELTA : 1 / SCALE_DELTA;

        // Ограничение масштабирования до определенных границ
        double currentScale = render.box_center_scale.getX();
        if(currentScale * scaleFactor < MIN_SCALE || currentScale * scaleFactor > MAX_SCALE) {
            return;
        }

        render.box_center_scale.setPivotX(event.getX());
        render.box_center_scale.setPivotY(event.getY());
        render.box_center_scale.setX(render.box_center_scale.getX() * scaleFactor);
        render.box_center_scale.setY(render.box_center_scale.getY() * scaleFactor);        
    }
    
}