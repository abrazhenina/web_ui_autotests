package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TextBox extends BaseElement {
	public TextBox(String name, By loc) {
		super(name, loc);
	}

	public void sendKeys(String keys) {
		WebDriver driver = Browser.getBrowserInstance();
		WebElement input = driver.findElement(this.getLocator());
		new Actions(driver)
				.moveToElement(input)
				.pause(Duration.ofSeconds(2))
				.sendKeys(keys)
				.pause(Duration.ofSeconds(2))
				.perform();
	}

	public void sendKeysToModalInput(By containerLoc, By elementLoc, String keys) {
		WebDriver driver = Browser.getBrowserInstance();
		WebElement modalContainer = driver.findElement(containerLoc);
		WebElement input = modalContainer.findElement(elementLoc);
		new Actions(driver)
				.moveToElement(input)
				.pause(Duration.ofSeconds(2))
				.sendKeys(keys)
				.pause(Duration.ofSeconds(2))
				.perform();
	}
}
