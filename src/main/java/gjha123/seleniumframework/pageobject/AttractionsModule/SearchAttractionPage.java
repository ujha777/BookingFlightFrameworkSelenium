
package gjha123.seleniumframework.pageobject.AttractionsModule;

import java.util.List;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gjha123.seleniumframework.abstractComponents.AbstractComponenets;
import java.lang.reflect.InvocationTargetException;

public class SearchAttractionPage extends AbstractComponenets {
    WebDriver driver;

    public SearchAttractionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Where are you going?']")
    WebElement enterDestination;

    @FindBy(xpath = "//div[@role='listbox']/div[1]/div[2]/button")
    List<WebElement> searchDestination;

    @FindBy(xpath = "//div[2]/div[normalize-space()='Select your dates']")
    WebElement selectDates;

    @FindBy(xpath = "//tbody/tr/td/span[@tabindex='-1']")
    List<WebElement> dates;

    @FindBy(xpath = "//span[normalize-space()='Search']")
    WebElement searchButton;

    public void clickOnDestination(String destination) throws InterruptedException, InvocationTargetException {
        try {
            if (driver.getWindowHandles().size() > 0) {
                enterDestination.sendKeys(destination);
            }
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred: " + e.getMessage());
        }
    }

    public void enterDestination() throws InvocationTargetException {
        for (WebElement ele : searchDestination) {
            try {
                if (ele.getText().contains("Uttar")) {
                    System.out.println("Clicking on Destination" + ele.getText());
                    waitForelementToBeVisibileByWebElement(ele);
                    ele.click();
                    System.out.println("Clicking on Destination" + ele.getText());
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Attempting to recover from StaleElementReferenceException...");
            } catch (NoSuchWindowException e) {
                System.out.println("No such window exception occurred: " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.out.println("Element not interactable exception occurred: " + e.getMessage());
            } catch (TimeoutException e) {
                System.out.println("Timeout exception occurred: " + e.getMessage());
            } catch (WebDriverException e) {
                System.out.println("WebDriver exception occurred: " + e.getMessage());
            }
        }
    }

    public void ClickOnDates() throws InterruptedException, InvocationTargetException {
        try {
            if (driver.getWindowHandles().size() > 0) {
                waitForelementToBeClickable(selectDates);
                selectDates.click();
            }
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred: " + e.getMessage());
        }
    }

    public void selectDateRange() throws InvocationTargetException {
        try {
            if (driver.getWindowHandles().size() > 0) {
                dates.stream().filter(d -> d.getText().equals(String.valueOf(fromDate())) || d.getText().equals(String.valueOf(toDates()))).forEach(d -> d.click());
            }
        } catch (StaleElementReferenceException e) {
            e.getMessage();
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred: " + e.getMessage());
        }
    }

    public void clickSearchButton() throws InvocationTargetException {
        try {
            if (driver.getWindowHandles().size() > 0) {
                waitForelementToBeClickable(searchButton);
                searchButton.click();
            }
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred: " + e.getMessage());
        }
    }
}
