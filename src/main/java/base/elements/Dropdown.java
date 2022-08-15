package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement {
	public Dropdown(String name, By loc) {
		super(name, loc);
	}

	public void clickElementByIntValue(String value) {
		WebElement dropdown = Browser.getBrowserInstance().findElement(this.getLocator());
		Select selectObject = new Select(dropdown);
		selectObject.selectByValue(value);
	}
}