package gjha123.seleniumframework.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.WebDriver;
import gjha123.seleniumframework.abstractComponents.AbstractComponenets;

public class HotelsDetailsPage extends AbstractComponenets {
	WebDriver driver;
	public HotelsDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}
	public void SelectRoomImagePic() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(500, 500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		reLoadPage();

	}

}
