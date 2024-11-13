package gjha123.seleniumframework.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;



public class LandingPage extends  AbstractComponenets{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement hotelsLink=driver.findElement(By.xpath("//a[@id='packages']"));
	//PageFactory
	@FindBy(xpath="//a[@id='packages']")
	WebElement hotelsLink;

	@FindBy(xpath="//a[@id='flights']")
	WebElement flightsLink;

	@FindBy(xpath="//a[@id='attractions']")
	WebElement attractionLink;

	@FindBy(xpath="//span[text()='Search']")
	WebElement searchButton;

	@FindBy(xpath="//div[@class='feaba1002a']")
	WebElement enterDestinationerrorMessage;

	@FindBy(xpath="//*[name()='path' and contains(@d,'m13.31 12 ')]")
	WebElement closepopUp;

	public void clickHotelsLink() {
		//setImplicitWait(20);
		hotelsLink.click();
	}

	public void clickFlightsLink() {
		// setImplicitWait(20);
		flightsLink.click();
	}


	By errormsg=By.xpath("//div[@class='feaba1002a']");

	public void goToBookingPage() {
		//Close PopUp
		driver.get("https://www.booking.com/");
	}

	public void clickAttractionLink() {
		waitForelementToBeVisibileByWebElement(attractionLink);
		attractionLink.click();
					
	}


	public void clickSearchButton() {
		searchButton.click();
		waitForelementToBeVisibile(errormsg);
	}

	public String getEnterDestinationErrorMessage() {
		return enterDestinationerrorMessage.getText();
	}

	public void ClosePopUp() {
		if(closepopUp.isDisplayed()) {
			closepopUp.click();
		}
	}


}
