package Introduction;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo2 {
	
	@Test(groups= {"Smoke"})
	private void testdemo1() {
		
		System.out.println("Loan");
	}
	
	@Parameters({"URL"})
	private void ragavi(String url) {
		System.out.println("URL is "+url);
	}
	
	@Test(dataProvider = "getData")
	private void paramDemo(String UN, String PW) {
		System.out.println(UN);
		System.out.println(PW);
	}
	
	@BeforeTest
	private void tdemo1() {
		
		System.out.println("Before Test");
	}
	@AfterTest
	private void tdemo2() {
		
		System.out.println("After Test");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		//3 combination - 3 rows
		//2 values - 2 columns
		
		//1st set
		data[0][0] = "firstUN";
		data[0][1] = "firstPW";
		
		//2nd set
		data[1][0] = "secondUN";
		data[1][1] = "secondPW";
		
		//3rd set
		data[2][0] = "thirdUN";
		data[2][1] = "thirdPW";
		
		return data;
	}

}
