package gjha123.seleniumframework.pageobject.FilghtModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class ListOfFlightPage extends AbstractComponenets {
	WebDriver driver;
	public ListOfFlightPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='TAB-FASTEST']")
	WebElement fastestTab;
	
	@FindBy(xpath="//div[@id='flight-card-0']//span[normalize-space()='View details']")
	WebElement Ticketpricedetails;
	
	
	public void clickFastestTab() {
		waitForelementToBeVisibileByWebElement(fastestTab);
		fastestTab.click();
	}
	
	public void clickTicketPriceDetails() {
		waitForelementToBeVisibileByWebElement(Ticketpricedetails);
		Ticketpricedetails.click();
	}
}
