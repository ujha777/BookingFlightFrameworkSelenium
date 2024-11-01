package gjha123.seleniumframework.misc;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class excelDataProvider {
	
	
	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider="passengerDetails")
	public void testcaseData(String firstname,String lastname) throws IOException {
		
		System.out.println("First Name: "+firstname+" Last Name: "+lastname);
		
	}
	@DataProvider(name="passengerDetails")
	public Object[][] getData() throws IOException {
		String testDataFile = "src/main/java/gjha123/seleniumframework/resources/PassengerDetails.xlsx";
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/" +testDataFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet workSheet = workbook.getSheet("FlightModulePassengerDetails");
		int noOfRows = workSheet.getPhysicalNumberOfRows();
		XSSFRow row= workSheet.getRow(0);
		int colcount = row.getLastCellNum();
		Object[][] data = new Object[noOfRows-1][colcount];
		for (int i = 0; i < noOfRows-1; i++) {
			row=workSheet.getRow(i+1);
			for (int j = 0; j < colcount; j++) {
				//System.out.println(row.getCell(j));
				XSSFCell cell = row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);

			}
		}
		return data;
	}

}
