package gjha123.seleniumframework.pageobject.AttractionsModule;

import java.awt.AWTException;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class LocationPage extends AbstractComponenets {
	WebDriver driver;
	public LocationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//div[4]/div[3]/div[2]/button")
	WebElement selectTickets;
	
	@FindBy(xpath = "//div[@class='bfb38641b0']/button[2]")
	WebElement numberofAdults;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextButton;
	


	public void clickSelectTickets() throws AWTException, InterruptedException {
		scrollBottom();
		setMiiliImplicitWait(5000);
		try {
			switchToChildWindow();
			if (driver.getWindowHandles().size() > 0) {
			waitForelementToBeClickable(selectTickets);
			selectTickets.click();
			}
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exception occurred: " + e.getMessage());
		} catch (TimeoutException e) {
			System.out.println("Timeout exception occurred: " + e.getMessage());
		}
		
	}
	public void selectNumberOfAdults() {
		waitForelementToBeClickable(numberofAdults);
		numberofAdults.click();
	}

	public void clickNextButton() {
		try {
			switchToChildWindow();
			if (driver.getWindowHandles().size() > 0) {
			waitForelementToBeClickable(nextButton);
			nextButton.click();
			}
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exception occurred: " + e.getMessage());
		} catch (TimeoutException e) {
			System.out.println("Timeout exception occurred: " + e.getMessage());
		}
	}




}
