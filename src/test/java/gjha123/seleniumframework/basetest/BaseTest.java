package gjha123.seleniumframework.basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import gjha123.seleniumframework.pageobject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException {
		Properties prop=new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"//src//main//java//gjha123//seleniumframework//resources//config.properties"));
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			// initialize firefox driver
			 driver = new FirefoxDriver();
			
			
		} else if (browser.equalsIgnoreCase("safari")) {
			// initialize safari driver
			 driver = new SafariDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			// initialize edge driver
			 driver = new EdgeDriver();
			
		}
		
		else {
			System.out.println("Invalid browser");
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		return driver;
			
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		 driver=initializeDriver();
		 landingPage = new LandingPage(driver);
			//landingPage.setImplicitWait(20);
			landingPage.goToBookingPage();
			return landingPage;
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}

}
