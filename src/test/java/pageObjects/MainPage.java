package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
	private Button alertsFrameAndWindowsBtn;
	private String alertsFrameAndWindowsBtnName = "alertsFrameAndWindowsBtn";
	private By alertsFrameAndWindowsBtnLoc = By.xpath("//*[contains(text(),'Alerts')]");
	private Button elementsBtn;
	private String elementsBtnName = "elementsBtn";
	private By elementsBtnLoc = By.xpath("//*[text()='Elements']");
	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
		this.alertsFrameAndWindowsBtn = new Button(alertsFrameAndWindowsBtnName,
				alertsFrameAndWindowsBtnLoc);
		this.elementsBtn = new Button(elementsBtnName, elementsBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName == alertsFrameAndWindowsBtn.getName()) {
			alertsFrameAndWindowsBtn.clickButton();
		} else if (buttonName == elementsBtn.getName()) {
			elementsBtn.clickButton();
		}
	}
}