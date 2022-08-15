package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;
import utils.Log;

public class AlertsWindowsPage extends BaseForm {
	private Button alertsBtn = new Button("alertBtn", By.xpath("//span[text()='Alerts']"));
	private Button nestedFramesBtn = new Button("nestedFramesBtn", By.xpath("//span[text()='Nested Frames']"));
	private Button framesBtn = new Button("framesBtn", By.xpath("//span[text()='Frames']"));
	private Button browserWindowsBtn = new Button("browserWindowsBtn", By.xpath("//span[text()='Browser Windows']"));

	public AlertsWindowsPage() {
		super("alertsFrameAndWindows", By.xpath(
				"//div[@class='main-header' and contains(text(),'Alerts')]"));
	}

	public void clickAlertsBtn() {
		Log.log().info("Click AlertsPageButton on AlertsWindowsPage.");
		alertsBtn.click();
	}

	public void clickNestedFramesBtn() {
		Log.log().info("Click NestedFramesPage button on AlertsWindowsPage.");
		nestedFramesBtn.click();
	}

	public void clickFramesBtn() {
		Log.log().info("Click FramesPageButton on AlertsWindowsPage.");
		framesBtn.click();
	}

	public void clickBrowserWindowsBtn() {
		Log.log().info("Click BrowserWindowsPageButton on AlertsWindowsPage.");
		browserWindowsBtn.click();
	}
}