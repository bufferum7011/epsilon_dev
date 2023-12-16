package epsilon.controllers;
import static epsilon.Panel.*;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class C_greeting implements Default_controller {

    @Override public void fxml() throws IOException { new C_main().get_scene("greeting"); }
    @Override public void initialize() {

        Text title = new Text("Добро пожаловать в Epsilon");
        TextField input_email = new TextField("Почта");
        TextField input_password = new TextField("Пароль");
        Hyperlink forgot_password = new Hyperlink("Забыл пароль");
        Hyperlink registration = new Hyperlink("Зарегистрироватся");
        Button btn_enter = new Button("Войти");

        btn_enter.setOnMousePressed(handlers.greeting_next());

        VBox vBox = new VBox(title, input_email, input_password, forgot_password, registration, btn_enter);
        vBox.getStyleClass().add("greeting");

        panel.scene = new Scene(vBox);
        panel.default_settings();

        {
            panel.stage.setHeight(500);
            panel.stage.setWidth(350);
            panel.stage.setResizable(false);
        }

        panel.stage.show();
    }

}