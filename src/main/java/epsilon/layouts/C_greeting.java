package epsilon.layouts;
import static epsilon.Panel.btns;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class C_greeting extends Default_layouts {

    public TextField input_email;
    public TextField input_password;
    public Hyperlink forgot_password;
    public Hyperlink registration;
    public Button btn_enter;
    public VBox root;

    @Override public void set_scene(Scene scene) { super.set_scene(scene); }

    @Override public void execute_before(Stage stage) {

        root = new VBox();
        set_scene(new Scene(root));

        stage.setHeight(600);
        stage.setWidth(1000);
        super.execute_before(stage);
    }
    @Override public void initialize(Stage stage) {

        Text title = new Text("Добро пожаловать в Epsilon");
        input_email = new TextField("Почта");
        input_password = new TextField("Пароль");
        forgot_password = new Hyperlink("Забыл пароль");
        registration = new Hyperlink("Зарегистрироватся");

        btn_enter = new Button("Войти");
        btn_enter.setOnAction(e -> btns.btn_next(e));

        root.getChildren().addAll(title, input_email, input_password, forgot_password, registration, btn_enter);
    }
    @Override public void execute_after(Stage stage) {
        super.execute_after(stage);
    }

}