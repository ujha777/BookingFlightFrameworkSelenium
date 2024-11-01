package gjha123.seleniumframework.misc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenTest {


	public ArrayList<String> getData(String testcasename) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("D://ATB7X_SeleniumFrameworkDesign16October//seleniumframework//src//test//java//gjha123//seleniumframework//misc//Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		if (workbook.getSheetName(0).equalsIgnoreCase("Sheet1")) {
			for (int i = 0; i < sheets; i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				//Identify Testcases column by scanning the entire 1st row

				Iterator<Row>  rows = sheet.iterator();// sheet is collection of rows
				Row firstrow= rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
						// desired column
						column = k;
						// after you grab purchase testcase row = pull all the data of that row and feed
						// into test
					}

					k++;
				}
				System.out.println(column);


				//once column is identified then scan entire testcase column to identify purchase testcase row

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						// after you grab purchase testcase row = pull all the data of that row and feed
						// into test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} 
							else {

								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}
					}


					//after you grab purchase testcase row = pull all the data of that row and feed into test
				}
			}

		}

		return a;
	}

}
