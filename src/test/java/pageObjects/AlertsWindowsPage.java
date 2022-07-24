package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class AlertsWindowsPage extends BaseForm {
	private Button alertsBtn;
	private String alertsBtnName = "alertsWindowsPageAlertBtn";
		private String alertsBtnLocStr = "//span[text()='Alerts']";
	private By alertsBtnLoc;

	public AlertsWindowsPage() {
		super("alertsFrameAndWindows", By.xpath(
				"//div[@class='main-header' and contains(text(),'Alerts')]"));
		this.alertsBtnLoc = By.xpath(alertsBtnLocStr);
		this.alertsBtn = new Button(alertsBtnName, alertsBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(alertsBtn.getName())) {
			alertsBtn.clickButton();
		} else {
			System.out.println("No button found.");
		}
	}
}
