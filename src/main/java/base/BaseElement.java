package base;

import browser.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;
import utils.Waits;

import java.util.List;

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
		Log.log().info(this.getName() + " displayed.");
		return Waits.waiter()
				.until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()))
				.isDisplayed();
	}

	public boolean isPresent() {
		Log.log().info(this.getName() + " is present.");
		return Waits.waiter()
				.until(ExpectedConditions.presenceOfElementLocated(this.getLocator()))
				.isDisplayed();
	}

	public void click() {
		Log.log().info("Click "+this.getName());
		Waits.waiter().until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()));
		Waits.waiter().until(ExpectedConditions.elementToBeClickable(this.getLocator())).click();
	}

	public void clickJS() {
		Log.log().info("JavaScript click "+this.getName());
		WebDriver driver = Browser.getBrowserInstance();
		WebElement element = driver.findElement(this.getLocator());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public boolean isVisible() {
		Log.log().info(this.getName() + " visible.");
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
		Log.log().info("Get text from "+this.getName());
		return Waits.waiter().until(ExpectedConditions.presenceOfElementLocated(this.loc)).getText();
	}

	public int getAriaValueNowInt() {
		Log.log().info("Get 'aria-valuenow' class value of "+this.getName());
		return Integer.parseInt(Browser.getBrowserInstance()
				.findElement(this.getLocator()).getAttribute("aria-valuenow"));
	}

	public boolean isStringInTable(String str) {
		Log.log().info("String '"+str+"' is in table "+this.getName());
		try {
			List<WebElement> webTable = Browser.getBrowserInstance().findElements(this.getLocator());
			for (WebElement cell : webTable) {
				if (cell.getText().contains(str))
					return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}