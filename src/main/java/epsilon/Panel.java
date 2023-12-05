package epsilon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Panel {

    public static void main(String[] args) {

        System.out.println("Loading resources...");
        new Panel();

        SpringApplication.run(SpringApplication.class, args);
        // pulling out bean from the pool
        context =           new AnnotationConfigApplicationContext(epsilon.Spring_config.class);
        panel =             context.getBean("panel", epsilon.Panel.class);
        sql =               context.getBean("sql", auxiliary.Exec_sql.class);
        print =             new auxiliary.Print();
        epsilon =           new Epsilon();

        css =               ""; // getClass().getResource("css/styles.css").toExternalForm();
        System.out.println("Launching Epsilon...");
        epsilon.launch();
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

    public static String css;

}