package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class AlertsWindowsPage extends BaseForm {
	private Button alertsBtn;
	private Button nestedFramesBtn;
	private Button framesBtn;
	private Button browserWindowsBtn;

	public AlertsWindowsPage() {
		super("alertsFrameAndWindows", By.xpath(
				"//div[@class='main-header' and contains(text(),'Alerts')]"));
		this.alertsBtn = new Button("alertBtn", By.xpath("//span[text()='Alerts']"));
		this.nestedFramesBtn = new Button("nestedFramesBtn", By.xpath("//span[text()='Nested Frames']"));
		this.framesBtn = new Button("framesBtn", By.xpath("//span[text()='Frames']"));
		this.browserWindowsBtn = new Button("browserWindowsBtn", By.xpath("//span[text()='Browser Windows']"));
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(alertsBtn.getName()))
			alertsBtn.click();
		else if (buttonName.equals(nestedFramesBtn.getName()))
			nestedFramesBtn.click();
		else if (buttonName.equals(framesBtn.getName()))
			framesBtn.click();
		else if (buttonName.equals(browserWindowsBtn.getName()))
			browserWindowsBtn.click();
	}
}
