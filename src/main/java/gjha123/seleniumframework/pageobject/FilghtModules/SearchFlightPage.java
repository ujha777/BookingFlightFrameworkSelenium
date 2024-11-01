package gjha123.seleniumframework.pageobject.FilghtModules;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class SearchFlightPage extends AbstractComponenets {
	WebDriver driver;
	public SearchFlightPage(WebDriver driver){	
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);// TODO Auto-generated constructor stub
	} 
	
	@FindBy(xpath="//div/fieldset/div/div")
	List<WebElement> tripCheckBox;
		
    @FindBy(xpath="//span[@class='InputCheckbox-module__field___zzbj4']")
    WebElement Direct_flight_onlyCheckbox;

    @FindBy(xpath="//span[2]/span/span[text()='Where to?']")
    WebElement toCity;
	
    @FindBy(xpath="//input[@placeholder='Airport or city']")
    WebElement toCityInput;
    
    @FindBy(xpath="//li/span[3]/div/input[@type='checkbox']")
    WebElement selCheckBox;

    @FindBy(xpath="//button[@placeholder='Choose departure date']")
    WebElement departureDate;
    
    @FindBy(xpath="//div/table/tbody/tr/td[@role]")
    List<WebElement> fromDates;
    
    @FindBy(xpath="//span/span[normalize-space()='1 adult']")
    WebElement adult;
    
    @FindBy(xpath="//div[@data-ui-name='occupancy_adults']/div[2]/button[2]")
    WebElement adultPlus;
    
    @FindBy(xpath="//div[@data-ui-name='occupancy_children']/div[2]/button[2]")
    WebElement childPlus;
    
    @FindBy(xpath="//select[@class='InputSelect-module__field___tLmBd']")
    WebElement ageDropDown;
    
    @FindBy(xpath="//span[text()='Done']")
    WebElement done;
    
    @FindBy(xpath="//span[text()='Search']")
    WebElement searchButton;
    
  
	public void clickTripCheckBox() {
		waitForelementToBeVisibileByWebElement(tripCheckBox.get(1));
		tripCheckBox.get(1).click();
	}
	
	public void clickDirect_flight_onlyCheckbox() {
		Direct_flight_onlyCheckbox.click();
	}
	
	public void clickToCity() {
		toCity.click();
	}
	
	public void enterToCity(String city) {
		toCityInput.sendKeys(city);
	}

	public void clickSelCheckBox() {
		selCheckBox.click();
	}
	
	public void clickDepartureDate() {
		departureDate.click();
	}
	
	public void clickFromDate() {		
		fromDates.stream().filter(date -> date.getText().equals(String.valueOf(fromDate(7)))).findFirst().get().click();
	}
	
	public void clickAdult() {
		adult.click();
	}
	
	public void clickAdultPlus() {
		adultPlus.click();
	}
	
	public void clickChildPlus() {
		childPlus.click();
	}
	
	public void selectAge() {
		selectByIndex(ageDropDown, 4);
	}
	
	public void clickDone() {
		done.click();
	}
	
	public void clickSearchButton() throws InterruptedException {
		searchButton.click();
		setMiiliImplicitWait(2000);
	}
	
	
	


}
