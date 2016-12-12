package configuration;

import controllers.CharacterController;
import org.springframework.context.annotation.Bean;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class ControllerConfiguration {

    @Bean
    public CharacterController characterController() {
        return new CharacterController();
    }
}
