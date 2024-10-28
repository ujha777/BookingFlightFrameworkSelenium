package gjha123.seleniumframework.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class SignInPage extends AbstractComponenets {
	
	public WebDriver driver;

	public SignInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@aria-label='Sign in']//span[@class='e4adce92df'][normalize-space()='Sign in']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[@title='Sign in with Google']//div[@class='access-panel__social-button-image']//*[name()='svg']")
	WebElement googleSignInButton;
	
	public void clickSignInButton() {
		signInButton.click();
	}
	@FindBy(xpath="//input[@type='email']")
	WebElement emailField;
	
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextButton;

	@FindBy(xpath="//span[normalize-space()='Enter an email or phone number']")
	WebElement enterEmailErrorMessage;

	
	public void clickGoogleSignInButton() {
		try {
			reLoadPage();
			waitForelementToBeVisibileByWebElement(googleSignInButton);
			googleSignInButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void moveToChildWindow() {
		try {
			setMiiliImplicitWait(50);
			reLoadPage();
			switchToChildWindow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void enterEmail(String email) {
		try {
		//	reLoadPage();
			waitForelementToBeVisibileByWebElement(emailField);
			emailField.sendKeys(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickNextButton() throws InterruptedException {
		try {
			//waitForelementToBeVisibileByWebElement(nextButton);
		    setImplicitWait(20);
			nextButton.click();
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getEnterEmailErrorMessage() throws InterruptedException {
		
			waitForelementToBeVisibileByWebElement(enterEmailErrorMessage);
			return enterEmailErrorMessage.getText();
		
		
		
	}
		
	public void moveToParentWindow() {
		switchToParentWindow();
	}
	
	


	

}
