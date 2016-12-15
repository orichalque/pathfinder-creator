package util;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vandorallen on 15/12/2016.
 */
public class JsonBuilder {

    private static final List<String> CLASSES = Arrays.asList("Barbare", "Barde", "Prêtre", "Druide", "Guerrier", "Moine", "Paladin", "Rôdeur", "Roublard", "Ensorceleur", "Magicien");
    private static List<String> skills;
    private static List<String> classes;

    /*public static void main(String[] args) {
        parse("skills.txt");
    }*/

    public static void parse(String fileName) {
        skills = new ArrayList<>();

        String lineInFile;
        try (
                InputStream fis = new FileInputStream("src/main/resources/"+fileName);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr)
        ) {
            if ((lineInFile = br.readLine()) != null) {
                //Getting the classes from the first line of the file
                classes = Arrays.asList(lineInFile.split("\\s"));
            }
            while ((lineInFile = br.readLine()) != null) {
                // Deal with the line
                skills.add(lineInFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();


        for (String line : skills){
            stringBuilder.append("{\n");
            String[] skill = line.split("\\t");
            stringBuilder.append("\t\"name\" : ").append("\"").append(skill[0]).append("\", \n");
            stringBuilder.append("\t\"description\" : \"\",\n");
            stringBuilder.append("\t\"classes\" :").append("[");


            for (String clazz : getClassesFromSkill(skill)) {
                stringBuilder.append("\"").append(clazz).append("\", ");
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("] \n").append("}\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static final List<Integer> indexOfCs(String[] skill) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < skill.length; ++i) {
            if ("C".equals(skill[i])) {
                integerList.add(i-1);
            }
        }

        return integerList;
    }

    private static final List<String> getClasses(List<Integer> integerList) {
       return integerList.stream().map(classes::get).collect(Collectors.toList());
    }

    private static List<String> getClassesFromSkill(String[] skill) {
        return getClasses(indexOfCs(skill));
    }
}
