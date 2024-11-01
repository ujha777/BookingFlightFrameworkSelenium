package gjha123.seleniumframework.pageobject.FilghtModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class SelectFlightPage extends AbstractComponenets {
	WebDriver driver;
	public SelectFlightPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Select']")
	WebElement selectButton;
	
	
	public void clickSelectButton() {
		waitForelementToBeVisibileByWebElement(selectButton);
		selectButton.click();
	}
	
	

}
