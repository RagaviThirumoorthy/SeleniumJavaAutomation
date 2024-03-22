package inheritance;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InheritanceDemo1 {
	
	@BeforeTest
	public void bTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void aTest() {
		System.out.println("After Test");
	}
	
	@Test
	public void parentDemo() {
		
		System.out.println("demo");
	}

}
