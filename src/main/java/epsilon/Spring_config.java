package epsilon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import auxiliary.Exec_sql;

@Configuration
@ComponentScan({"epsilon"})
@PropertySource("classpath:application.properties")
public class Spring_config {

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

}