package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

import java.time.Duration;

public class TextBox extends BaseElement {
	public TextBox(String name, By loc) {
		super(name, loc);
	}

	public void sendKeys(String keys) {
		Waits.waiter().until(ExpectedConditions.elementToBeClickable(this.getLocator()))
				.sendKeys(keys);
	}
}
