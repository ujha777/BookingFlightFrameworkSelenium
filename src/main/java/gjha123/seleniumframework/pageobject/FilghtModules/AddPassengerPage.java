package gjha123.seleniumframework.pageobject.FilghtModules;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class AddPassengerPage extends AbstractComponenets {
	WebDriver driver;
	public AddPassengerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-testid='grouped_inputs_traveller_1']/div[1]/div[1]")
	WebElement TravellerNum1;
	
	@FindBy(xpath="//div[@data-testid='grouped_inputs_traveller_2']/div[1]/div[1]")
	WebElement TravellerNum2;
	

    @FindBy(xpath="//div[@data-testid='grouped_inputs_traveller_3']/div[1]/div[1]")
    WebElement TravellerNum3;
    
    
    @FindBy(xpath="//div[@data-testid='grouped_inputs_traveller_1']/div[1]/div[2]/button")
    WebElement ClickOnPassenger1;
    
    @FindBy(xpath="//div[@data-testid='grouped_inputs_traveller_2']/div[1]/div[2]/button")
    WebElement ClickOnPassenger2;
    
	@FindBy(xpath="//div[@data-testid='grouped_inputs_traveller_3']/div[1]/div[2]/button")
	WebElement ClickOnPassenger3;
    
	public void ClickOnPassenger1(String fn, String ln,String day,String year,String genderType,String monthtype) {
		if(TravellerNum1.getText().contains("Adult 1")) {
			ClickOnPassenger1.click();
			try {
				AddAllPassengerPage addallPassenger = new AddAllPassengerPage(driver);
				addallPassenger.enterPassengerDetails(fn,ln);			
				addallPassenger.enterGender(genderType);
				addallPassenger.enterMonth(monthtype);
				addallPassenger.enterDateOfBirth(day,year);			
				addallPassenger.clickDone();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void ClickOnPassenger2(String fn, String ln,String day,String year,String genderType,String monthtype) {
		if(TravellerNum2.getText().contains("Adult 2")) {
		ClickOnPassenger2.click();
		try {
			AddAllPassengerPage addallPassenger = new AddAllPassengerPage(driver);
			addallPassenger.enterPassengerDetails(fn,ln);			
			addallPassenger.enterGender(genderType);
			addallPassenger.enterMonth(monthtype);
			addallPassenger.enterDateOfBirth(day,year);			
			addallPassenger.clickDone();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void ClickOnPassenger3(String fn, String ln,String day,String year,String genderType,String monthtype) {
	
		if(TravellerNum3.getText().contains("Child 1")) {
			ClickOnPassenger3.click();
			try {
				AddAllPassengerPage addallPassenger = new AddAllPassengerPage(driver);
				addallPassenger.enterPassengerDetails(fn,ln);			
				addallPassenger.enterGender(genderType);
				addallPassenger.enterMonth(monthtype);
				addallPassenger.enterDateOfBirth(day,year);			
				addallPassenger.clickDone();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@name='number']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement NextButton;
	
	public void enterEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void enterPhoneNumber(String phone) {
		PhoneNumber.sendKeys(phone);
	}
	
	public void clickNextButton() {
		NextButton.click();
	}
	
   
	
	

}
