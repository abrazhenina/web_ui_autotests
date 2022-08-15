package base.elements;

import base.BaseForm;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log;

public class Frame extends BaseForm {
	public Frame(String name, By loc) {
		super(name, loc);
	}

	public void switchToFrame() {
		WebDriver driver = Browser.getBrowserInstance();
		WebElement iframe = driver.findElement(this.getLocator());
		driver.switchTo().frame(iframe);
	}

	public void switchBackFromFrames() {
		Log.log().info("Switch back from frame.");
		Browser.getBrowserInstance().switchTo().defaultContent();
	}
}