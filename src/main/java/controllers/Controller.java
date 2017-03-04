package controllers;

import interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private AlignmentRepository alignmentRepository;

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

    @RequestMapping(value = "/alignments", method = RequestMethod.GET)
    public @ResponseBody String getAlignments() {
        return alignmentRepository.getAlignments();
    }

    @CrossOrigin(origins = {"https://create-your-character.herokuapp.com"})
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public @ResponseBody void validateCharacter(@RequestBody String charAsJson) {
        characterRepository.addCharacter(charAsJson);
    }

}
