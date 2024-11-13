package gjha123.seleniumframework.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReadersUtils {
	 private static Properties properties = new Properties();
		static {
			try {
				FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
						+ "/src/main/java/gjha123/seleniumframework/resources/config.properties");
				properties.load(fileInputStream);
			} catch (IOException e) {
	            System.out.println("IOException occurred while loading properties file: " + e.getMessage());
	        }
		}


		 public static String readyKey(String key) {
		        try {
		            return properties.getProperty(key);
		        } catch (Exception e) {
		            System.out.println("Exception occurred while reading key: " + e.getMessage());
		            return "default_value"; // Provide a default value or handle the error as needed
		        }
		    }
	  
}
