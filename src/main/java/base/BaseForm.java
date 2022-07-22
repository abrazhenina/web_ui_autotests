package base;

import base.elements.Label;
import browser.Browser;
import org.openqa.selenium.By;

public abstract class BaseForm {
	private String name;
	private By loc;

	public BaseForm(String name, By loc) {
		this.name = name;
		this.loc = loc;
	}

	public boolean isPageOpen() {
		return Browser.getBrowserInstance().findElement(this.getLocator()).isDisplayed();
	}

	public String getName() {
		return name;
	}

	public By getLocator() {
		return loc;
	}

	public Label getPageLabel() {
		return null;
	}

}
