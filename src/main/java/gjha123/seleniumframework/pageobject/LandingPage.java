package gjha123.seleniumframework.pageobject;
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
	
	@FindBy(xpath="//span[text()='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='feaba1002a']")
	WebElement enterDestinationerrorMessage;

	public void clickHotelsLink() {
		//setImplicitWait(20);
		hotelsLink.click();
	}

	public void goToBookingPage() {
		//Close PopUp
		driver.get("https://www.booking.com/");
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public String getEnterDestinationErrorMessage() {
		return enterDestinationerrorMessage.getText();
	}
	

}
