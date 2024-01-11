package epsilon;
import static epsilon.Panel.print;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Style_control<T, String> extends Pane {

    private Stage stage;
    private T t;
    private String style_name;
    private List<Style_control<T, String>> list = new ArrayList<>();

    private Style_control() {}
    public Style_control(Stage stage) {
        this.stage = stage;
    }
    public Style_control(T t, String style_name) {
        this.t = t;
        this.style_name = style_name;
    }

    public void add() {
        Style_control<T, String> style = new Style_control<>(t, style_name);
        // (Pane) 
        list.add(style);
        foreach();
    }
    public void remove(String style_name) {

        // for(int i = 0; list.iterator().hasNext(); i++) {
        //     if(!style_name.equals(list.iterator().next())) {
        //         list.remove(i);
        //         update();
        //         break;
        //     }
        // }
    }
    private void update() {

        stage.getScene().getStylesheets().clear();

        // while(list.iterator().hasNext()) {
        //     stage.getScene().getStylesheets().add(list.iterator().next());
        // }
    }
    public void foreach() {

        print.debag("=====foreach=\n");
        Iterator<T> iterator = (Iterator<T>) list.iterator();
        while(iterator.hasNext()) {
            print.debag(iterator.next() + "\n");
        }
    }
    @Override public ObservableList<Node> getChildren() {
        ObservableList<Node> l = super.getChildren();
        // l.
        return super.getChildren();
    }

}