package Practice;
 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void readData(String Name, String Model, int Qty, int Price) //test script
	{
		System.out.println(Name+"----"+Model+"----"+Qty+"----"+Price);
	}
   @DataProvider
  public Object[][] getData()//row column
  {
	  Object[][] data = new Object[3][4]; //3 different data set with 4 details each
	  data[0][0]="Samsung";
	  data[0][1]="A80";
	  data[0][2]= 12;
	  data[0][3]= 12000;
	
	  data[1][0]="Iphone";
	  data[1][1]="S14";
	  data[1][2]= 20;
	  data[1][3]= 15000;
	  
	  data[2][0]="Vivo";
	  data[2][1]="V21";
	  data[2][2]= 15;
	  data[2][3]= 10000;
	  
	  return data;
  
  }

}

