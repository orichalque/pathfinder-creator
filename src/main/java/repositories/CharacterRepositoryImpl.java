package repositories;

import interfaces.CharacterRepository;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    @Override
    public String getCharacters() {
        return "characters";
    }

    @Override
    public String getCharacterById(String id) {
        return null;
    }
}
