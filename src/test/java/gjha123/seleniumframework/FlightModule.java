package gjha123.seleniumframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import gjha123.seleniumframework.basetest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class FlightModule extends BaseTest {

	@Test
	@Owner("Gangesh Jha")
	@Description("Search Flight")
	@Severity(SeverityLevel.CRITICAL)
	public void TC_01_searchFlight() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//a[@id='flights']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> tripCheckBox = driver.findElements(By.xpath("//div/fieldset/div/div"));
		wait.until(webDriver -> tripCheckBox.size() > 0);
		tripCheckBox.get(1).click();
		driver.findElement(By.xpath("//span[@class='InputCheckbox-module__field___zzbj4']")).click();
		WebElement toCity = driver.findElement(By.xpath("//span[2]/span/span[text()='Where to?']"));
		toCity.click();
		driver.findElement(By.xpath("//input[@placeholder='Airport or city']")).sendKeys("Kolkata");
		WebElement selCheckBox = driver.findElement(By.xpath("//li/span[3]/div/input[@type='checkbox']"));
		selCheckBox.click();
		// selCheckBox.sendKeys(Keys.ENTER);
		WebElement departureDate = driver.findElement(By.xpath("//button[@placeholder='Choose departure date']"));
		departureDate.click();
		LocalDate currentDate = LocalDate.now();

		// Get the current date
		LocalDate fd = currentDate.plusDays(7);
		int fromDate = fd.getDayOfMonth();
		List<WebElement> fromDates = driver.findElements(By.xpath("//div/table/tbody/tr/td[@role]"));
		fromDates.stream().filter(date -> date.getText().equals(String.valueOf(fromDate))).findFirst().get().click();
		// for (WebElement fromdate : fromDates) {
		// if (fromdate.getText().equals(String.valueOf(fromDate))) {
		// fromdate.click();
		// //break;
		// }
		driver.findElement(By.xpath("//span/span[normalize-space()='1 adult']")).click();
		driver.findElement(By.xpath("//div[@data-ui-name='occupancy_adults']/div[2]/button[2]")).click();
		driver.findElement(By.xpath("//div[@data-ui-name='occupancy_children']/div[2]/button[2]")).click();
		WebElement ageDropDown = driver.findElement(By.xpath("//select[@class='InputSelect-module__field___tLmBd']"));
		// ageDropDown.click();
		Select age = new Select(ageDropDown);
		age.selectByIndex(4);
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(2000);
		WebElement fastestTab = driver.findElement(By.xpath("//button[@id='TAB-FASTEST']"));
		wait.until(ExpectedConditions.visibilityOf(fastestTab));
		fastestTab.click();
		WebElement Ticketpricedetails = driver
				.findElement(By.xpath("//div[@id='flight-card-0']//span[normalize-space()='View details']"));
		Ticketpricedetails.click();
		driver.findElement(By.xpath("//span[text()='Select']")).click();
		driver.findElement(By.xpath("//input[@value='standard']")).click();
		try {

			WebElement nextButton = driver
					.findElement(By.xpath("//div[@data-testid='checkout_ticket_type_inner_next']"));
			wait.until(webDriver -> nextButton.isEnabled());
			nextButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> PassengerList = driver
				.findElements(By.xpath("//div[@data-testid='checkout_form_card_contact_details']//div[2]/button[1]"));
		for (WebElement passenger : PassengerList) {
			Thread.sleep(100);
			System.out.println(passenger.getText());
			passenger.click();
		//	WebElement adultype = driver.findElement(By.xpath("//h2[contains(text(),'Adult')]"));
			 WebElement requiredtitle = driver.findElement(By.xpath("//div/span[contains(text(),'*')]"));
		//	WebElement requiredtitle=driver.findElement(By.xpath("//div[@class='SheetContainer-module__content___aKVJ9']"));
		//	if (adultype.getText().equalsIgnoreCase("Adult 1")||adultype.getText().equalsIgnoreCase("Adult 2")) {
				if (requiredtitle.getText().contains("*")) {
				try {
					//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					// System.out.println("Adult"+adultype.getText());
					WebElement FirstName = driver.findElement(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
					wait.until(ExpectedConditions.visibilityOf(FirstName));
					FirstName.sendKeys("Gangesh");
					WebElement LastName = driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
					wait.until(ExpectedConditions.visibilityOf(LastName));
					LastName.sendKeys("Jha");
					WebElement va = driver.findElement(By.xpath("//div[3]/div/label/span"));
					//				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[8]//div[2]/div/div[3]/div/label/span[1]")));
					if (va.isDisplayed()) {
						System.out.println(va.getText());;
					}

					List<WebElement> dropdown = driver.findElements(By.xpath("//select[@class='InputSelect-module__field___tLmBd']"));
					for (WebElement webElement : dropdown) {
						//Select genderSelect = new Select(webElement);
						WebElement male = webElement.findElement(By.xpath("//option[@value='male']"));
						wait.until(ExpectedConditions.elementToBeClickable(male));
						male.click();

						WebElement month=webElement.findElement(By.xpath("//option[@value='05']"));
						wait.until(ExpectedConditions.elementToBeClickable(month));
						month.click();
					}


					WebElement dd = driver.findElement(By.xpath("//input[@placeholder='DD']"));
					//wait.until(ExpectedConditions.visibilityOf(dd));
					dd.sendKeys("08");

					WebElement yy = driver.findElement(By.xpath("//input[@placeholder='YYYY']"));
					//wait.until(ExpectedConditions.visibilityOf(yy));
					yy.sendKeys("1990");
					driver.findElement(By.xpath("//span[text()='Done']")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		        
		        
		}
		//Thread.sleep(2000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the bottom of the page
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ujha777@gmail.com");
        driver.findElement(By.xpath("//input[@name='number']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
		// FirstName.sendKeys("Gangesh");

	}
}
