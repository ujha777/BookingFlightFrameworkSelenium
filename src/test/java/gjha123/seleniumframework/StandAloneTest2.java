
package gjha123.seleniumframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest2 {
	WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Navigate to the Hotels section:
		WebElement hotelsLink = driver.findElement(By.xpath("//a[@id='packages']"));
		hotelsLink.click();

		// Close PopUp
		WebElement acceptall = driver.findElement(By.xpath("//button[contains(text(),'Accept all')]"));
		Actions act = new Actions(driver);
		act.moveToElement(acceptall).click().build().perform();
		driver.navigate().refresh();
		// Enter destination city
		WebElement destination = driver.findElement(By.xpath("//label[@id=':Rqhj6latbeimmH1:']"));
		Actions actions = new Actions(driver);
		
		actions.moveToElement(destination).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@id='listbox-option-1']//span[@class='d-10pcgf6']")));
		WebElement autoSuggestion = driver
				.findElement(By.xpath("//li[@id='listbox-option-1']//span[@class='d-10pcgf6']"));
		
		autoSuggestion.click();

		
		// Enter the travel dates
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='d-iy1bge']/button"));

		// Get the current date
		LocalDate currentDate = LocalDate.now();
		LocalDate fd = currentDate.plusDays(2);
		int fromDate = fd.getDayOfMonth();

		LocalDate addedDays = currentDate.plusDays(7);
		int toDates = addedDays.getDayOfMonth();

		try {
			for (WebElement currentdates : dates) {
				if (currentdates.getText().equals(String.valueOf(fromDate))
						|| currentdates.getText().equals(String.valueOf(toDates))) {
					currentdates.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
        
		// Enter number of passenger details
		driver.findElement(By.xpath("//button[@class='d-1dupc4x']")).click();
		driver.findElement(By.xpath("//button[@class='d-1qjff9m'][2]")).click();
		driver.findElement(By.xpath("//button[text()='Economy']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Choose a hotel from the search results:
		List<WebElement> searchResults = driver
				.findElements(By.xpath("//div[@class='sc-928ccd0e-0 dAlzUa']/div/a[2]/div[1]/div[1]"));
		for (WebElement listofHotel : searchResults) {
			if (listofHotel.getText().equals("Kamaniiya Petitenget Seminyak")) {
				listofHotel.click();
			}
		}

		Thread.sleep(2000);
		// Select Room
				Robot robot = new Robot();
				robot.mouseMove(500, 500);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				driver.navigate().refresh();

				try {
					Robot robot2 = new Robot();
					robot2.mouseMove(1450, 165);
					robot2.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				driver.navigate().refresh();
				Thread.sleep(1000);

				// Select Continue
				robot.mouseMove(1155, 253);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

				// Select passenger details
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				System.out.println(driver.getTitle());
				try {
					// Wait for the element to be visible
					//	driver.navigate().refresh();
					WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
					WebElement nameInput = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));

					// Send keys to the element
					nameInput.sendKeys("Gangesh");
					//  System.out.println("Timeout waiting for element: " + e.getMessage());
				} catch (NoSuchElementException e) {
					System.out.println("Element not found: " + e.getMessage());
				} finally {
					driver.quit();
				}
	}
}
