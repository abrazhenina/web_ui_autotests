package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Dropdown;
import org.openqa.selenium.By;
import utils.Log;
import utils.Waits;

public class BrowserWindowsPage extends BaseForm {
	private Button newTabBtn = new Button("newTabBtn", By.id("tabButton"));
	private Button newWindowBtn = new Button("newWindowBtn", By.id("windowButton"));
	private Button messageWindowBtn = new Button("messageWindowBtn", By.id("messageWindowButton"));
	private Button elementsHeaderBtn = new Button("elementsHeaderBtn", By.xpath("//div[@class='header-wrapper']//div[text()='Elements']"));
	private Button linksBtn = new Button("linksBtn", By.xpath("//span[text()='Links']"));
	private Dropdown elementsDropdownShowed = new Dropdown("elementsDropdown", By.cssSelector(".element-list.show"));
	private String originalWindow;

	public BrowserWindowsPage() {
		super("browserWindows", By.xpath(
				"//div[@class='main-header' and text()='Browser Windows']"));
	}

	public void clickNewTabBtn() {
		Log.log().info("Click NewTabButton.");
		originalWindow = getWindowID();
		int expectedNumOfWindows = 2;
		newTabBtn.click();
		Waits.waitForNewWindow(expectedNumOfWindows);
		changeToSecondWindowHandle(originalWindow);
	}

	public void closeCurrentTab() {
		Log.log().info("Close this tab.");
		this.closeTab(originalWindow);
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