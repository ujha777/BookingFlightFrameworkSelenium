
package gjha123.seleniumframework;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import gjha123.seleniumframework.basetest.BaseTest;
import gjha123.seleniumframework.datadriventesting.ExcelReaders;
import gjha123.seleniumframework.pageobject.FilghtModules.AddAllPassengerPage;
import gjha123.seleniumframework.pageobject.FilghtModules.AddPassengerPage;
import gjha123.seleniumframework.pageobject.FilghtModules.ListOfFlightPage;
import gjha123.seleniumframework.pageobject.FilghtModules.SearchFlightPage;
import gjha123.seleniumframework.pageobject.FilghtModules.SeatSelectionPage;
import gjha123.seleniumframework.pageobject.FilghtModules.SelectFlightPage;
import gjha123.seleniumframework.pageobject.FilghtModules.SelectTicketTypePage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class FlightModule extends BaseTest {
	
	@Test(dataProvider="passengerDetails")
	@Owner("Gangesh Jha")
	@Description("Search Flight")
	@Severity(SeverityLevel.CRITICAL)
	public void TC_01_searchFlight(String fn,String ln) throws InterruptedException, AWTException {
		landingPage.ClosePopUp();
		landingPage.clickFlightsLink();
		SearchFlightPage searchFlightPage = new SearchFlightPage(driver);
		searchFlightPage.clickTripCheckBox();
		searchFlightPage.clickDirect_flight_onlyCheckbox();
		searchFlightPage.clickToCity();
		searchFlightPage.enterToCity("Kolkata");
		searchFlightPage.clickSelCheckBox();
		searchFlightPage.clickDepartureDate();
		searchFlightPage.clickFromDate();
		searchFlightPage.clickAdult();
		searchFlightPage.clickAdultPlus();
		searchFlightPage.clickChildPlus();
		searchFlightPage.selectAge();
		searchFlightPage.clickDone();
		searchFlightPage.clickSearchButton();

		ListOfFlightPage listOfFlightPage = new ListOfFlightPage(driver);
		listOfFlightPage.clickFastestTab();
		listOfFlightPage.clickTicketPriceDetails();

		SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
		selectFlightPage.clickSelectButton();

		SelectTicketTypePage selectTicketTypepage = new SelectTicketTypePage(driver);
		selectTicketTypepage.clickSelectStandardRadioButton();
		selectTicketTypepage.clickNextButton();
		
		AddPassengerPage addPassengerPage = new AddPassengerPage(driver);
		addPassengerPage.ClickOnPassenger1(fn, ln,"04","1985","male","April");
		addPassengerPage.ClickOnPassenger2("Pooja", "Mishra","04","1989","female","November");
		addPassengerPage.ClickOnPassenger3("Darshit", "Jha","06","2020","male","August");
		addPassengerPage.enterEmail("ujha77@gmail.com");
		addPassengerPage.enterPhoneNumber("1234567890");
		addPassengerPage.clickNextButton();
		
		SeatSelectionPage seatSelectionPage = new SeatSelectionPage(driver);
		seatSelectionPage.getSelectSeat();
		seatSelectionPage.getClose();
		seatSelectionPage.getSkip();
		


	}
	
 	@DataProvider(name="passengerDetails")
	public Object[][] getDataProvider() throws IOException {
		String testDataFile = "src/main/java/gjha123/seleniumframework/resources/PassengerDetails.xlsx";
		ExcelReaders excelReader = new ExcelReaders(testDataFile);
	Object[][] data1= excelReader.getData(testDataFile, "Passenger1");
	
	return data1;
		
		
	}
 	
	


}



