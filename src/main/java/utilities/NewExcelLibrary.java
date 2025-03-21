package utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewExcelLibrary {


	public static String[][] getExcelDataFromSheet(String fileName, String sheetName) {
		
	        XSSFWorkbook workbook = null;
	        String[][] data = null;

	        try {
	        	
	        	
	            // Load the workbook
	            workbook = new XSSFWorkbook("./src/test/resources/Test Data/"+ fileName + ".xlsx");
	            

	            // Get the specified sheet by name
	            XSSFSheet sheet = workbook.getSheet(sheetName);

	            if (sheet == null) {
	                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the workbook.");
	            }

	            // Get row and column counts
	            int lastRowNum = sheet.getLastRowNum();
	            int lastCellNum = sheet.getRow(0).getLastCellNum();

	            // Initialize the 2D array to store the data
	            data = new String[lastRowNum][lastCellNum];

	            // Iterate through rows and columns to populate the array
	            for (int i = 1; i <= lastRowNum; i++) { // Skip the header row
	                XSSFRow row = sheet.getRow(i);
	                for (int j = 0; j < lastCellNum; j++) {
	                    XSSFCell cell = row.getCell(j);
	                    DataFormatter formatter = new DataFormatter();
	                    String value = formatter.formatCellValue(cell);
	                    data[i - 1][j] = value;
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (workbook != null) {
	                try {
	                    workbook.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        return data;
	    }
}


