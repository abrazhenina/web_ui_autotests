package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

public class Frame extends BaseElement {
	public Frame(String name, By loc) {
		super(name, loc);
	}

	public String getText() {
		WebElement iframe = Waits.waiter().until(ExpectedConditions
				.presenceOfElementLocated(this.getLocator()));
		System.out.println("!"+iframe.getText()+"!");
		Browser.getBrowserInstance().switchTo().frame(iframe);
		System.out.println("!"+iframe.getText()+"!");
		return iframe.getText();
	}
}
