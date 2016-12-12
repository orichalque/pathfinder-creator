package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import javax.annotation.PreDestroy;

/**
 * Created by Vandorallen on 12/12/2016.
 */
@SpringBootApplication
@Import({ControllerConfiguration.class, RepositoryConfiguration.class})
public class Application {
    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;


    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
