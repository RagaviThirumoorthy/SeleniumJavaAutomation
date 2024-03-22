package uploadDownloadFunctionalities.uploadDownloadFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class EditExcelData {

	DataFormatter formatter = new DataFormatter();
	int rowIndex;
	int columnIndex;
	int stringRowIndex;
	int stringColumnIndex;
	int intRowIndex;
	int intColumnIndex;
//	String filePath = "C:\\Users\\USER\\Downloads\\download.xlsx";
//	String fruitName = "Apple"; 

	@Test
	public ArrayList<Integer> getIndex(String filePath, String fruitName,int price) throws IOException {
		ArrayList<Integer> a = new ArrayList<>(); 
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Iterator<Row> rows = sheet.rowIterator();

		for (int i = 0; i < rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getStringCellValue().equalsIgnoreCase(fruitName)) {
						System.out.println("The row index of "+fruitName+" is " + i + " and the column index is " + j);
						stringRowIndex = i;
						stringColumnIndex = j;
					}
				}else {
					if(cell.getNumericCellValue()==price) {
						System.out.println("The row index of "+price+" is " + i + " and the column index is " + j);
						intRowIndex = i;
						intColumnIndex = j;
					}
				}
			}
		}
		
		a.add(stringRowIndex);
		a.add(stringColumnIndex);
		a.add(intRowIndex);
		a.add(intColumnIndex);
		return a;
	}
	
	public int getRowIndex(String filePath, String text) throws IOException {
		int k = 0;
		
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) {
				Cell cell = cells.next();
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getStringCellValue().equalsIgnoreCase(text)) {
						rowIndex=k;
					}
				}
			}
			k++;
		}
		return rowIndex;
	}

	public int getColumnIndex(String filePath,String colName) throws IOException {
		int k=0;
		
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow  firstRow = sheet.getRow(0);
		Iterator<Cell> cells = firstRow.cellIterator();
		while(cells.hasNext()) {
			Cell cell = cells.next();
			if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
				columnIndex=k;
			}
			k++;
		}
		return columnIndex;
	}
	
	public boolean updateExcel(String filePath, int rowNum,int colNum, String updateValue) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);
		cell.setCellValue(updateValue);
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		fis.close();
		return true;
	}

}
