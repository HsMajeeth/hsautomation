package dataProvider;

import utilities.NewExcelLibrary;
import org.testng.annotations.DataProvider;
public class DataProviderClass {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	
	@DataProvider(name = "HolidayProvider")
	public static Object[][] getHolidayData() {
	    String fileName ="Merchant Test datas"; // Example file name
	    String sheetName = "Holiday"; // Specify the sheet name dynamically
	    return NewExcelLibrary.getExcelDataFromSheet(fileName, sheetName);
	}
		
		
	@DataProvider(name="Holidaysearchdata")
   public static Object[][] gettheserchHoliday(){
	   String fileName ="Merchant Test datas"; // Example file name
	    String sheetName = "Holiday search data"; // Specify the sheet name dynamically
	    return NewExcelLibrary.getExcelDataFromSheet(fileName, sheetName);

	   
   }
	@DataProvider(name="Emaildata")
	   public static Object[][] gettheEmaildata(){
		   String fileName ="Merchant Test datas"; // Example file name
		    String sheetName = "Emails"; // Specify the sheet name dynamically
		    return NewExcelLibrary.getExcelDataFromSheet(fileName, sheetName);

}
}
