package epsilon.layouts;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class C_greeting extends Default_layouts {

    public TextField input_email;
    public TextField input_password;
    public Hyperlink forgot_password;
    public Hyperlink registration;
    public Button btn_enter;

    @Override public void default_settings() {
        // panel.scene = new Scene(vBox);
        super.default_settings();
        // panel.stage.setHeight(500);
        // panel.stage.setWidth(350);
        // panel.stage.setResizable(false);
        // panel.stage.show();
    }

    @Override public void initialize() {

        // VBox vBox = new VBox(); {
        //     Text title = new Text("Добро пожаловать в Epsilon");
        //     input_email = new TextField("Почта");
        //     input_password = new TextField("Пароль");
        //     forgot_password = new Hyperlink("Забыл пароль");
        //     registration = new Hyperlink("Зарегистрироватся");
        //     btn_enter = new Button("Войти");

        //     btn_enter.setOnMousePressed(handlers.greeting_next());

        //     vBox.getChildren().addAll(title, input_email, input_password, forgot_password, registration, btn_enter);
        //     vBox.getStyleClass().add("greeting");
        // }

        default_settings();
    }    

}