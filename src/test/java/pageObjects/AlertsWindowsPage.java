package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class AlertsWindowsPage extends BaseForm {
	private Button alertsBtn;
	private String alertsBtnName = "alertBtn";
	private By alertsBtnLoc = By.xpath("//span[text()='Alerts']");
	private Button nestedFramesBtn;
	private String nestedFramesBtnName = "nestedFramesBtn";
	private By nestedFramesBtnLoc =  By.xpath("//span[text()='Nested Frames']");

	public AlertsWindowsPage() {
		super("alertsFrameAndWindows", By.xpath(
				"//div[@class='main-header' and contains(text(),'Alerts')]"));
		this.alertsBtn = new Button(alertsBtnName, alertsBtnLoc);
		this.nestedFramesBtn = new Button(nestedFramesBtnName, nestedFramesBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(alertsBtn.getName()))
			alertsBtn.clickButton();
		else if (buttonName.equals(nestedFramesBtn.getName()))
			nestedFramesBtn.clickButton();
	}
}
