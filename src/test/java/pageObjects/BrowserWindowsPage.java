package pageObjects;

import base.BaseForm;
import base.elements.Button;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaiterUtil;
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
	public BrowserWindowsPage() {
		super("browserWindows", By.xpath(
				"//div[@class='main-header' and text()='Browser Windows']"));
		newTabBtn = new Button(newTabBtnName, newTabBtnLoc);
		newWindowBtn = new Button(newWindowBtnName, newWindowBtnLoc);
		messageWindowBtn = new Button(messageWindowBtnName, messageWindowBtnLoc);
	}

	public void clickNewTabBtn() {
		originalWindow = getWindowID();
		int expectedNumOfWindows = 2;
		newTabBtn.clickButton();
		Waits.waitForNewWindow(expectedNumOfWindows);
		changeToSecondWindowHandle(originalWindow);
	}

	public void closeCurrentTab() {
		this.closeTab(originalWindow);
	}
}