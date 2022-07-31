package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

import java.time.Duration;

public class TextBox extends BaseElement {
	public TextBox(String name, By loc) {
		super(name, loc);
	}

	public void clearInput() {
		Browser.getBrowserInstance().findElement(this.getLocator()).clear();
	}
	public void sendKeys(String keys) {
		WebElement input = Waits.waiter().until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()));
		new Actions(Browser.getBrowserInstance())
				.moveToElement(input)
				.sendKeys(keys)
				.perform();
	}

	public String getTextFromInput() {
		Waits.waiter().until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()));
		return  Browser.getBrowserInstance().findElement(this.getLocator()).getAttribute("value");
	}
}