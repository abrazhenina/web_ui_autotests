package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaiterUtil;
import utils.Waits;

public class AlertsPage extends BaseForm {

	private Button seeAlertBtn = new Button("seeAlertBtn", By.xpath(
			"//span[contains(text(),'see alert')]//parent::div[@class='col-md-6']//following-sibling::div//button"));

	private Button alertConfirmBoxBtn = new Button("seeAlertBtn", By.xpath(
			"//span[contains(text(),'confirm box')]//parent::div[@class='col-md-6']//following-sibling::div//button"));

	public AlertsPage() {
		super("alertsPage", By.xpath("//div[text()='Alerts']"));
	}

	public void clickButton(String buttonName) {
		if (buttonName == seeAlertBtn.getName()) {
			seeAlertBtn.clickButton();
		}
	}

	public boolean isAlertDisplayed() {
		Alert alert = WaiterUtil.waiter().until(ExpectedConditions.alertIsPresent());
		if (alert != null) {
			return true;
		} else {
			return false;
		}
	}

	public String getAlertText() {
		Alert alert = WaiterUtil.waiter().until(ExpectedConditions.alertIsPresent());
		return alert.getText();
	}

	public void acceptAlert() {
		Alert alert = WaiterUtil.waiter().until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}
}
