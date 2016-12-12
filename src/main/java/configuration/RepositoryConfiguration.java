package configuration;

import interfaces.CharacterRepository;
import org.springframework.context.annotation.Bean;
import repositories.CharacterRepositoryImpl;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class RepositoryConfiguration {

    @Bean
    public CharacterRepository characterRepository() {
        return new CharacterRepositoryImpl();
    }
}
