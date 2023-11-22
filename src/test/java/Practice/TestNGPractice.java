package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCoustomer()
	{
		
		System.out.println("create");
	}
	@Test(dependsOnMethods = "createCoustomer")
	public void modifyCoustomer()
	{
		
		System.out.println("modify");
	}
	@Test
	
	public void deleteCoustomer()
	{
		
		System.out.println("delete");
	}
	}


