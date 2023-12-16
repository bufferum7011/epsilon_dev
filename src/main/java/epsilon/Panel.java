package epsilon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import auxiliary.Exec_sql;
import epsilon.controllers.C_main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootConfiguration
public class Panel {

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
    public static Epsilon epsilon;
    public static Handlers handlers;
    public static C_main c_main;

    public Stage stage;
    public Scene scene;
    public String css;
    public String icon;
    public boolean key_fullscreen;

    public void default_settings() {

        scene.getStylesheets().add(css);

        stage.setScene(scene);                  // Настройка сцены
        stage.setTitle(server_project);         // Настройка названия приложения
        stage.getIcons().add(new Image(icon));  // Настройка иконки
        stage.initStyle(StageStyle.DECORATED);  // Настройка рамки окна

        stage.setMinHeight(500);                // Настройка минимальной выстоты
        stage.setMinWidth(350);                 // Настройка минимальной ширины
        // stage.setMaxHeight(500);                // Настройка максимальной выстоты
        // stage.setMaxWidth(350);                 // Настройка максимальной ширины
        stage.setHeight(550);                   // Настройка высоты окна
        stage.setWidth(1000);                   // Настройка ширины окна
        stage.setX(100);                        // Настройка расположения окна по горизонтали
        stage.setY(100);                        // Настройка расположения окна по высоте

        stage.centerOnScreen();                 // Располагает окно в центре экрана
        stage.setResizable(true);               // Разрешение на изменение размера

        // stage.setFullScreen(false);             // Разрешение на открытие на полный экран
        // stage.setOpacity(1);                    // Настройка прозрачности
    }
    public static void main(String[] args) {

        System.out.println("Loading resources...");
        new Panel();

        // Экземпляры
        SpringApplication.run(Panel.class, args);
        context =           new AnnotationConfigApplicationContext(epsilon.Spring_config.class);
        panel =             context.getBean("panel", epsilon.Panel.class);
        sql =               context.getBean("sql", auxiliary.Exec_sql.class);
        handlers =          context.getBean("handlers", Handlers.class);
        print =             new auxiliary.Print();
        epsilon =           new Epsilon();
        c_main = new C_main();

        // Переменные
        panel.css =         epsilon.getClass().getResource("/css/style.css").toExternalForm();
        panel.icon =        epsilon.getClass().getResource("/img_sys/icon.png").toExternalForm();
        panel.key_fullscreen = false;

        // Запуск приложения
        System.out.println("Launching Epsilon...");
        Application.launch(Epsilon.class, args);
    }

}


@Configuration
@ComponentScan({"epsilon"})
@PropertySource("classpath:application.properties")
class Spring_config {

    @Bean
    @Scope("singleton")
    public Panel panel() {
        return new Panel();
    }

    @Bean
    @Scope("singleton")
    @DependsOn({"panel"})
    public Exec_sql sql() {
        return new Exec_sql();
    }

    @Bean
    @Scope("singleton")
    @DependsOn({"panel"})
    public Handlers handlers() {
        return new Handlers();
    }

}