package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTable extends BaseElement {
	public WebTable(String name, By loc) {
		super(name, loc);
	}

	public boolean isStringInTable(String str) {
		List<WebElement> webTable = Browser.getBrowserInstance().findElements(this.getLocator());
		for (WebElement cell : webTable) {
			if(cell.getText().contains(str))
				return true;
		}
		return false;
	}
}