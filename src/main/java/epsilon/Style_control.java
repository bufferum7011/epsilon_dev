package epsilon;
import static epsilon.Panel.print;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;

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
    
    public void add(T t, String style_name) {
        print.debag("1");
        list.add(new Style_control<T, String>(t, style_name));
        print.debag("2");
        // foreach();
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
        Iterator<Style_control<T, String>> iterator = list.iterator();
        while(iterator.hasNext()) {
            Style_control<T, String> i = iterator.next();
            print.way(i.t + "\n");
            print.way(i.style_name + "\n");
            print.way(i.getId() + "\n");
        }
    }
    @Override public ObservableList<Node> getChildren() {
        ObservableList<Node> l = super.getChildren();
        // l.
        return super.getChildren();
    }

}