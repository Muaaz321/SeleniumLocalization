package ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropReader {

	private Properties prop;
	private FileInputStream ip;
	
	
	public Properties initLangProp() throws IOException {
		
		//mvn clean install -Dlang="french"
		String language = System.getProperty("lang");
		System.out.println("Lang is " + language);
		
		
		
		prop = new Properties();
		
		try {
		switch (language.toLowerCase()) {
		case "english":
			ip = new FileInputStream("./src/main/resources/lang.english.properties");
			break;
		case "french":
			ip = new FileInputStream("./src/main/resources/lang.french.properties");
			break;
			

		default:
			System.out.println("lang not found " + language);
			break;
		}
		
		prop.load(ip);
		
		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return prop;
	} 
	
	
}
