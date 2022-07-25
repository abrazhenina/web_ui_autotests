package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Dropdown;
import org.openqa.selenium.By;
import utils.Waits;

public class BrowserWindowsPage extends BaseForm {
	private Button newTabBtn;
	private String newTabBtnName = "newTabBtn";
	private By newTabBtnLoc = By.id("tabButton");
	private Button newWindowBtn;
	private String newWindowBtnName = "newWindowBtn";
	private By newWindowBtnLoc = By.id("windowButton");
	private Button messageWindowBtn;
	private String messageWindowBtnName = "messageWindowBtn";
	private By messageWindowBtnLoc = By.id("messageWindowButton");
	private String originalWindow;
	private Button elementsHeaderBtn;
	private String elementsHeaderBtnName = "elementsHeaderBtn";
	private By elementsHeaderBtnLoc = By.xpath("//div[@class='header-wrapper']//div[text()='Elements']");
	private Button linksBtn;
	private String linksBtnName = "linksBtn";
	private By linksBtnLoc = By.xpath("//span[text()='Links']");
	private Dropdown elementsDropdownShowed;
	private String elementsDropdownShowedName = "elementsDropdown";
	private By elementsDropdownShowedLoc = By.cssSelector(".element-list.show");


	public BrowserWindowsPage() {
		super("browserWindows", By.xpath(
				"//div[@class='main-header' and text()='Browser Windows']"));
		newTabBtn = new Button(newTabBtnName, newTabBtnLoc);
		newWindowBtn = new Button(newWindowBtnName, newWindowBtnLoc);
		messageWindowBtn = new Button(messageWindowBtnName, messageWindowBtnLoc);
		elementsHeaderBtn = new Button(elementsHeaderBtnName, elementsHeaderBtnLoc);
		linksBtn = new Button(linksBtnName, linksBtnLoc);
		elementsDropdownShowed = new Dropdown(elementsDropdownShowedName, elementsDropdownShowedLoc);
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