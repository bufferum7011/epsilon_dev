package epsilon;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Panel extends Application {

    ////////// Variables //////////
    public String mysql_server;
    public String mysql_user;
    public String mysql_password;
    public String server_project;
    public String server_ip;
    private static Properties property;
    public Stage stage;
    public Scene scene;
    public String css;
    public String icon;
    public boolean key_fullscreen;

    public static Panel panel;
    public static auxiliary.Print print;
    public static auxiliary.Exec_sql sql;
    public static Handlers handlers;

    public static epsilon.controllers.C_main c_main;
    public static epsilon.controllers.C_greeting c_greeting;
    public static Test test;
    public static Grid_2d grid_2d;
    public static Elements el;

    ////////// Addition functions //////////
    private static void loading_resources() {

        print               = new auxiliary.Print();
        print.way("[Loading resources...]\n");

        panel               = new Panel();
        sql                 = new auxiliary.Exec_sql();
        handlers            = new Handlers();
        el                  = new Elements();
        
        c_main              = new epsilon.controllers.C_main();
        c_greeting          = new epsilon.controllers.C_greeting();
        test                = new Test();
        property            = new Properties();
        try {
            property.load(new FileInputStream("src/main/resources/application.properties"));
            panel.mysql_server      = property.getProperty("mysql.server");
            panel.mysql_user        = property.getProperty("mysql.user");
            panel.mysql_password    = property.getProperty("mysql.password");
            panel.server_project    = property.getProperty("server.project");
            panel.server_ip         = property.getProperty("server.ip");
            panel.css               = panel.getClass().getResource("/css/style.css").toExternalForm();
            panel.icon              = panel.getClass().getResource("/img_sys/icon.png").toExternalForm();
            panel.key_fullscreen    = false;
        }
        catch(IOException e) { print.error("[Loading properties...]"); }
    }
    public void default_settings() {

        scene.getStylesheets().add(css);        // Настройка стилей
        stage.setScene(scene);                  // Настройка сцены
        stage.setTitle(server_project);         // Настройка названия приложения
        stage.getIcons().add(new Image(icon));  // Настройка иконки
        stage.initStyle(StageStyle.DECORATED);  // Настройка декорации
        stage.setOpacity(1);                    // Настройка прозрачности

        stage.setMinHeight(500);                // Настройка минимальной выстоты
        stage.setMinWidth(500);                 // Настройка минимальной ширины
        // stage.setMaxHeight(500);                // Настройка максимальной выстоты
        // stage.setMaxWidth(350);                 // Настройка максимальной ширины
        stage.setHeight(550);                   // Настройка высоты окна
        stage.setWidth(1000);                   // Настройка ширины окна
        stage.setX(100);                        // Настройка расположения окна по горизонтали
        stage.setY(100);                        // Настройка расположения окна по высоте

        // stage.centerOnScreen();                 // Располагает окно в центре экрана
        stage.setResizable(true);               // Разрешение на изменение размера
        stage.setFullScreen(false);             // Разрешение на открытие на полный экран
    }


    public static void main(String[] args) {

        loading_resources();
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