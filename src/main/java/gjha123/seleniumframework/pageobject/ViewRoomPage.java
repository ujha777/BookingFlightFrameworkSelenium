package gjha123.seleniumframework.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.WebDriver;
import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class ViewRoomPage extends AbstractComponenets {
	Robot robot;
	WebDriver driver;
    public ViewRoomPage(WebDriver driver) throws AWTException {
		// TODO Auto-generated constructor stub
    	super(driver);
    	this.driver = driver;
    	this.robot = new Robot();
    	//Robot robot= new Robot();
	}
	public void selectRoom() throws AWTException, InterruptedException {
		
		robot.mouseMove(1450,165);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		reLoadPage();
		setMiiliImplicitWait(1000);

	}
	
	public void clickContinueAfterSelectingRoom() {
		
		robot.mouseMove(1155, 253);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

}
