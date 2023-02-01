package Juan;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class excelData {
	
	


	
	@DataProvider (name = "excelData")
	public Object [][] excelDataPovider(){
		Object [][] dataObj = getExcelData(
				"C:\\Users\\JuanRamirez\\Documents\\DataPro.xlsx","Hoja1");
		return dataObj;
	}
	
	  public String [][] getExcelData(String fileName, String sheetName){
			String [][] data = null;
			try {
				FileInputStream fis = new FileInputStream(fileName);
				
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            XSSFRow row = sheet.getRow(0);
	            int noOfRows = sheet.getPhysicalNumberOfRows();
	            int noOfCols = row.getLastCellNum();
	            Cell cell;
	            data = new String[noOfRows - 1][noOfCols];
	 
	            for (int i = 1; i < noOfRows; i++) {
	                for (int j = 0; j < noOfCols; j++) {
	                    row = sheet.getRow(i);
	                    cell = row.getCell(j);
	                    if(cell.getCellTypeEnum() == CellType.STRING) {
	                    	data[i-1][j] = cell.getStringCellValue();
	                    } 
	                    else if(cell.getCellTypeEnum() == CellType.NUMERIC) {
	                    	data[i - 1][j] = NumberToTextConverter.toText(cell.getNumericCellValue());
	                    }
	                    
	                    System.out.println("-"+data [i - 1][j]);
	               
	                }
	            }
			}catch (Exception e) {
				   System.out.println("The exception is: " + e.getMessage());
			}
			return data;
	 
	
	}
}
	  
	
	

