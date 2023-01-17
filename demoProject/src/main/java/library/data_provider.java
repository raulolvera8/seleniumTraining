package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data_provider {
	@SuppressWarnings("deprecation")
    public void readExcel(String path, String filename, String sheetName) throws IOException{
        //creates a file object to open the file
        File excelFile = new File (path+"\\"+filename);
        //create object fileinputstream to read excel
        FileInputStream inputStream = new FileInputStream(excelFile);
        Workbook seleniumTrainingWorkbook = null;
        //find file extension
        String fileExtensionName = filename.substring(filename.indexOf("."));
        //if the file is xlsx then we will create an object of XSSWorkbook class
        if ( fileExtensionName.equals(".xlsx")) {
            seleniumTrainingWorkbook = new XSSFWorkbook(inputStream);
        }
        //if the file is xlsx then we will create an object of HSSWorkbook class
        if (fileExtensionName.equals(".xls")) {
            seleniumTrainingWorkbook = new HSSFWorkbook(inputStream);
        }
        // read sheet inside the workbook using its name
        Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);
        //getting the first row
        Row row ;
        //reading first cell
        String cell  = "";
        for (int rowIndex=0; rowIndex<=sheetTraining.getLastRowNum();rowIndex++) {
            row = sheetTraining.getRow(rowIndex);
            for (int columnIndex =0; columnIndex<row.getLastCellNum();columnIndex++) {
                row.getCell(columnIndex).setCellType(Cell.CELL_TYPE_STRING);
                cell = row.getCell(columnIndex).getStringCellValue();
                System.out.print(cell+"  |  ");
            }
            System.out.println();
        }
    }
}
