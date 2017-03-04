package interfaces;

/**
 * Created by Vandorallen on 12/12/2016.
 */
public interface CharacterRepository {

    public String getCharacters();

    public String getCharacterById(String id);

    public void addCharacter(String characterAsJson);

}
