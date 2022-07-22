package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
	private Button alertsFrameAndWindowsBtn = new Button("alertsFrameAndWindowsBtn",
			By.xpath("//div[contains(@class,'card')]"));

	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
	}

	public void clickButton(String buttonName) {
		if (buttonName == alertsFrameAndWindowsBtn.getName()) {
			alertsFrameAndWindowsBtn.clickButton();
		}
	}


}
