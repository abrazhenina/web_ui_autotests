package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
	private Button alertsFrameAndWindowsBtn = new Button("alertsFrameAndWindowsBtn",
			By.xpath("//*[contains(text(),'Alerts')]"));
	private Button elementsBtn = new Button("elementsBtn", By.xpath("//*[text()='Elements']"));
	public Button widgetsBtn = new Button("widgetsBtn", By.xpath("//*[text()='Widgets']"));

	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
	}

	public void clickAlertsFrameAndWindowsBtn() {
		alertsFrameAndWindowsBtn.click();
	}

	public void clickElementsBtn() {
		elementsBtn.click();
	}

	public void clickWidgetsBtn() {
		widgetsBtn.click();
	}
}