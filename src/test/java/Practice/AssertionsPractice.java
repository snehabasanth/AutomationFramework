package Practice;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice 
{
	@Test
	public void practice()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals(2, 1);
		System.out.println("Step 3");
	    
	}
	@Test
	public void practice1() {
		
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		sa.assertTrue(true);
		System.out.println("Step 2");
		Assert.assertTrue(false);
		sa.assertEquals("B", "A");
		System.out.println("Step 3");
		
		sa.assertAll();//failure logged
		
		
		
	}


}
	
