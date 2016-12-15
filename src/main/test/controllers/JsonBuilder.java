package controllers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vandorallen on 15/12/2016.
 */
public class JsonBuilder {

    private static final List<String> CLASSES = Arrays.asList("Barbare",	"Barde", "Prêtre", "Druide", "Guerrier", "Moine", "Paladin", "Rôdeur", "Roublard", "Ensorceleur", "Magicien");

    @Test
    public void parse() {

        List<String> skills = Arrays.asList("Acrobaties	C	C	—	—	—	C	—	—	C	—	—	Oui	Dex",
                                            "Art de la magie	—	C	C	C	—	—	C	C	—	C	C	Non	Int",
                                            "Artisanat	C	C	C	C	C	C	C	C	C	C	C	Oui	Int",
                                            "Bluff	—	C	—	—	—	—	—	—	C	C	—	Oui	Cha",
                                            "Connaissances (exploration souterraine)	—	C	—	—	C	—	—	C	C	—	C	Non	Int",
                                            "Connaissances (folklore local)	—	C	—	—	—	—	—	—	C	—	C	Non	Int",
                                            "Connaissances (géographie)	—	C	—	C	—	—	—	C	—	—	C	Non	Int",
                                            "Connaissances (histoire)	—	C	C	—	—	C	—	—	—	—	C	Non	Int",
                                            "Connaissances (ingénierie)	—	C	—	—	C	—	—	—	—	—	C	Non	Int",
                                            "Connaissances (mystères)	—	C	C	—	—	—	—	—	—	C	C	Non	Int",
                                            "Connaissances (nature)	C	C	—	C	—	—	—	C	—	—	C	Non	Int",
                                            "Connaissances (noblesse)	—	C	C	—	—	—	C	—	—	—	C	Non	Int",
                                            "Connaissances (plans)	—	C	C	—	—	—	—	—	—	—	C	Non	Int",
                                            "Connaissances (religion)	—	C	C	—	—	C	C	—	—	—	C	Non	Int",
                                            "Déguisement	—	C	—	—	—	—	—	—	C	—	—	Oui	Cha",
                                            "Diplomatie	—	C	C	—	—	—	C	—	C	—	—	Oui	Cha",
                                            "Discrétion	—	C	—	—	—	C	—	C	C	—	—	Oui	Dex",
                                            "Dressage	C	—	—	C	C	—	C	C	—	—	—	Non	Cha",
                                            "Équitation	C	—	—	C	C	C	C	C	—	—	—	Oui	Dex",
                                            "Escalade	C	C	—	C	C	C	—	C	C	—	—	Oui	For",
                                            "Escamotage	—	C	—	—	—	—	—	—	C	—	—	Non	Dex",
                                            "Estimation	—	C	C	—	—	—	—	—	C	C	C	Oui	Int",
                                            "Évasion	—	C	—	—	—	C	—	—	C	—	—	Oui	Dex",
                                            "Intimidation	C	C	—	—	C	C	—	C	C	C	—	Oui	Cha",
                                            "Linguistique	—	C	C	—	—	—	—	—	C	—	C	Non	Int",
                                            "Natation	C	—	—	C	C	C	—	C	C	—	—	Oui	For",
                                            "Perception	C	C	—	C	—	C	—	C	C	—	—	Oui	Sag",
                                            "Premiers secours	—	—	C	C	—	—	C	C	—	—	—	Oui	Sag",
                                            "Profession	—	C	C	C	C	C	C	C	C	C	C	Non	Sag",
                                            "Psychologie	—	C	C	—	—	C	—	—	C	—	—	Oui	Sag",
                                            "Représentation	—	C	—	—	—	C	—	—	C	—	—	Oui	Cha",
                                            "Sabotage	—	—	—	—	—	—	—	—	C	—	—	Non	Dex",
                                            "Survie	C	—	—	C	C	—	—	C	—	—	—	Oui	Sag",
                                            "Utilisation d'objets magiques	—	C	—	—	—	—	—	—	C	C	—	Non	Cha",
                                            "Vol	—	—	—	C	—	—	—	—	—	C	C	Oui	Dex");

        for (String line : skills){
            String[] skill = line.split("\\t");
            System.out.println(Arrays.asList(skill));
            System.out.println(getClassesFromSkill(skill));
        }
    }

    private final List<Integer> indexOfCs(String[] skill) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < skill.length; ++i) {
            if ("C".equals(skill[i])) {
                integerList.add(i-1);
            }
        }

        return integerList;
    }

    private final List<String> getClasses(List<Integer> integerList) {
        List<String> stringList = new ArrayList<>();
        for (Integer integer : integerList) {
            stringList.add(CLASSES.get(integer));
        }

        return stringList;
    }

    private List<String> getClassesFromSkill(String[] skill) {
        return getClasses(indexOfCs(skill));
    }
}
