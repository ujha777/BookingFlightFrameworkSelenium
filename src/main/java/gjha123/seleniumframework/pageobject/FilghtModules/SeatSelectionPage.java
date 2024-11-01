package gjha123.seleniumframework.pageobject.FilghtModules;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class SeatSelectionPage extends AbstractComponenets {
	WebDriver driver;
	public SeatSelectionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Select seats from INR0.00')]")
	WebElement selectSeat;
	
	@FindBy(xpath="//span[text()='Close']")
	WebElement close;
	
	@FindBy(xpath="//span[text()='Skip']")
	WebElement skip;
	public void getSelectSeat() {
		selectSeat.click();
	}
	
	public void getClose() throws AWTException {
		scrollBottom();
		waitForelementToBeClickable(close);
		close.click();
	}
	
	public void getSkip() {
		skip.click();
	}
	
	


	

}
