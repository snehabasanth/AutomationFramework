package GenericUtilities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to Java
 * @Sneha
 */
public class JavaUtility {
/** 
 * this method will return the current system date in specified format
 */
	public String getSystemDateInFormat()
	{	
       Date d = new Date();
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
       String currentdate = formatter.format(d);
       return currentdate;
       
     }
	/**
	 * this method will generate a random number for every run
	 * @return
	 */
	 public int getRandomNumber()
	 {
		Random r = new Random();
		int value = r.nextInt(1000);
		return value;
		
		 
	 }

}
