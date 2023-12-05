package epsilon;
import javafx.application.Application;

public class Panel {

    public static void main(String[] args) {

        System.out.println("Loading resources...");
        new Panel();

        // SpringApplication.run(SquadromApplication.class, args);
        // // pulling out bean from the pool
        // context =           new AnnotationConfigApplicationContext(squadrom.beans.Spring_config.class);
        // panel =             context.getBean("panel", squadrom.beans.Panel.class);
        // sql =               context.getBean("sql", auxiliary.Exec_sql.class);

        System.out.println("Launching Epsilon...");
        Epsilon.launch();
    }

    // public String css;
    // public static Panel panel = new Panel();
    public static Epsilon epsilon = new Epsilon();

    // // variables
    // @Value("${mysql.server}")   public String mysql_server;
    // @Value("${mysql.user}")     public String mysql_user;
    // @Value("${mysql.password}") public String mysql_password;
    // @Value("${server.project}") public String server_project;
    // @Value("${server.ip}")      public String server_ip;
    // @Value("${cookie_name}")    public String cookie_name;
    // @Value("${cookie_salt}")    public String cookie_salt;
    // @Value("${path_upload}")    public String path_upload;
    // @Value("${path_users}")     public String path_users;

    // public static AnnotationConfigApplicationContext context;
    // public static Panel panel;
    // public static Print print = new Print();
    // public static auxiliary.Exec_sql sql;


    // public Panel() {
    //     css = ""; // getClass().getResource("css/styles.css").toExternalForm();
    //     epsilon = new Epsilon();
    // }

}