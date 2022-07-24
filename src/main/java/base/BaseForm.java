package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

public abstract class BaseForm {
	private String name;
	private By loc;

	public BaseForm(String name, By loc) {
		this.name = name;
		this.loc = loc;
	}

	public boolean isPageOpen() {
		return Waits.waiter().until(ExpectedConditions
				.presenceOfElementLocated(this.getLocator())).isDisplayed();
	}

	public String getName() {
		return this.name;
	}

	public By getLocator() {
		return this.loc;
	}
}