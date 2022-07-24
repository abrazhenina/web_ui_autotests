package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
	private String alertsFrameAndWindowsBtnName = "alertsFrameAndWindowsBtn";
	private String alertsFrameAndWindowsBtnLocStr = "//div[@class='card-body']//*[contains(text(),'Alerts')]";
	private By alertsFrameAndWindowsBtnLoc;
	private Button alertsFrameAndWindowsBtn;

	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
		alertsFrameAndWindowsBtnLoc = By.xpath(alertsFrameAndWindowsBtnLocStr);
		this.alertsFrameAndWindowsBtn = new Button(alertsFrameAndWindowsBtnName,
				alertsFrameAndWindowsBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName == alertsFrameAndWindowsBtn.getName()) {
			alertsFrameAndWindowsBtn.clickButton();
		}
	}
}