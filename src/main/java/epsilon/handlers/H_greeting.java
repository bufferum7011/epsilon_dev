package epsilon.handlers;
import static epsilon.Panel.*;
import javafx.scene.input.MouseEvent;

public class H_greeting {

    ////////// btn //////////
    public void btn_next(MouseEvent event) {
        // Будет проверка, но пока пропуск
        String input_email = c_greeting.input_email.getText();
        String input_password = c_greeting.input_password.getText();

        print.debag(input_email);
        print.debag(input_password);

        panel.stage.setResizable(true);
        c_main.initialize();
    }

}