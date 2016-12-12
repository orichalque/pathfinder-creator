package configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by Vandorallen on 12/12/2016.
 */
@SpringBootApplication
@Import({ControllerConfiguration.class, RepositoryConfiguration.class})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
