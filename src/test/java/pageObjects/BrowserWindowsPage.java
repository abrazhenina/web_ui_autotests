package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Dropdown;
import org.openqa.selenium.By;
import utils.Log;
import utils.TabsUtil;
import utils.Waits;

public class BrowserWindowsPage extends BaseForm {
	private Button newTabBtn = new Button("newTabBtn", By.id("tabButton"));
	private Button elementsHeaderBtn = new Button("elementsHeaderBtn", By.xpath("//*[@class='header-text' and contains(text(),'Elements')]"));
	private Button linksBtn = new Button("linksBtn", By.xpath("//span[text()='Links']"));
	private Dropdown elementsDropdownShowed = new Dropdown("elementsDropdown", By.cssSelector(".element-list.show"));

	public BrowserWindowsPage() {
		super("browserWindows", By.xpath("//div[@class='main-header' and contains(text(),'Browser Windows')]"));
	}

	public void clickNewTabBtn() {
		Log.log().info("Click NewTabButton.");
		TabsUtil.originalWindow = TabsUtil.getWindowID();
		newTabBtn.click();
		Waits.waitForNewWindow(2);
		TabsUtil.changeToSecondWindowHandle();
	}

	public void clickElementsHeaderBtn() {
		Log.log().info("Click ElementsPageButton.");
		elementsHeaderBtn.click();
	}

	public void clickLinksBtn() {
		Log.log().info("Click LinksPageButton.");
		linksBtn.click();
	}

	public boolean isElementsDropdownShowed() {
		return elementsDropdownShowed.isDisplayed();
	}

	public boolean isBrowserWindowsPageOpen() {
		Log.log().info("On the current tab is BrowserWindowsPage.");
		return isOpen();
	}


}