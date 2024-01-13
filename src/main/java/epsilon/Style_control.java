package epsilon;
import static epsilon.Panel.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Style_control {

    private Stage stage;
    private Object o;
    private String style_name;
    private List<Style_control> list = new ArrayList<>();

    public Style_control(Stage stage) {
        this.stage = stage;
    }
    public Style_control(Object o, String style_name) {
        this.o = o;
        this.style_name = style_name;
    }

    public void add(Object o, String style_name) {
        this.o = o;
        this.style_name = style_name;

        Iterator<Style_control> iterator = list.iterator();

        boolean key = true;
        while(key && iterator.hasNext()) {

            Style_control next = iterator.next();

            if(next.o == o) {
                key = false;
                print.error("\nЭЛЕМЕНТ УЖЕ СУЩЕСТВУЕТ\n");
            }
        }

        if(key) {
            list.add(new Style_control(o, style_name));
            update();
        }

    }
    private void update() {

        Iterator<Style_control> iterator = list.iterator();

        while(iterator.hasNext()) {

            Style_control next = iterator.next();
            try {
                stage.getScene().getStylesheets().clear();
            }
            catch(Exception e) { print.error("\n_ERROR_\n"); }
        }

        iterator = list.iterator();
        for(int i = 0; i < list.size(); i++) {

            Style_control next = iterator.next();

            try {
                ((Parent) next.o).getStylesheets().add(panel.css);
                ((Parent) next.o).getStyleClass().add(style_name);
            }
            catch(Exception e) { print.error("\n_Перезаполнение_стилей_\n"); }

        }


    }
    public void remove(Object o) {
        this.o = o;

        // Задача: нужно удалить элемент.
        // Мне известен объект. Могу сравнвать его с 
    }
    public void foreach() {

        print.debag("=====foreach=\n");
        Iterator<Style_control> iterator = list.iterator();
        for(int i = 0; iterator.hasNext(); i++) {
            print.result("=============\n");
            Style_control next = iterator.next();
            print.way(next.style_name + "\n");
            for(int i2 = 0; i2 < ((Parent) next.o).getStyleClass().size(); i2++) {
                print.way("\t+++" + ((Parent) next.o).getStyleClass().get(i2) + "\n");
            }
            print.way(i + "\n");
        }
    }

}