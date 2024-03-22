package excelDriven.excelDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide {
	
	@DataProvider(name="dataContent")
	public void getData() {
		
//		Object[][] data = {{"hello","text",1},{"LoveYou","Call",143},{"Bye","Whatsapp",420}};
		
		
//		return data;
	}
	
	@Test(dataProvider = "dataContent")
	public void testCase(String greeting,String media,int Id) {
		
		System.out.println(greeting+media+Id);
	}
}
