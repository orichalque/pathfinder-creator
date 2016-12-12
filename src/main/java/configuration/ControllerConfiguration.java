package configuration;

import controllers.Controller;
import interfaces.*;
import org.springframework.context.annotation.Bean;
import repositories.*;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class ControllerConfiguration {

    @Bean
    public Controller characterController() {
        return new Controller();
    }
    @Bean
    public CharacterRepository characterRepository() {
        return new CharacterRepositoryImpl();
    }
    
    @Bean
    public SpeciesRepository speciesRepository() {
        return new SpeciesRepositoryImpl();
    }
    @Bean
    public SkillRepository skillRepository() { return new SkillRepositoryImpl();}

    @Bean
    public EquipmentRepository equipmentRepository() { return new EquipmentRepositoryImpl();}

    @Bean
    public GiftRepository giftRepository() { return new GiftRepositoryImpl();}

    @Bean
    public ClassRepository classRepository () {return new ClassRepositoryImpl();}

}
