package util;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raf_bogoss on 05/01/2017.
 */

public class JsonBuilderArmors {

   private static List<String> armures;

    /*public static void main(String[] args) {
        parse("armors.txt");
    }*/

    public static void parse(String fileName) {
    	
        armures = new ArrayList<>();
        String lineInFile;
        
        try (
                InputStream fis = new FileInputStream("src/main/resources/"+fileName);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr)
        ) {
            while ((lineInFile = br.readLine()) != null) {
                // Deal with the line
                armures.add(lineInFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String line : armures){
            stringBuilder.append("{\n");
            String[] armure = line.split("\\t");
            stringBuilder.append("\t\"name\" : ").append("\"").append(armure[0]).append("\", \n");
            stringBuilder.append("\t\"description\" : ").append("\"").append(armure[1]).append("\", \n");
            stringBuilder.append("\t\"price\" : ").append(armure[2]).append(", \n");
            stringBuilder.append("\t\"CA\" : ").append(armure[3]).append(", \n");
            stringBuilder.append("\t\"maxDex\" : ").append("\"").append(armure[4]).append("\", \n");
            stringBuilder.append("\t\"testPenalty\" : ").append(armure[5]).append(", \n");
            stringBuilder.append("\t\"spellFailure\" : ").append(armure[6]).append(", \n");
            stringBuilder.append("\t\"class\" : ").append("\"").append(armure[7]).append("\", \n");
            stringBuilder.append("\t\"subclass\" : ").append("\"").append(armure[8]).append("\" \n");
            stringBuilder.append("}\n");
        }
        
        System.out.println(stringBuilder.toString());
    }
}