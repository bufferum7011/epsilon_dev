package epsilon;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Panel extends Application {

    ////////// Variables //////////
    private static Properties property;
    public String mysql_server;
    public String mysql_user;
    public String mysql_password;
    public String server_project;
    public String server_ip;
    public Stage stage;
    public Scene scene;
    public String css;
    public String img_icon;
    public String img_hide;
    public String img_resize;
    public String img_close;

    public static Panel panel;
    public static auxiliary.Print print;
    public static auxiliary.Exec_sql sql;
    public static Style_control style_control;

    public static epsilon.layouts.C_main c_main             = new epsilon.layouts.C_main();
    public static epsilon.layouts.C_greeting c_greeting     = new epsilon.layouts.C_greeting();

    public static epsilon.handlers.H_render_el h_render_el  = new epsilon.handlers.H_render_el();
    public static epsilon.handlers.Buttons btns             = new epsilon.handlers.Buttons();
    public static epsilon.handlers.Offset offset            = new epsilon.handlers.Offset();

    public static Test test                                 = new Test();
    public static Render render                             = new Render();
    public static Render_elements render_el                 = new Render_elements();

    public static void main(String[] args) {

        print               = new auxiliary.Print();
        panel               = new Panel();
        sql                 = new auxiliary.Exec_sql();
        property            = new Properties();
        try {
            property.load(new FileInputStream("src/main/resources/application.properties"));
            panel.mysql_server      = property.getProperty("mysql.server");
            panel.mysql_user        = property.getProperty("mysql.user");
            panel.mysql_password    = property.getProperty("mysql.password");
            panel.server_project    = property.getProperty("server.project");
            panel.server_ip         = property.getProperty("server.ip");
            panel.css               = panel.getClass().getResource("/css/style.css").toExternalForm();
            panel.img_icon          = panel.getClass().getResource("/img_sys/icon.png").toExternalForm();
            panel.img_hide          = panel.getClass().getResource("/img_sys/MINUS.png").toExternalForm();
            panel.img_resize        = panel.getClass().getResource("/img_sys/MINIMIZE.png").toExternalForm();
            panel.img_close         = panel.getClass().getResource("/img_sys/CLOSE.png").toExternalForm();

            print.way("[Loading resources...]\n");
        } catch(IOException e) { print.error("[Loading resources...]"); }

        print.way("[Launching Epsilon...]\n");
        Application.launch(Panel.class, args);
    }

    @Override public void start(Stage stage) throws IOException {

        print.result("[Application starts]\n");
        panel.stage = stage;

        c_main.initialize();
        // test.initialize();
        // c_greeting.initialize();
    }
    @Override public void init() throws Exception {

        print.result("[Application inits]\n");
        super.init();
    }
    @Override public void stop() throws Exception {

        print.result("[Application stops]\n");
        super.stop();
    }
}