package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log;

public class Frame extends BaseElement {
	public Frame(String name, By loc) {
		super(name, loc);
	}

	public void switchToFrame() {
		Log.log().info("Switch to "+this.getName());
		WebDriver driver = Browser.getBrowserInstance();
		WebElement iframe = driver.findElement(this.getLocator());
		driver.switchTo().frame(iframe);
	}
}