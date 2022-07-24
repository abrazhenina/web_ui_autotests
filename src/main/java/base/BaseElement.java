package base;

import browser.Browser;
import browser.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

import java.time.Duration;

public abstract class BaseElement {
	private String name;
	private By loc;

	public BaseElement(String name, By loc) {
		this.name = name;
		this.loc = loc;
	}

	public String getName() {
		return this.name;
	}

	public By getLocator() {
		return this.loc;
	}

	public void clickButton() {
		Waits.waiter().until(ExpectedConditions
				.elementToBeClickable(this.getLocator()))
				.click();
	}

	public boolean isDisplayed() {
		return Waits.waiter()
				.until(ExpectedConditions.elementToBeClickable(this.getLocator()))
				.isDisplayed();
	}

	public boolean isClickable() {
		return Waits.waiter()
				.until(ExpectedConditions.elementToBeClickable(this.getLocator()))
				.isDisplayed();
	}

	public WebElement findElement(By loc) {
		return Browser.getBrowserInstance().findElement(loc);
	}

	public String getText(By loc) {
		return Browser.getBrowserInstance().findElement(loc).getText();
	}

}
