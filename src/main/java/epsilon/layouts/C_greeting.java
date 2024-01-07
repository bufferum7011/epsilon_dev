package epsilon.layouts;
import static epsilon.Panel.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class C_greeting extends Default_layouts {

    public TextField input_email;
    public TextField input_password;
    public Hyperlink forgot_password;
    public Hyperlink registration;
    public Button btn_enter;
    public VBox root;

    @Override public void default_settings() {
        panel.scene = new Scene(root);
        super.default_settings();
        panel.stage.setHeight(500);
        panel.stage.setWidth(350);
        panel.stage.setResizable(false);
        panel.stage.show();
    }
    @Override public void initialize() {

        root = new VBox(); {
            Text title = new Text("Добро пожаловать в Epsilon");
            input_email = new TextField("Почта");
            input_password = new TextField("Пароль");
            forgot_password = new Hyperlink("Забыл пароль");
            registration = new Hyperlink("Зарегистрироватся");
            
            btn_enter = new Button("Войти");
            btn_enter.setOnAction(e -> btns.btn_next(e));

            root.getChildren().addAll(title, input_email, input_password, forgot_password, registration, btn_enter);
        }

        default_settings();
    }    

}