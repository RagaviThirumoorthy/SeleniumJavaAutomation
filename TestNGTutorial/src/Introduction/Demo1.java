package Introduction;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Demo1 {


	@Test(dependsOnMethods = "ragavi")
	private void testdemo1() {
		
		System.out.println("Personal");
		Assert.assertTrue(false);
	}
	
	@Test(timeOut = 2000)
	@Parameters({"URL"}) 
	private void ragavi(String url) {
		
		System.out.println("Ragavi");
		System.out.println("URL is "+url);
	}

}
