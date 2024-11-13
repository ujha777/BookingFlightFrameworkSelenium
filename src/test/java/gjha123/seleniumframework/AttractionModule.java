
package gjha123.seleniumframework;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.DataProvider;
import gjha123.seleniumframework.basetest.BaseTest;
import gjha123.seleniumframework.datadriventesting.PropertyReadersUtils;
import gjha123.seleniumframework.pageobject.AttractionsModule.LocationPage;
import gjha123.seleniumframework.pageobject.AttractionsModule.ResultAttractionPage;
import gjha123.seleniumframework.pageobject.AttractionsModule.SearchAttractionPage;
import gjha123.seleniumframework.pageobject.AttractionsModule.PassengerEntryPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AttractionModule extends BaseTest {

	@DataProvider(name = "destinationProvider")
	public Object[][] destinationProvider() throws Exception {
		return new Object[][] {
			{
				PropertyReadersUtils.readyKey("FirstName"),
				PropertyReadersUtils.readyKey("LastName"),
				PropertyReadersUtils.readyKey("Email"),
				PropertyReadersUtils.readyKey("PhoneNumber"),
				PropertyReadersUtils.readyKey("destination")
			}
		};
	}

	@Test(dataProvider = "destinationProvider")
	@Owner("Gangesh Jha")
	@Description("Search Attraction")
	@Severity(SeverityLevel.CRITICAL)
	public void TC_01_searchAttraction(String fn, String ln, String email, String phn, String destination) throws InterruptedException, InvocationTargetException, AWTException, SocketException {
		try {
			landingPage.ClosePopUp();
			landingPage.clickAttractionLink();
			SearchAttractionPage searchAttractionPage = new SearchAttractionPage(driver);
			searchAttractionPage.clickOnDestination(destination);
			searchAttractionPage.enterDestination();
			searchAttractionPage.ClickOnDates();
			searchAttractionPage.selectDateRange();
			searchAttractionPage.clickSearchButton();
			ResultAttractionPage resultAttractionPage = new ResultAttractionPage(driver);
			resultAttractionPage.selectCategory();
			resultAttractionPage.selectPriceRange();
			resultAttractionPage.showResults();
			resultAttractionPage.selectReviewScore();
			resultAttractionPage.selectTimePeriod();
			resultAttractionPage.selectLanguage();
			resultAttractionPage.selectBestReviewed();
			resultAttractionPage.clickSeeAvailability();
			LocationPage locationPage = new LocationPage(driver);
			locationPage.clickSelectTickets();
			locationPage.selectNumberOfAdults();
			locationPage.clickNextButton();
			PassengerEntryPage passengerEntryPage = new PassengerEntryPage(driver);
			passengerEntryPage.enterPassengerDetails(fn, ln, email, phn);
			passengerEntryPage.provideLocation();
			passengerEntryPage.selectLocation();
			passengerEntryPage.selectDOB();
			passengerEntryPage.FullFisrtName();
			passengerEntryPage.FullLastName();
			passengerEntryPage.clickSubmitButton();
		} catch (NoSuchElementException e) {
			System.out.println("No such element exception occurred: " + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable exception occurred: " + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriver exception occurred: " + e.getMessage());
		}
	}
}
