package base.elements;

import base.BaseElement;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

import java.util.List;

public class WebTable extends BaseElement {
	public WebTable(String name, By loc) {
		super(name, loc);
	}

	public boolean isStringInTable(String str) {
		try {
			List<WebElement> webTable = Browser.getBrowserInstance().findElements(this.getLocator());
			for (WebElement cell : webTable) {
				if (cell.getText().contains(str))
					return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public void deleteRecord(By delBtnLoc) {
		Waits.waiter().until(ExpectedConditions.elementToBeClickable(delBtnLoc));
		Browser.getBrowserInstance().findElement(delBtnLoc).click();
	}
}