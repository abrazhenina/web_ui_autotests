package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class AlertsWindowsPage extends BaseForm {
	private Button alertsBtn;

	public AlertsWindowsPage() {
		super("alertsFrameAndWindows", By.xpath(
				"//div[@class='main-header' and text()='Alerts, Frame & Windows']"));
		this.alertsBtn = new Button("alertsBtn",
				By.xpath("//span[text()='Alerts']"));
	}

	public void clickButton(String buttonName) {
		if (buttonName == alertsBtn.getName()) {
			alertsBtn.clickButton();
		}
	}
}
