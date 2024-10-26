package gjha123.seleniumframework.abstractComponents;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponenets {
	WebDriver driver;
	Actions actions;
	LocalDate currentDate = LocalDate.now();
	public AbstractComponenets(WebDriver driver) {
	// TODO Auto-generated constructor stub
	    this.driver = driver;
	    this.actions = new Actions(driver);
	}

	
	public void setMiiliImplicitWait(int miiliSec) throws InterruptedException {
        Thread.sleep(miiliSec);
    }
	
	public void waitForelementToBeVisibile(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated((findby)));
	}
	
	public void reLoadPage() {
		driver.navigate().refresh();
	}
	
	public void clickOnActionElement(WebElement element) {	
		actions.click(element).build().perform();
	}
	
	public int fromDate() {
		// Get the current date
		LocalDate fd = currentDate.plusDays(2);
		int fromDate = fd.getDayOfMonth();
        return fromDate;
	}
	
	public int toDates() {
		LocalDate addedDays = currentDate.plusDays(7);
		int toDates = addedDays.getDayOfMonth();
		return toDates;
	}
	
}
