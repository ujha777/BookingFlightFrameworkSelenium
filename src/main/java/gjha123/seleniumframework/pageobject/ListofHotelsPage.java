package gjha123.seleniumframework.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class ListofHotelsPage extends AbstractComponenets {
	WebDriver driver;
	public ListofHotelsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='sc-928ccd0e-0 dAlzUa']/div/a[2]/div[1]/div[1]")
	List<WebElement> searchResults;
	
	public void selectHotel() throws InterruptedException {
		searchResults.stream().filter(hotel -> hotel.getText().contains("Hotel")).findFirst().get().click();
		setMiiliImplicitWait(2000);
	}

}
