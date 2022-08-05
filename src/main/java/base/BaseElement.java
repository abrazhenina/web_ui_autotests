package base;

import browser.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
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

	public boolean isDisplayed() {
		return Waits.waiter()
				.until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()))
				.isDisplayed();
	}

	public void click() {
		Waits.waiter().until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()));
		Waits.waiter().until(ExpectedConditions.elementToBeClickable(this.getLocator())).click();
	}

	public void clickJS() {
		WebDriver driver = Browser.getBrowserInstance();
		WebElement element = driver.findElement(this.getLocator());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public boolean isVisible() {
		try
		{
			Waits.waiter().until(ExpectedConditions
					.visibilityOfElementLocated(this.getLocator())).isDisplayed();
			return true;
		}
		catch (NoSuchElementException Ex) {
			return false;
		}
	}

	public String getText() {
		return Waits.waiter().until(ExpectedConditions.visibilityOfElementLocated(this.loc)).getText();
	}

	public String getTextFromModalElement(By containerLoc, By elementLoc) {
		WebElement modalContainer = Waits.waiter().until(ExpectedConditions
				.visibilityOfElementLocated(containerLoc));
		WebElement element = modalContainer.findElement(elementLoc);
		return element.getText();
	}

	public String getValue() {
		return Browser.getBrowserInstance().findElement(this.getLocator()).getAttribute("value");
	}

	public int getAriaValueNowInt() {
		return Integer.parseInt(Browser.getBrowserInstance()
				.findElement(this.getLocator()).getAttribute("aria-valuenow"));
	}
	public boolean isElementClassValueActive() {
		String elClassValue = Browser.getBrowserInstance().findElement(this.getLocator()).getAttribute("class");
		if(elClassValue.contains("active"))
			return true;
		return false;
	}
}