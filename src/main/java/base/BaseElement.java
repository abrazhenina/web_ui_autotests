package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseElement {
	private String name;
	private By loc;
	private WebDriverWait wait;

	public BaseElement(String name, By loc) {
		this.name = name;
		this.loc = loc;
	}

	public String getName() {
		return null;
	}

	public By getLocator() {
		return null;
	}

	public void click() {
		this.wait.until(ExpectedConditions
				.elementToBeClickable(this.getLocator()));
	}

	public boolean isDisplayed() {
		return true;
	}

	public WebElement findElement() {
		return null;
	}

	public String getText() {
		return null;
	}

}
