package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
	private Button alertsFrameAndWindowsBtn;
	private Button elementsBtn;
	public Button widgetsBtn;
	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
		this.alertsFrameAndWindowsBtn = new Button("alertsFrameAndWindowsBtn",
				By.xpath("//*[contains(text(),'Alerts')]"));
		this.elementsBtn = new Button("elementsBtn", By.xpath("//*[text()='Elements']"));
		this.widgetsBtn = new Button("widgetsBtn", By.xpath("//*[text()='Widgets']"));
	}

	public void clickButton(String buttonName) {
		if (buttonName == alertsFrameAndWindowsBtn.getName()) {
			alertsFrameAndWindowsBtn.click();
		} else if (buttonName == elementsBtn.getName()) {
			elementsBtn.click();
		} else if (buttonName == widgetsBtn.getName()) {
			widgetsBtn.click();
		}
	}
}