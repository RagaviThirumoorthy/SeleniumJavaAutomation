import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class dataDriven {

	public ArrayList<String> getData(String tcName) throws IOException {
		// Create Workbook object to control excel workbook
		// Access specific sheet
		// Access all rows in the sheet
		// Access first row
		// Scan entire first row and identify Test case column
		// After column identified, scan the entire Test case columna and identify
		// Purchase row
		// After you grab purchase testcase row, pull all the data of that row and feed
		// into test
		ArrayList<String> arrayList = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("D:\\AUTOMATION TRAINING\\TestData\\Data.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator(); // Sheet = collection of rows
				Row firstRow = rows.next(); // Row = collection of cells
				Iterator<Cell> cells = firstRow.cellIterator();

				int k = 0;
				int column = 0;

				while (cells.hasNext()) {
					Cell cell = cells.next();
					if (cell.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
						break;
					}
					k++;
				}
				System.out.println("Column index for header: " + column);

				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getCell(column).getStringCellValue().equalsIgnoreCase(tcName)) {
						Iterator<Cell> cellsIt = row.cellIterator();
						while (cellsIt.hasNext()) {
							Cell currentCell = cellsIt.next();
							if (currentCell.getCellType() == CellType.STRING) {
								arrayList.add(currentCell.getStringCellValue());
//							System.out.println(currentCell.getStringCellValue());
							} else {
								arrayList.add(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
							}

						}
					}
				}

			}
		}
		workbook.close();
		return arrayList;
	}

}
