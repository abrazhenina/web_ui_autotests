package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import browser.Browser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaiterUtil;
import utils.Waits;

public class AlertsPage extends BaseForm {
	private Button seeAlertBtn;
	private Button confirmBoxBtn;
	private Label confirmResultLabel;
	private Button promptBoxBtn;
	private Label promptResultLabel;

	public AlertsPage() {
		super("alertsPage", By.xpath("//div[text()='Alerts']"));
		this.seeAlertBtn = new Button("seeAlertBtn", By.id("alertButton"));
		this.confirmBoxBtn = new Button("alertConfirmBoxBtn", By.id("confirmButton"));
		this.confirmResultLabel = new Label("alertConfirmResultLabel", By.id("confirmResult"));
		this.promptBoxBtn = new Button("alertPromptBoxBtn", By.id("promtButton"));
		this.promptResultLabel = new Label("alertPromptResultLabel", By.id("promptResult"));
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(seeAlertBtn.getName()))
			seeAlertBtn.click();
		else if (buttonName.equals(confirmBoxBtn.getName())) {
			confirmBoxBtn.click();
		} else if (buttonName.equals(promptBoxBtn.getName())) {
			promptBoxBtn.click();
		}
	}

	public boolean isAlertDisplayed() {
		if (Waits.waiter().until(ExpectedConditions.alertIsPresent()) != null)
			return true;
		else
			return false;
	}

	public boolean isAlertStillDisplayed() {
		try
		{
			Browser.getBrowserInstance().switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException Ex) {
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

	public void sendKeysToAlertPrompt(String keys) {
		Alert alert = WaiterUtil.waiter().until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(keys);
	}

	public String getLabelText(String labelName) {
		if(labelName.equals(confirmResultLabel.getName())) {
			return Waits.waiter()
					.until(ExpectedConditions.presenceOfElementLocated(confirmResultLabel.getLocator()))
					.getText();
		} else if(labelName.equals(promptResultLabel.getName())) {
			return Waits.waiter()
					.until(ExpectedConditions.presenceOfElementLocated(promptResultLabel.getLocator()))
					.getText();
		}
		return null;
	}
}
