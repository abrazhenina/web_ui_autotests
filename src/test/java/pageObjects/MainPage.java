package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
	private Button alertsFrameAndWindowsBtn;
	private String alertsFrameAndWindowsBtnName = "alertsFrameAndWindowsBtn";
	private By alertsFrameAndWindowsBtnLoc = By.xpath("//div[@class='card-body']//*[contains(text(),'Alerts')]");

	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
		this.alertsFrameAndWindowsBtn = new Button(alertsFrameAndWindowsBtnName,
				alertsFrameAndWindowsBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName == alertsFrameAndWindowsBtn.getName()) {
			alertsFrameAndWindowsBtn.clickButton();
		}
	}
}