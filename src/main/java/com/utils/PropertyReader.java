package main.java.com.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

private static String filename = "./src/main/resources/config.properties";
	
	public static String getValue(String key) {
		FileReader fr = null;
		String value=null;
		Properties prop = new Properties();
		
		try {
			fr = new FileReader(filename);
			prop.load(fr);
			
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
