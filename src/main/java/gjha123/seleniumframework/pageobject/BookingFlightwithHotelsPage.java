package gjha123.seleniumframework.pageobject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class BookingFlightwithHotelsPage extends AbstractComponenets {
	WebDriver driver;

	public BookingFlightwithHotelsPage(WebDriver driver) {
		//initialize the	driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[contains(text(),'Accept all')]")
	WebElement acceptallpopup;

	//@FindBy(xpath="//label[@id=':R1l36dalqmt2mmH1:']")
	@FindBy(xpath="//label[@id=':Rqhj6latbeimmH1:']")
	//@FindBy(xpath="//label[text()='Destination']")
	WebElement destination;

	@FindBy(xpath="//li[@id='listbox-option-1']//span[@class='d-10pcgf6']")
	WebElement autoSuggestion;

	@FindBy(xpath="//div[@class='d-iy1bge']/button")
	List<WebElement> dates;

	@FindBy(xpath="//button[@class='d-1dupc4x']")		
	WebElement passengerDetails;

	@FindBy(xpath="//button[@class='d-1qjff9m'][2]")
	WebElement adultPassenger;

	@FindBy(xpath="//button[text()='Economy']")
	WebElement economyClass;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;

	By selectCityBy = By.xpath("//li[@id='listbox-option-1']//span[@class='d-10pcgf6']");

	public void clickAcceptAllPopup() {
		clickOnActionElement(acceptallpopup);

	}

	public void enterDestination() {
		reLoadPage();
		clickOnActionElement(destination);
	}

	public void clickAutoSuggestion() {
		waitForelementToBeVisibile(selectCityBy);
		autoSuggestion.click();
	}

	public void clickDates() {
		try {
			dates.stream().filter(d->d.getText().equals(String.valueOf(fromDate()))||d.getText().equals(String.valueOf(toDates()))).forEach(d->d.click());
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	public void clickPassengerDetails() {
		passengerDetails.click();
	}

	public void clickAdultPassenger() {
		// TODO Auto-generated method stub
		adultPassenger.click();
	}

	public void clickEconomyClass() {
		// TODO Auto-generated method stub
		economyClass.click();
	}

	public void clickSubmitButton() {
		// TODO Auto-generated method stub
		submitButton.click();
	}

}