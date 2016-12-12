package controllers;

import interfaces.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vandorallen on 12/12/2016.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @Value("${mongo.url}")
    private String s;

    @RequestMapping(value = "/characters")
    public @ResponseBody String getCharacters() {
        return characterRepository.getCharacters();
    }
}
