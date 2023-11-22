package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	 //step1: open the document in java readable format
	 FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonDataProperties");
	
	//step2:create an object properties class from java.utill
	 Properties p = new Properties();
	 
	// step:3 load the input stream into properties
	 p.load(fis);
	
	//step4: provide the key to read the value
	String value2 = p.getProperty("browser");
	System.out.println(value2);
	 
	String value = p.getProperty("username");
	System.out.println(value);
	
	String value1 = p.getProperty("password");
	System.out.println(value1);
	
	
	}

}
