package epsilon.handlers;
import static epsilon.Panel.*;
import javafx.event.ActionEvent;

public class Buttons {

    ////////// main //////////
    public void win_resize(ActionEvent event) {
        if(panel.stage.isMaximized()) { panel.stage.setMaximized(false); }
        else { panel.stage.setMaximized(true); }
    }
    public void win_hide(ActionEvent event) { panel.stage.setIconified(true); }
    public void win_clouse(ActionEvent event) { panel.stage.close(); }

    ////////// greeting //////////
    public void btn_next(ActionEvent event) {
        // Будет проверка, но пока пропуск
        String input_email = c_greeting.input_email.getText();
        String input_password = c_greeting.input_password.getText();

        print.debag(input_email);
        print.debag(input_password);

        panel.stage.setResizable(true);
        c_main.initialize();
    }

}