package controllers;

import interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vandorallen on 12/12/2016.
 * 
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class Controller {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public @ResponseBody String getCharacters() {
        return characterRepository.getCharacters();
    }

    @RequestMapping(value = "/species", method = RequestMethod.GET)
    public @ResponseBody String getSpecies() {
        return speciesRepository.getSpecies();
    }

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public @ResponseBody String getSkills() {
        return skillRepository.getSkills();
    }

    @RequestMapping(value = "/gifts", method = RequestMethod.GET)
    public @ResponseBody String getGifts() {
        return giftRepository.getGifts();
    }

    @RequestMapping(value = "/equipments", method = RequestMethod.GET)
    public @ResponseBody String getEquipments() {
        return equipmentRepository.getEquipments();
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public @ResponseBody String getClasses() {
        return classRepository.getClasses();
    }

}
