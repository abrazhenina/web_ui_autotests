package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class Slider extends BaseElement {
	public Slider(String name, By loc) {
		super(name, loc);
	}

	public String getSliderValue() {
		return getValue();
	}

	public void moveSliderToLeft() {
		new Actions(Browser.getBrowserInstance())
				.moveToElement(Browser.getBrowserInstance().findElement(this.getLocator()))
				.keyDown(Keys.ARROW_LEFT)
				.keyUp(Keys.ARROW_LEFT)
				.perform();
	}

	public void moveSliderToRight() {
		new Actions(Browser.getBrowserInstance())
				.moveToElement(Browser.getBrowserInstance().findElement(this.getLocator()))
				.keyDown(Keys.ARROW_RIGHT)
				.keyUp(Keys.ARROW_RIGHT)
				.perform();
	}
}