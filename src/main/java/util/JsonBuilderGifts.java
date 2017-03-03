package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class JsonBuilderGifts {

	private static List<String> gifts;
	
	public static void parse(String filename) {
		gifts = new ArrayList<>();

        String lineInFile;
        try (
                InputStream fis = new FileInputStream("src/main/resources/"+filename);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr)
        ) {
            while ((lineInFile = br.readLine()) != null) {
                // Deal with the line
            	gifts.add(lineInFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        StringBuilder builder = new StringBuilder();
        String[] lineSplitted;
        
        for (String line : gifts) {
        	lineSplitted = line.split("\\t");
        	builder.append("{");
        	builder.append("\"name\": \"");
        	builder.append(lineSplitted[0]);
        	builder.append(" \", \"condition\" : \"");
        	builder.append(lineSplitted[1]);
        	builder.append(" \", \"description\" : \"");
        	builder.append(lineSplitted[2]);
        	builder.append("\"}");
        	System.out.println(builder.toString());
        	builder = new StringBuilder();
        }
        
        System.out.println(gifts.size());
	}
	
	public static void main(String[] args) {
		parse("gifts.txt");
		
	}
	
}
