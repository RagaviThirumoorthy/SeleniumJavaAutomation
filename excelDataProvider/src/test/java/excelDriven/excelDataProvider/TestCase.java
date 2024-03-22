package excelDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestCase {

	@Test(dataProvider = "excelData")
	public void printData(String greeting, String media, String Id) {

		System.out.println(greeting + media + Id);
	}

	@DataProvider(name="excelData")
	public Object[][] excelData() throws IOException {

		DataFormatter formatter = new DataFormatter();

		FileInputStream fis = new FileInputStream("D:\\AUTOMATION TRAINING\\TestData\\Book.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();

		System.out.println(rowCount + " " + colCount);
		Object[][] data = new Object[rowCount - 1][colCount];

		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
//				System.out.println(formatter.formatCellValue(row.getCell(j))); 
				data[i][j] = formatter.formatCellValue(row.getCell(j));
			}
		}
		return data;
	}
}
