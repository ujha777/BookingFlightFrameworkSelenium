package gjha123.seleniumframework.pageobject.FilghtModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class SelectTicketTypePage extends AbstractComponenets {
	WebDriver driver;
	public SelectTicketTypePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='standard']")
	WebElement SelectstandardradioButton;
	
	@FindBy(xpath="//div[@data-testid='checkout_ticket_type_inner_next']")
	WebElement NextButton;
	
	public void clickSelectStandardRadioButton() {
		SelectstandardradioButton.click();
	}
	
	public void clickNextButton() {
		try {
			waitForelementToBeVisibileByWebElement(NextButton);
			NextButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
