package pageObjects;

import base.BaseForm;
import base.elements.Button;
import browser.Browser;
import browser.BrowserConfig;
import org.openqa.selenium.By;
import utils.Log;

public class MainPage extends BaseForm {
	private Button alertsFrameAndWindowsBtn = new Button("alertsFrameAndWindowsBtn",
			By.xpath("//*[contains(text(),'Alerts')]"));
	private Button elementsBtn = new Button("elementsBtn", By.xpath("//*[@class='card-body']//*[contains(text(),'Elements')]"));
	public Button widgetsBtn = new Button("widgetsBtn", By.xpath("//*[@class='card-body']//*[contains(text(),'Widgets')]"));

	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
	}

	public void clickAlertsFrameAndWindowsBtn() {
		Log.log().info("Click AlertsFrameAndWindowsPageButton on MainPage.");
		alertsFrameAndWindowsBtn.click();
	}

	public void clickElementsBtn() {
		Log.log().info("Click ElementsPageButton.");
		elementsBtn.click();
	}

	public void clickWidgetsBtn() {
		Log.log().info("Click WidgetsPageButton.");
		widgetsBtn.click();
	}

	public void goToMainPage() {
		Log.log().info("Go to MainPage.");
		Browser.getBrowserInstance();
		Browser.goToUrl(BrowserConfig.getHomePageAddress());
	}

	public boolean isMainPageOpen() {
		Log.log().info("MainPage is open.");
		return isOpen();
	}
}