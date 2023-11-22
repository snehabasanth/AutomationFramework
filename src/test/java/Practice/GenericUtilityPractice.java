package Practice;

import java.io.IOException;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;




public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		//test Script
		PropertyFileUtility pUtil = new  PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("browser");
		System.out.println(value);
		String value1 = pUtil.readDataFromPropertyFile("username");
		System.out.println(value1);
		String value2 = pUtil.readDataFromPropertyFile("url");
		System.out.println(value2);
		String value3 = pUtil.readDataFromPropertyFile("password");
		System.out.println(value3);
		
		
		
		JavaUtility jUtil = new JavaUtility();
		String date = jUtil.getSystemDateInFormat();
		System.out.println("date");
		
		int ran = jUtil.getRandomNumber();
		System.out.println(ran);
	
	    ExcelFileUtility eUtil = new ExcelFileUtility();
	    String orgname =  eUtil.readDatafromExcelFile("Organisation", 1, 2);
	    String orgNameWithRandom = orgname+ran;
	    
	    System.out.println(orgname);
	    System.out.println(orgNameWithRandom);
	    
	    
	
	}

}
