package Introduction;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo4 {
	
	@BeforeMethod
	private void bMethod() {
		
		System.out.println("Before method in demo 4");
	}
	
	@AfterMethod
	private void aMethod() {
		
		System.out.println("After method in demo 4");
	}
	
	@Test
	private void webhomeLoan() {
		
		System.out.println("Web home Loan");
	}
	
	@Test
	private void mobilehomeLoan() {
		
		System.out.println("Mob home Loan");
	}
	
	@Test(groups= {"Smoke"})
	@Parameters({"URL","UserName"})
	private void APIhomeLoan(String url,String un) {
		
		System.out.println("API home Loan");
		System.out.println(url);
		System.out.println(un);
	}

}
