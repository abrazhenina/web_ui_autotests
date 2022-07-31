package base;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;


public abstract class BaseForm {
	private String name;
	private By loc;

	public BaseForm(String name, By loc) {
		this.name = name;
		this.loc = loc;
	}

	public boolean isOpen() {
		return Waits.waiter().until(ExpectedConditions
				.visibilityOfElementLocated(this.getLocator())).isDisplayed();
	}

	public String getWindowID() {
		return Browser.getBrowserInstance().getWindowHandle();
	}

	public void changeToSecondWindowHandle(String originalWindow) {
		WebDriver driver = Browser.getBrowserInstance();
		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public void switchToWindow(String window) {
		Browser.getBrowserInstance().switchTo().window(window);
	}

	public boolean isSubstringInCurrentUrl(String substring) {
		return Browser.getBrowserInstance().getCurrentUrl().contains(substring);
	}

	public void closeTab(String originalWindow) {
		WebDriver driver = Browser.getBrowserInstance();
		driver.close();
		driver.switchTo().window(originalWindow);
	}

	public String getName() {
		return this.name;
	}

	public By getLocator() {
		return this.loc;
	}
}