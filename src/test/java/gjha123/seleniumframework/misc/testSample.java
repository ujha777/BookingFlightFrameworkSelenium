package gjha123.seleniumframework.misc;

import java.io.IOException;
import java.util.ArrayList;

import gjha123.seleniumframework.datadriventesting.ExcelReaders;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDrivenTest d = new dataDrivenTest();
	ArrayList<String> data = d.getData("Add Profile");
	System.out.println(data.get(0));
	System.out.println(data.get(1));
	System.out.println(data.get(2));
	System.out.println(data.get(3));
	
	ExcelReaders data1 = new ExcelReaders("src/main/java/gjha123/seleniumframework/resources/PassengerDetails.xlsx");
	Object[][] data2 = data1.getData("src/main/java/gjha123/seleniumframework/resources/PassengerDetails.xlsx", "Passenger1");
	System.out.println(data2[1][0]);
	System.out.println(data2[1][1]);
    System.out.println(data2[2][0]);
    System.out.println(data2[2][1]);
    System.out.println(data2[3][0]);
    System.out.println(data2[3][1]);
    
			

		
		
		

	}

}
