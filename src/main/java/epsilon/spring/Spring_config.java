// package epsilon.spring;
// // import static squadrom.beans.Panel.*;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import auxiliary.Exec_sql;
// import epsilon.Panel;

// @Configuration
// @ComponentScan({"epsilon"})
// @PropertySource("classpath:application.properties")
// public class Spring_config {

//     @Bean
//     @Scope("singleton")
//     public Panel panel() {
//         return new Panel();
//     }

//     @Bean
//     @Scope("singleton")
//     @DependsOn({"panel"})
//     public Exec_sql sql() {
//         return new Exec_sql();
//     }

// }