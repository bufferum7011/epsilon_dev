package epsilon.handlers;
import static epsilon.Panel.*;
import epsilon.Render;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class H_resize_win {

    private double HEIGHT;
    private double WIDTH;
    private double x_offset = 0;
    private double y_offset = 0;
    private double delta_x = 0;
    private double delta_y = 0;
    private double x = 0;
    private double y = 0;

    ////////// btn //////////
    public void win_resize(ActionEvent event) {
        if(panel.stage.isMaximized()) { panel.stage.setMaximized(false); }
        else { panel.stage.setMaximized(true); }
    }
    public void win_hide(ActionEvent event) { panel.stage.setIconified(true); }
    public void win_clouse(ActionEvent event) { panel.stage.close(); }

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
        x = event.getX();
        y = event.getY();
        if(indicator % 10 == 0) { print.debag("x:" + x + "=====y:" + y + "\n"); }


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

        final double RESIZE_MARGIN = 3;
        // if(required_stretch) { print.result("===================\n"); }
        // print.result("x_offset=" + x_offset + "\n");
        // print.result("y_offset=" + y_offset + "\n");

        // верх-лево
        if(RESIZE_MARGIN >= x && RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.NW_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // верх-право
        else if(WIDTH - RESIZE_MARGIN <= x && RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.NE_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // низ-право
        else if(WIDTH - RESIZE_MARGIN <= x && HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.SE_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // низ-лево
        else if(RESIZE_MARGIN >= x && HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.SW_RESIZE);
            if(required_stretch) { stretch_horizontal(); stretch_vertical(); }
        }
        // верх
        else if(RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.N_RESIZE);
            if(required_stretch) { stretch_vertical(); }
        }
        // право
        else if(WIDTH - RESIZE_MARGIN <= x) {
            panel.scene.setCursor(Cursor.E_RESIZE);
            if(required_stretch) { stretch_horizontal(); }
        }
        // низ
        else if(HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.S_RESIZE);
            if(required_stretch) { stretch_vertical(); }
        }
        // лево
        else if(RESIZE_MARGIN >= x) {
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


    ////////// listeners - перетаскивание //////////
    public void render_win_resize(Number newValue) {
        render = new Render(c_main.box_center.getHeight(), c_main.box_center.getWidth());
        render.create_grid_2d();
    }

}