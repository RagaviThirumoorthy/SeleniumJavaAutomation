package Introduction;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3 {
	
	@BeforeClass
	private void bClass() {
		
		System.out.println("Before Class in demo 3");
	}
	
	@AfterClass
	private void aClass() {
		
		System.out.println("After Class in demo 3");
	}
	
	@Test(groups= {"Smoke"})
	@Parameters({"URL"})
	private void webcarLoan(String url) {
		
		System.out.println("Web Car Loan");
		System.out.println(url);
	}
	
	@Test
	private void mobilecarLoan() {
		
		System.out.println("Mob Car Loan");
	}
	@Test
	private void mobilecarLoanLogin() {
		
		System.out.println("Mob Car Loan login");
	}
	@Test
	private void mobilecarLoanLogout() {
		
		System.out.println("Mob Car Loan logout");
	}
	
	@Test(enabled=false)
	private void APIcarLoan() {
		
		System.out.println("API Car Loan");
	}
	
	@BeforeSuite
	private void bSuite() {
		
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	private void aSuite() {
		
		System.out.println("After Suite");
	}

}
