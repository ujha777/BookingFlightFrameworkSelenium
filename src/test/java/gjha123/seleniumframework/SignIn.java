package gjha123.seleniumframework;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import gjha123.seleniumframework.basetest.BaseTest;
import gjha123.seleniumframework.pageobject.SignInPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SignIn extends BaseTest {

	@Test(description="Sign In with Google",groups= {"smoke"})
	@Owner("Gangesh Jha")
	@Description("Sign In with Google")
	@Severity(SeverityLevel.CRITICAL)

	public void TC_01_signIn() {

		SignInPage signIn = new SignInPage(driver);
		signIn.clickSignInButton();
		signIn.clickGoogleSignInButton();
		signIn.moveToChildWindow();
		driver.manage().window().maximize();
		signIn.enterEmail("ujha777@gmail.com");
		signIn.moveToParentWindow();
		driver.quit();


	}
	@Test(description="Sign In with Google with empty",groups= {"smoke"})
	@Owner("Gangesh Jha")
	@Description("Sign In with Google")
	@Severity(SeverityLevel.CRITICAL)

	public void TC_02_signInWithOutAnyField() throws InterruptedException {

		SignInPage signIn = new SignInPage(driver);
		signIn.clickSignInButton();
		signIn.clickGoogleSignInButton();
		signIn.moveToChildWindow();
		driver.manage().window().maximize();
		signIn.clickNextButton();
//		signIn.getEnterEmailErrorMessage();
//		Assert.assertEquals(signIn.getEnterEmailErrorMessage(), "Enter an email or phone number");
//		signIn.moveToParentWindow();
		driver.quit();


	}

}
