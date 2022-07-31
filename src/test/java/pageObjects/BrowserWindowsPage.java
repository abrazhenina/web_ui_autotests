package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Dropdown;
import org.openqa.selenium.By;
import utils.Waits;

public class BrowserWindowsPage extends BaseForm {
	private Button newTabBtn;
	private Button newWindowBtn;
	private Button messageWindowBtn;
	private String originalWindow;
	private Button elementsHeaderBtn;
	private Button linksBtn;
	private Dropdown elementsDropdownShowed;

	public BrowserWindowsPage() {
		super("browserWindows", By.xpath(
				"//div[@class='main-header' and text()='Browser Windows']"));
		newTabBtn = new Button("newTabBtn", By.id("tabButton"));
		newWindowBtn = new Button("newWindowBtn", By.id("windowButton"));
		messageWindowBtn = new Button("messageWindowBtn", By.id("messageWindowButton"));
		elementsHeaderBtn = new Button("elementsHeaderBtn", By.xpath("//div[@class='header-wrapper']//div[text()='Elements']"));
		linksBtn = new Button("linksBtn", By.xpath("//span[text()='Links']"));
		elementsDropdownShowed = new Dropdown("elementsDropdown", By.cssSelector(".element-list.show"));
	}

	public void clickNewTabBtn() {
		originalWindow = getWindowID();
		int expectedNumOfWindows = 2;
		newTabBtn.click();
		Waits.waitForNewWindow(expectedNumOfWindows);
		changeToSecondWindowHandle(originalWindow);
	}

	public void closeCurrentTab() {
		this.closeTab(originalWindow);
	}

	public void clickElementsHeaderBtn() {
		elementsHeaderBtn.click();
	}

	public void clickLinksBtn() {
		linksBtn.click();
	}

	public boolean isElementsDropdownShowed() {
		return elementsDropdownShowed.isDisplayed();
	}
}