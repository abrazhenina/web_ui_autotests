package base;

import browser.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BaseElement {
	private String name;
	private By loc;

	public BaseElement(String name, By loc) {
		this.name = name;
		this.loc = loc;
	}

	public String getName() {
		return name;
	}

	public By getLocator() {
		return loc;
	}

	public void clickButton() {
		WebDriver driver = Browser.getBrowserInstance();
		WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(getLocator()));
		button.click();
	}

	public boolean isDisplayed() {
		WebDriver driver = Browser.getBrowserInstance();
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(getLocator()))
				.isDisplayed();
	}

	public WebElement findElement() {
		return null;
	}

	public String getText() {
		return null;
	}

}
