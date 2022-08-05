package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

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
		alertsBtn.click();
	}

	public void clickNestedFramesBtn() {
		nestedFramesBtn.click();
	}

	public void clickFramesBtn() {
		framesBtn.click();
	}

	public void clickBrowserWindowsBtn() {
		browserWindowsBtn.click();
	}
}