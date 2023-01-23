package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class data_provider {
	@SuppressWarnings("deprecation")
	public void readExcel(String path, String filename, String sheetName) throws IOException {
		// creates a file object to open the file
		File excelFile = new File(path + "\\" + filename);
		// create object fileinputstream to read excel
		FileInputStream inputStream = new FileInputStream(excelFile);
		Workbook seleniumTrainingWorkbook = null;
		// find file extension
		String fileExtensionName = filename.substring(filename.indexOf("."));
		// if the file is xlsx then we will create an object of XSSWorkbook class
		if (fileExtensionName.equals(".xlsx")) {
			seleniumTrainingWorkbook = new XSSFWorkbook(inputStream);
		}
		// if the file is xlsx then we will create an object of HSSWorkbook class
		if (fileExtensionName.equals(".xls")) {
			seleniumTrainingWorkbook = new HSSFWorkbook(inputStream);
		}
		// read sheet inside the workbook using its name
		Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);
		// getting the first row
		Row row;
		// reading first cell
		String cell = "";
		for (int rowIndex = 0; rowIndex <= sheetTraining.getLastRowNum(); rowIndex++) {
			row = sheetTraining.getRow(rowIndex);
			for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
				row.getCell(columnIndex).setCellType(Cell.CELL_TYPE_STRING);
				cell = row.getCell(columnIndex).getStringCellValue();
				System.out.print(cell + "  |  ");
			}
			System.out.println();
		}
	}

	public void writeExcel(String path, String filename, String sheetName, String cellValue) throws IOException {

		// CREATES A FILE OBJECT TO OPEN THE FILE
		File excelFile = new File(path + "\\" + filename);

		// CREATE OBJECT FILEINPUTSTREAM TO READ EXCEL
		FileInputStream inputStream = new FileInputStream(excelFile);

		Workbook seleniumTrainingWorkbook = null;

		// FIND FILE EXTENSION
		String fileExtensionName = filename.substring(filename.indexOf("."));

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF XSSWORKBOOK CLASS
		if (fileExtensionName.equals(".xlsx")) {
			seleniumTrainingWorkbook = new XSSFWorkbook(inputStream);
		}

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF HSSWORKBOOK CLASS
		if (fileExtensionName.equals(".xls")) {
			seleniumTrainingWorkbook = new HSSFWorkbook(inputStream);
		}

		// READ SHEET INSIDE THE WOKRBOOK USING ITS TIME
		Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);

		// GET CELL NUMBER COUNT (OF THE FIRST ROW)
		int firstRowLastCellNumber = sheetTraining.getRow(0).getLastCellNum();

		// GET HOW MANY ROWS ARE IN THE SHEET
		int rowCount = sheetTraining.getLastRowNum();

		// CREATE A NEW ROW AFTER THE LAST ONE
		Row newRow = sheetTraining.createRow(rowCount + 1);

		// CICLE INTO EACH COLUMN OF THE NEW ROW AND SET THE VALUE
//		for (int indexNewCell = 0; indexNewCell < firstRowLastCellNumber; indexNewCell++) {
//			Cell cell = newRow.createCell(indexNewCell);
//			cell.setCellValue(cellValue + indexNewCell);
//       	}

		for (int indexNewCell = 0; indexNewCell < firstRowLastCellNumber; indexNewCell++) {
			switch (indexNewCell) {
			case 0: {
				Cell cell = newRow.createCell(indexNewCell);
				cell.setCellValue("pink");
				break;
			}
			case 1: {
				Cell cell = newRow.createCell(indexNewCell);
				cell.setCellValue("black");
				break;
			}
			case 2: {
				Cell cell = newRow.createCell(indexNewCell);
				cell.setCellValue("white");
				break;
			}
			default: {
				Assert.fail("Failed: index is out of bounds");
			}

			} // CLOSING SWITCH
		}

		// CLOSE THE INPUT STREAM
		inputStream.close();

		// CREATE AN OBJECT OF FILEOUTPUTSTREAM TO WRITE DATA IN EXCEL FILE
		FileOutputStream outputStream = new FileOutputStream(excelFile);

		// WRITE DATA
		seleniumTrainingWorkbook.write(outputStream);
		outputStream.close();
	}

}
