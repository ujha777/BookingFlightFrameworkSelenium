package gjha123.seleniumframework.pageobject.AttractionsModule;

import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class PassengerEntryPage extends AbstractComponenets {
	WebDriver driver;
	public PassengerEntryPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//div[@class='e000754250']/input[@name='firstName']")
	WebElement FirstName;

	@FindBy(xpath="//div[@class='e000754250']/input[@name='lastName']")
	WebElement LastName;

	@FindBy(xpath="//div[@class='e000754250']/input[@name='email']")
	WebElement Email;

	@FindBy(xpath="//div[@class='e000754250']/input[@name='phone__number']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//input[@data-testid='location-input']")
	WebElement Providelocation;
	
	@FindBy(xpath="//div[@class='css-kjuo6s']/ul[1]/li")
	List<WebElement> SelectLocation;

	@FindBy(xpath="//h3[text()='Adult']")
	WebElement AdultText;

	@FindBy(xpath="//input[@placeholder='DD']")
	WebElement dd;

	// @FindBy(xpath="//option[@value='05']")
	@FindBy(xpath="//input[@placeholder='MM']")
	WebElement month;

	@FindBy(xpath="//input[@placeholder='YYYY']")
	WebElement yy;
	
	@FindBy(xpath="//input[@id='OIyZRpm3t4XA--0--FULL_NAMES_FIRST']")
	WebElement FullFisrtName;
	
	@FindBy(xpath="//input[@id='OIyZRpm3t4XA--0--FULL_NAMES_LAST']")
	WebElement FullLastName;
	
	@FindBy(xpath="//span[contains(text(),'Payment details')]")
	WebElement submitButton;


	public void enterPassengerDetails(String fn, String ln, String email, String phone) {
		try {
			//waitForelementToBeClickable(FirstName);
			FirstName.sendKeys(fn);
			//waitForelementToBeClickable(LastName);
			LastName.sendKeys(ln);
			//waitForelementToBeClickable(Email);
			Email.sendKeys(email);
			//waitForelementToBeClickable(PhoneNumber);
			PhoneNumber.sendKeys(phone);
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exception occurred: " + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable exception occurred: " + e.getMessage());
		}  catch (TimeoutException e) {
			System.out.println("Timeout exception occurred: " + e.getMessage());
		}
	}

	public void selectDOB() {
		scrollToSpecificElementUsingAction(AdultText);
	//	waitForelementToBeClickable(dd);
		dd.sendKeys("08");
	//	waitForelementToBeClickable(month);
		month.sendKeys("05");
    // 	waitForelementToBeClickable(yy);
		yy.sendKeys("1990");
	}

	public void FullFisrtName() {
	//	waitForelementToBeClickable(FullFisrtName);
		FullFisrtName.sendKeys("Gangesh");
	}
	
	public void FullLastName() {
	//	waitForelementToBeClickable(FullLastName);
		FullLastName.sendKeys("Jha");
	}
	
	public void clickSubmitButton() {
	//	waitForelementToBeClickable(submitButton);
		submitButton.click();
	}
	
	public void provideLocation() {
		Providelocation.click();
	}
	
	public void selectLocation() {
		SelectLocation.stream().filter(e -> e.getText().contains("Hotel Moon")).findAny().get().click();
	}



}
