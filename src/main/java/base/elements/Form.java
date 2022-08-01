package base.elements;

import base.BaseForm;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Form extends BaseForm {
	public Form(String name, By loc) {
		super(name, loc);
	}

	public boolean clickDayInCalendarWeek(String value) {
		List<WebElement> week = Browser.getBrowserInstance().findElements(this.getLocator());
		int i = 0;
		for(WebElement day : week) {
			if(i>0 && day.getText().equals(value)) {
				day.click();
				return true;
			}
			i++;
		}
		return false;
	}
}
