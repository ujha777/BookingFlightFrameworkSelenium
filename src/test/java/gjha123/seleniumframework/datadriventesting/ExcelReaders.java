
package gjha123.seleniumframework.datadriventesting;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReaders {
    private String filePath;
    public ExcelReaders(String filePath) {
        this.filePath = filePath;
    }
    DataFormatter formatter = new DataFormatter();
    public Object[][] getData(String filePath,String workSheetName) throws IOException {
		//String testDataFile = "src/main/java/gjha123/seleniumframework/resources/PassengerDetails.xlsx";
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/" +filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet workSheet = workbook.getSheet(workSheetName);
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
