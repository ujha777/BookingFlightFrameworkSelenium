
package gjha123.seleniumframework.pageobject.AttractionsModule;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import gjha123.seleniumframework.abstractComponents.AbstractComponenets;
import java.lang.reflect.InvocationTargetException;

public class ResultAttractionPage extends AbstractComponenets {
    WebDriver driver;

    public ResultAttractionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[@class='ccb65902b2']")
    List<WebElement> filterBy;

    @FindBy(xpath = "//h3[normalize-space()='Languages']")
    WebElement language;

    @FindBy(xpath = "//h3[normalize-space()='Category']")
    WebElement category;

    @FindBy(xpath = "//fieldset[@class='css-oxxtq9']/div")
    List<WebElement> filterByCategory;

    @FindBy(xpath = "//div[2]/div[2]/div[1]/fieldset[1]/div[1]/div")
    List<WebElement> selectPriceRange;

    @FindBy(xpath = "//div[3]/div[1]/fieldset[1]/div[1]/div")
    List<WebElement> Showresultswith;

    @FindBy(xpath = "//div[4]/div[1]/fieldset[1]/div[1]/div")
    List<WebElement> selectReviewScore;
    
    @FindBy(xpath = "//div[5]/div[1]/fieldset[1]/div[1]/div")
    List<WebElement> selectTimeOfTheDay;
    
    @FindBy(xpath = "//div[7]/div[1]/fieldset[1]/div[1]/div")
    List<WebElement> Languages;
    
    @FindBy(xpath = "//label[text()='Best reviewed']")
    WebElement bestReviewedoption;
    
    @FindBy(xpath = "//span[text()='See availability']")
    WebElement seeAvailability;
    
    
    
    

    public void selectCategory() throws InterruptedException, InvocationTargetException {
        try {
            switchToChildWindow();
            if (driver.getWindowHandles().size() > 0) {
                for (WebElement ele1 : filterByCategory) {
                    System.out.println(ele1.getText());
                    if (ele1.getText().contains("Museums, arts & culture(52)")
                            || ele1.getText().contains("Nature & outdoor(26)")
                            || ele1.getText().contains("Food & drink(9)")
                            || ele1.getText().contains("Workshops & classes(3)")
                            || ele1.getText().contains("Entertainment & tickets(12)")
                            || ele1.getText().contains("Services & rentals(1)")) {
                        waitForelementToBeVisibileByWebElement(ele1);
                        ele1.click();
                    }
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        }  catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        }
    }

    public void selectPriceRange() throws InterruptedException, InvocationTargetException {
        try {
            switchToChildWindow();
            if (driver.getWindowHandles().size() > 0) {
                for (WebElement ele1 : selectPriceRange) {
                    if (ele1.getText().contains("Rs. 3,668 - Rs. 6,878")) {
                        scrollToTheSpecificElement(ele1);
                        waitForelementToBeVisibileByWebElement(ele1);
                        ele1.click();
                    }
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        }  catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        }
    }

    public void showResults() throws InvocationTargetException {
        try {
            switchToChildWindow();
            if (driver.getWindowHandles().size() > 0) {
                for (WebElement ele1 : Showresultswith) {
                    if (ele1.getText().contains("Free")) {
                        waitForelementToBeVisibileByWebElement(ele1);
                        ele1.click();
                    }
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        }  catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        }
    }

    public void selectReviewScore() throws InvocationTargetException {
        try {
            switchToChildWindow();
            if (driver.getWindowHandles().size() > 0) {
                for (WebElement ele1 : selectReviewScore) {
                    if (ele1.getText().contains("4.5")) {
                        waitForelementToBeVisibileByWebElement(ele1);
                        ele1.click();
                    }
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("No such window exception occurred: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable exception occurred: " + e.getMessage());
        }  catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage());
        }
    }
    
    public void selectTimePeriod() throws InterruptedException {
		try {
			switchToChildWindow();
			if (driver.getWindowHandles().size() > 0) {
				for (WebElement ele1 : selectTimeOfTheDay) {
					if (ele1.getText().contains("Morning")) {
						waitForelementToBeVisibileByWebElement(ele1);
						ele1.click();
					}
				}
				setMiiliImplicitWait(1000);
				scrollToTheSpecificElement(language);
			}
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exception occurred: " + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable exception occurred: " + e.getMessage());
		} catch (TimeoutException e) {
			System.out.println("Timeout exception occurred: " + e.getMessage());
		}
    }
    
    public void selectLanguage() throws InterruptedException {
    	try {
			switchToChildWindow();
			if (driver.getWindowHandles().size() > 0) {
				for (WebElement ele1 : Languages) {
				
					if (ele1.getText().contains("English(1)")) {
						waitForelementToBeVisibileByWebElement(ele1);
						ele1.click();
					}
				}
			}
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exception occurred: " + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable exception occurred: " + e.getMessage());
		} catch (TimeoutException e) {
			System.out.println("Timeout exception occurred: " + e.getMessage());
		}
    }
    
	public void selectBestReviewed(){
		waitForelementToBeVisibileByWebElement(bestReviewedoption);
		bestReviewedoption.click();
	}
	
	public void clickSeeAvailability() {
		waitForelementToBeVisibileByWebElement(seeAvailability);
		seeAvailability.click();
		reLoadPage();
	}
}