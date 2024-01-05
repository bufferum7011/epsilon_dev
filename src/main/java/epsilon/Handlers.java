package epsilon;
import static epsilon.Panel.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Handlers {

    private double HEIGHT;
    private double WIDTH;
    private double x_offset = 0;
    private double y_offset = 0;
    private double delta_x = 0;
    private double delta_y = 0;
    private double x = 0;
    private double y = 0;

    ////////// Greeting //////////
    ////////// btn //////////
    public EventHandler<MouseEvent> greeting_next() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {

                // Будет проверка, но пока пропуск
                String input_email = c_greeting.input_email.getText();
                String input_password = c_greeting.input_password.getText();

                print.debag(input_email);
                print.debag(input_password);

                panel.stage.setResizable(true);
                c_main.initialize();
            }
        };
    }

    ////////// Elements //////////
    ////////// move //////////
    public EventHandler<MouseEvent> move_circle(String code) {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if(code.equals("X")) {
                    int x = (int) c_main.slider_x.getValue() * 5;
                    el.circle_parent.setLayoutX(x);
                    el.circle.lable_x.setText("X = " + x);
                }
                if(code.equals("Y")) {
                    int y = (int) c_main.slider_y.getValue() * 5;
                    el.circle_parent.setLayoutY(y);
                    el.circle.lable_y.setText("Y = " + y);
                }
            }
        };
    }


    ////////// Render //////////
    ///////// box_center resizer - изм. размера box_center /////////
    public ChangeListener<Number> render_win_resizer = new ChangeListener<Number>() {

        @Override public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            render = new Render(c_main.box_center.getHeight(), c_main.box_center.getWidth());
            render.create_grid_2d();
        }
    };


    ////////// box_title //////////
    ////////// btn //////////
    public EventHandler<ActionEvent> win_hide() {

        return new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                panel.stage.setIconified(true);
            }
        };
    }
    public EventHandler<ActionEvent> win_resize() {

        return new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                if(panel.stage.isMaximized()) { panel.stage.setMaximized(false); }
                else { panel.stage.setMaximized(true); }
            }
        };
    }
    public EventHandler<ActionEvent> win_clouse() {

        return new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) { panel.stage.close(); }
        };
    }
    ////////// offset - перетаскивание //////////
    public EventHandler<MouseEvent> get_offset() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                x_offset = event.getSceneX();
                y_offset = event.getSceneY();
            }
        };
    }
    public EventHandler<MouseEvent> set_offset() {

        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                panel.stage.setX(event.getScreenX() - x_offset);
                panel.stage.setY(event.getScreenY() - y_offset);

                // Максимизация окна при перемещении к верхней границе экрана
                // if(panel.stage.getY() <= 0) { panel.stage.setMaximized(true); }
            }
        };
    }


    ////////// root //////////
    ////////// stretch - растягивание //////////
    public EventHandler<MouseEvent> win_stretch(String code) {
        
        return new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {

                HEIGHT = panel.stage.getHeight();
                WIDTH = panel.stage.getWidth();
                delta_x = event.getSceneX() - x_offset;
                delta_y = event.getSceneY() - y_offset;
                x = event.getX();
                y = event.getY();

                if(code.equals("MOVED")) {
                    edit_cursor(event, false);
                    print.debag("MOVED\n");
                }
                if(code.equals("PRESSED")) {
                    edit_cursor(event, false);
                    print.error("PRESSED\n");
                }
                if(code.equals("DRAGGED")) {
                    edit_cursor(event, true);
                    print.way("DRAGGED\n");
                }
                // if(code.equals("RELEASED")) {
                //     // get_offset();
                //     released(event);
                // }

            }
        };
    }

    private void edit_cursor(MouseEvent event, boolean required_stretch) {

        final double RESIZE_MARGIN = 5;
        get_offset();
        // print.result("===================\n");
        // print.result("x_offset=" + x_offset + "\n");
        // print.result("y_offset=" + y_offset + "\n");

        // верх-лево
        if(RESIZE_MARGIN >= x && RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.NW_RESIZE);
            if(required_stretch) { stretch_horizontal_vertical(); }
        }
        // верх-право
        else if(WIDTH - RESIZE_MARGIN <= x && RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.NE_RESIZE);
            if(required_stretch) { stretch_horizontal_vertical(); }
        }
        // низ-право
        else if(WIDTH - RESIZE_MARGIN <= x && HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.SE_RESIZE);
            if(required_stretch) { stretch_horizontal_vertical(); }
        }
        // низ-лево
        else if(RESIZE_MARGIN >= x && HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.SW_RESIZE);
            if(required_stretch) { stretch_horizontal_vertical(); }
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

    public void stretch_horizontal_vertical() {

        if(delta_x > 0) {
            panel.stage.setWidth(WIDTH + x_offset);
            print.result("Width++\n");
        }
        else {
            panel.stage.setWidth(WIDTH - x_offset);
            print.result("Width--\n");
        }

        if(delta_y > 0) {
            panel.stage.setHeight(HEIGHT + y_offset);
            print.result("Height++\n");
        }
        else {
            panel.stage.setHeight(HEIGHT - y_offset);
            print.result("Height--\n");
        }

    }
    private void stretch_horizontal() {

        if(delta_x > 0) {
            panel.stage.setWidth(WIDTH + x_offset);
            print.result("Width++\n");
        }
        else {
            panel.stage.setWidth(WIDTH - x_offset);
            print.result("Width--\n");
        }

    }
    private void stretch_vertical() {

        if(delta_y > 0) {
            panel.stage.setHeight(HEIGHT + y_offset);
            print.result("Height++\n");
        }
        else {
            panel.stage.setHeight(HEIGHT - y_offset);
            print.result("Height--\n");
        }

    }

}