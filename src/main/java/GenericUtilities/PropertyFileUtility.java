package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//singleline comment
/*multi line comment*/

/**
 * This class consist of re usable methods related to property file
 * @author Sneha*/


public class PropertyFileUtility {

	/**
	 * this method will read data from propertyFile for the key provide by caller
	 * and return the value to caller
	 * @parameter key
	 * @return value
	 * @throws IOException
	 * @
	 */	
	
	
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonDataProperties");	
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	

	}

}
