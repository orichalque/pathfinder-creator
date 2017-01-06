package util;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Raf_bogoss on 05/01/2017.
 */
public class JsonBuilderWeapons {

   private static List<String> armes;

    /*public static void main(String[] args) {
        parse("weapons.txt");
    } */

    public static void parse(String fileName) {
        armes = new ArrayList<>();

        String lineInFile;
        try (
                InputStream fis = new FileInputStream("src/main/resources/"+fileName);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr)
        ) {
            while ((lineInFile = br.readLine()) != null) {
                // Deal with the line
                armes.add(lineInFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String line : armes){
            stringBuilder.append("{\n");
            String[] arme = line.split("\\t");
            stringBuilder.append("\t\"name\" : ").append("\"").append(arme[0]).append("\", \n");
            stringBuilder.append("\t\"description\" : ").append("\"").append(arme[1]).append("\", \n");
            stringBuilder.append("\t\"price\" : ").append(arme[2]).append(", \n");
            stringBuilder.append("\t\"damage\" : ").append("\"").append(arme[3]).append("\", \n");
            stringBuilder.append("\t\"type\" : ").append("\"").append(arme[4]).append("\", \n");
            stringBuilder.append("\t\"class\" : ").append("\"").append(arme[5]).append("\", \n");
            stringBuilder.append("\t\"subclass\" : ").append("\"").append(arme[6]).append("\" \n");
            stringBuilder.append("}\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
