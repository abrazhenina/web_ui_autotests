package base;

import browser.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

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

	public void click() {
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

	public boolean isVisible() {
		return Waits.waiter()
				.until(ExpectedConditions
						.visibilityOfElementLocated(this.getLocator()))
				.isDisplayed();
	}

	public boolean isStillVisible() {
		try
		{
			Waits.waiter().until(ExpectedConditions
					.presenceOfElementLocated(this.getLocator())).isDisplayed();
			return true;
		}
		catch (NoSuchElementException Ex) {
			return false;
		}
	}

	public WebElement findElement() {
		return Browser.getBrowserInstance().findElement(this.loc);
	}

	public String getText() {
		return Waits.waiter().until(ExpectedConditions.elementToBeClickable(this.loc)).getText();
	}

	public String getTextFromModalElement(By containerLoc, By elementLoc) {
		WebElement modalContainer = Waits.waiter().until(ExpectedConditions
				.visibilityOfElementLocated(containerLoc));
		WebElement element = modalContainer.findElement(elementLoc);
		return element.getText();
	}

	public void clickModalBtn(By containerLoc, By btnLoc) {
		WebElement modalContainer = Browser.getBrowserInstance().findElement(containerLoc);
		modalContainer.findElement(btnLoc).click();
	}
}
