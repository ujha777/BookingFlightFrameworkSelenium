package gjha123.seleniumframework;

import java.awt.AWTException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import gjha123.seleniumframework.basetest.BaseTest;
import gjha123.seleniumframework.pageobject.BookingFlightwithHotelsPage;
import gjha123.seleniumframework.pageobject.HotelsDetailsPage;
import gjha123.seleniumframework.pageobject.ListofHotelsPage;
import gjha123.seleniumframework.pageobject.ViewRoomPage;


public class BookingFlights extends BaseTest {
	WebDriverWait wait;
	@Test(priority=1)
	public void searchFlightwithInvalidData() throws InterruptedException, AWTException {
		// Navigate to the Hotels section:
		landingPage.clickSearchButton();
		String errorEnterDestinationMessage = landingPage.getEnterDestinationErrorMessage();
		System.out.println(errorEnterDestinationMessage);
		Assert.assertEquals(errorEnterDestinationMessage, "Enter a destination to start searching.");
		//Close PopUp
		
	}
	@Test(priority=2)
	public void bookingFlightWithHotels() throws InterruptedException, AWTException {
		// Navigate to the Hotels section:
		landingPage.clickHotelsLink();
		//Close PopUp
		BookingFlightwithHotelsPage bookingFlightwithHotelsPage = new BookingFlightwithHotelsPage(driver);
		bookingFlightwithHotelsPage.clickAcceptAllPopup();
		//Enter destination city		
		bookingFlightwithHotelsPage.enterDestination();
		bookingFlightwithHotelsPage.clickAutoSuggestion();
		//Enter the travel dates
		bookingFlightwithHotelsPage.clickDates();
		//Enter number of passenger details
		bookingFlightwithHotelsPage.clickPassengerDetails();
		bookingFlightwithHotelsPage.clickAdultPassenger();
		//Select Economy class			
		bookingFlightwithHotelsPage.clickEconomyClass();
		//Click on Search
		bookingFlightwithHotelsPage.clickSubmitButton();
		//Choose a hotel from the search results:
		ListofHotelsPage listofHotelsPage = new ListofHotelsPage(driver);
		listofHotelsPage.selectHotel();
		//Thread.sleep(2000);
		//Select Room
		HotelsDetailsPage hotelsDetailsPage = new HotelsDetailsPage(driver);
		hotelsDetailsPage.SelectRoomImagePic();	    
		// Get the current mouse position
		ViewRoomPage viewRoomPage = new ViewRoomPage(driver);
		viewRoomPage.selectRoom();		
		Thread.sleep(1000);
		//Select Continue
		viewRoomPage.clickContinueAfterSelectingRoom();
		//Select passenger detail

	}
}