package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class ConfigReader {
	public  Properties initializePropeties() {
		FileInputStream fis = null;
		Properties prop;
	    prop = new Properties();
	    System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
	    File files = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try {
		 fis = new FileInputStream(files);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return prop;
	}
}
