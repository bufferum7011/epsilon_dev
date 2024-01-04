package epsilon;
import static epsilon.Panel.*;
import static epsilon.Panel.c_main;
import static epsilon.Panel.el;
import static epsilon.Panel.panel;
import static epsilon.Panel.print;
import static epsilon.Panel.render;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Handlers {

    private double x_offset = 0;
    private double y_offset = 0;
    private double HEIGHT;
    private double WIDTH;

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

                edit_cursor(event);
                if(code.equals("PRESSED")) {
                    get_offset();

                }
                else if(code.equals("DRAGGED")) {
                    get_offset();
                    released(event);
                }
                else if(code.equals("RELEASED")) {
                    released(event);
                }

            }
        };
    }
    // Метод определения действия мышки
    public void released(MouseEvent event) {

        print.result("===================\n");
        print.result("x_offset=" + x_offset + "\n");
        print.result("y_offset=" + y_offset + "\n");

        double delta_x = event.getSceneX() - x_offset;
        double delta_y = event.getSceneY() - y_offset;

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


    private void edit_cursor(MouseEvent event) {

        final double RESIZE_MARGIN = 5;
        double x = event.getX();
        double y = event.getY();

        // верх-лево
        if(RESIZE_MARGIN >= x && RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.NW_RESIZE);
        }
        // верх-право!!!
        else if(WIDTH - RESIZE_MARGIN <= x && RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.NE_RESIZE);
        }
        // низ-право
        else if(WIDTH - RESIZE_MARGIN <= x && HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.SE_RESIZE);
        }
        // низ-лево
        else if(RESIZE_MARGIN >= x && HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.SW_RESIZE);
        }
        // верх
        else if(RESIZE_MARGIN >= y) {
            panel.scene.setCursor(Cursor.N_RESIZE);
        }
        // право
        else if(WIDTH - RESIZE_MARGIN <= x) {
            panel.scene.setCursor(Cursor.E_RESIZE);
        }
        // низ
        else if(HEIGHT - RESIZE_MARGIN <= y) {
            panel.scene.setCursor(Cursor.S_RESIZE);
        }
        // лево
        else if(RESIZE_MARGIN >= x) {
            panel.scene.setCursor(Cursor.W_RESIZE);
        }
        // середина
        else {
            panel.scene.setCursor(Cursor.DEFAULT);
        }

    }

}