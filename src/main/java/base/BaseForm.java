package base;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;
import utils.Waits;


public abstract class BaseForm {
	private String name;
	private By loc;

	public BaseForm(String name, By loc) {
		this.name = name;
		this.loc = loc;
	}

	public boolean isOpen() {
		Log.log().info(this.getName()+" opens.");
		return Waits.waiter().until(ExpectedConditions
				.visibilityOfElementLocated(this.getLocator())).isDisplayed();
	}

	public boolean isSubstringInCurrentUrl(String substring) {
		Log.log().info("Check the URL of new tab contains '/sample'");
		return Browser.getBrowserInstance().getCurrentUrl().contains(substring);
	}

	public String getName() {
		return this.name;
	}

	public By getLocator() {
		return this.loc;
	}

	public void switchBackFromFrames() {
		Log.log().info("Switch back from frame.");
		Browser.getBrowserInstance().switchTo().defaultContent();
	}
}