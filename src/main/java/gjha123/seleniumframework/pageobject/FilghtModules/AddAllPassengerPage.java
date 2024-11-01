
package gjha123.seleniumframework.pageobject.FilghtModules;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class AddAllPassengerPage extends AbstractComponenets {
    WebDriver driver;

    public AddAllPassengerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div/span[contains(text(),'*')]")
    WebElement requiredTitle;

    @FindBy(xpath="//div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement FirstName;

    @FindBy(xpath="//div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
    WebElement LastName;

    @FindBy(xpath="//select[@class='InputSelect-module__field___tLmBd']")
    WebElement Dropdown;

    @FindBy(xpath="//input[@placeholder='DD']")
    WebElement dd;

   // @FindBy(xpath="//option[@value='05']")
    @FindBy(xpath="//select[@data-ui-pax-dob-name='month']")
    WebElement month;

    @FindBy(xpath="//input[@placeholder='YYYY']")
    WebElement yy;

    @FindBy(xpath="//span[text()='Done']")
    WebElement done;

    public String getRequiredTitle() {
        return requiredTitle.getText();
    }

    public void enterPassengerDetails(String fn, String ln) {
        waitForelementToBeClickable(FirstName);
        FirstName.sendKeys(fn);
        waitForelementToBeClickable(LastName);
        LastName.sendKeys(ln);
    }

    public void enterGender(String genderType) {
        Select genderSelect = new Select(Dropdown);
        genderSelect.selectByValue(genderType);
    }

    public void enterMonth(String monthtype) {
    	Select objSelect = new Select(month);
    	List <WebElement> elementCount = objSelect.getOptions();
		for (int i = 0; i < elementCount.size(); i++) {
			
			if (elementCount.get(i).getText().equals(monthtype)) {
				objSelect.selectByIndex(i);
				break;
			}
		
		}

    }
    public void enterDateOfBirth(String day, String year) {
        waitForelementToBeClickable(dd);
        dd.sendKeys(day);
        waitForelementToBeClickable(yy);
        yy.sendKeys(year);
    }

    public void clickDone() {
        waitForelementToBeClickable(done);
        done.click();
    }
}
