package epsilon;
import static epsilon.Panel.print;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class Style_control<T, String> {

    private Stage stage;
    private T t;
    private String style_name;
    private List<Style_control<T, String>> list = new ArrayList<>();

    // private Style_control() {}
    public Style_control(Stage stage) {
        this.stage = stage;
    }
    public Style_control(T t, String style_name) {
        this.t = t;
        this.style_name = style_name;
    }

    public void add(T t, String style_name) {

        // Задача: добавить новый стиль для объекта

        // Создание итератора
        Iterator<Style_control<T, String>> iterator = list.iterator();

        boolean key = true;
        while(key && iterator.hasNext()) {

            // Получение текущего элемента из уже существующего list
            Style_control<T, String> next = iterator.next();

            // Проверка на дубликат
            if(next.t == t) {
                key = false;
                print.error("ЭЛЕМЕНТ УЖЕ СУЩЕСТВУЕТ\n");
            }
        }

        if(key) {
            list.add(new Style_control<T, String>(t, style_name));
            update();
        }

    }
    private void update() {

        // Задача: удалить стили и заполнить заново используя их обновленный список

        // Создание итератора
        Iterator<Style_control<T, String>> iterator = list.iterator();

        // Очистка стилей
        for(int i = 0; iterator.hasNext(); i++) {

            try {
                iterator.next();
                print.debag(i + "\t");
                stage.getScene().getStylesheets().remove(i);
                print.debag(i + "\t");
            }
            catch(Exception e) {
                print.error(i + "\t");
            }
        }

        // Перезаполнение стилей
        iterator = list.iterator();

        print.debag("\nПерезаполнение стилей\n");
        for(int i = 0; i < list.size(); i++) {
            
            // Получение текущего элемента из уже существующего list
            Style_control<T, String> next = iterator.next();
            print.debag(i + "\t");
            try {
                ((Parent) next.t).getStylesheets().add((java.lang.String) next.style_name);
            }
            catch (Exception e) {
                print.error("Перезаполнение стилей\n");
            }

        }

        boolean key = true;
        if(key) {
            list.add(new Style_control<T, String>(t, style_name));
            update();
        }
    }
    public void remove(String style_name) {

    }
    public void foreach() {

        print.debag("=====foreach=\n");
        Iterator<Style_control<T, String>> iterator = list.iterator();
        for(int i = 0; iterator.hasNext(); i++) {

            Style_control<T, String> next = iterator.next();
            print.way(next.t + "\n");
            print.way(next.style_name + "\n");
            print.way(i + "\n");
        }
    }

}