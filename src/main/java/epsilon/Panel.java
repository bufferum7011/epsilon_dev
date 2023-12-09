package epsilon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

@SpringBootConfiguration
public class Panel {

    public static void main(String[] args) {

        System.out.println("Loading resources...");
        new Panel();

        // Экземпляры
        SpringApplication.run(Panel.class, args);
        context =           new AnnotationConfigApplicationContext(epsilon.Spring_config.class);
        panel =             context.getBean("panel", epsilon.Panel.class);
        sql =               context.getBean("sql", auxiliary.Exec_sql.class);
        print =             new auxiliary.Print();
        epsilon =           new Epsilon();

        // Переменные
        panel.css =         epsilon.getClass().getResource("/css/style.css").toExternalForm();
        // panel.icon =        new Image(epsilon.getClass().getResource("/img_sys/icon.png").toExternalForm());

        // Запуск приложения
        System.out.println("Launching Epsilon...");
        epsilon.start();
    }

    // variables
    @Value("${mysql.server}")   public String mysql_server;
    @Value("${mysql.user}")     public String mysql_user;
    @Value("${mysql.password}") public String mysql_password;
    @Value("${server.project}") public String server_project;
    @Value("${server.ip}")      public String server_ip;

    public static AnnotationConfigApplicationContext context;
    public static Panel panel;
    public static auxiliary.Print print;
    public static auxiliary.Exec_sql sql;
    public static Epsilon epsilon = new Epsilon();

    public Stage stage;
    public Scene scene;
    public String css;
    public Image icon;

}