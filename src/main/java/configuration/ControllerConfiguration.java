package configuration;

import controllers.Controller;
import org.springframework.context.annotation.Bean;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class ControllerConfiguration {

    @Bean
    public Controller characterController() {
        return new Controller();
    }
}
