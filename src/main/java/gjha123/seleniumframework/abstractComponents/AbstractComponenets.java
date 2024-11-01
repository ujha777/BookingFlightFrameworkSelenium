package gjha123.seleniumframework.abstractComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponenets {
	WebDriver driver;
	Actions actions;
	LocalDate currentDate = LocalDate.now();
	String parentWindow;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	public AbstractComponenets(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.actions = new Actions(driver);
	}
	public void setImplicitWait(int timeSec) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSec));
	}

	public void setMiiliImplicitWait(int miiliSec) throws InterruptedException {
		Thread.sleep(miiliSec);
	}

	public void waitForelementToBeVisibile(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated((findby)));
	}

	public void waitForelementToBeVisibileByWebElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements((element)));
	}

	public void waitForelementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable((element)));
	}



	public void reLoadPage() {
		driver.navigate().refresh();
	}

	public void clickOnActionElement(WebElement element) {	
		actions.click(element).build().perform();
	}

	public void clickOnActionElementDropDown(WebElement element) {	
		actions.click(element).sendKeys("Bali").build().perform();
	}

	public int fromDate() {
		// Get the current date
		LocalDate fd = currentDate.plusDays(2);
		int fromDate = fd.getDayOfMonth();
		return fromDate;
	}

	public int fromDate(int days) {
		// Get the current date
		LocalDate fd = currentDate.plusDays(days);
		int fromDate = fd.getDayOfMonth();
		return fromDate;
	}

	public int toDates() {
		LocalDate addedDays = currentDate.plusDays(7);
		int toDates = addedDays.getDayOfMonth();
		return toDates;
	}

	public void switchToChildWindow() {
		parentWindow = driver.getWindowHandle();
		for (String childWindow : driver.getWindowHandles()) {
			driver.switchTo().window(childWindow);
		}
	}

	public void switchToParentWindow() {
		driver.switchTo().window(parentWindow);
	}

	public void selectByIndex(WebElement element, int index) {
		Select dropDown = new Select(element);
		dropDown.selectByIndex(index);
	}

	public void scrollBottom() throws AWTException {
		// Stating the Javascript Executor driver
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		// Scroll to bottom of page
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}


	public void scrollToTheSpecificElement(WebElement element) {
		// Stating the Javascript Executor driver
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// Scroll to the specific element
		js.executeScript("arguments[0].scrollIntoView();", element);
	}


}
