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
	private String seeAlertBtnName = "seeAlertBtn";
	private By seeAlertBtnLoc = By.id("alertButton");
	private Button confirmBoxBtn;
	private String confirmBoxBtnName = "alertConfirmBoxBtn";
	private By confirmBoxBtnLoc = By.id("confirmButton");
	private Label confirmResultLabel;
	private String confirmResultLabelName = "alertConfirmResultLabel";
	private By confirmResultLoc = By.id("confirmResult");
	private Button promptBoxBtn;
	private String promptBoxBtnName = "alertPromptBoxBtn";
	private By promptBoxBtnLoc = By.id("promtButton");
	private Label promptResultLabel;
	private String promptResultLabelName = "alertPromptResultLabel";
	private By promptResultLoc = By.id("promptResult");

	public AlertsPage() {
		super("alertsPage", By.xpath("//div[text()='Alerts']"));
		this.seeAlertBtn = new Button(seeAlertBtnName, seeAlertBtnLoc);
		this.confirmBoxBtn = new Button(confirmBoxBtnName, confirmBoxBtnLoc);
		this.confirmResultLabel = new Label(confirmResultLabelName, confirmResultLoc);
		this.promptBoxBtn = new Button(promptBoxBtnName, promptBoxBtnLoc);
		this.promptResultLabel = new Label(promptResultLabelName, promptResultLoc);
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
		if(labelName.equals(confirmResultLabelName)) {
			return Waits.waiter()
					.until(ExpectedConditions.presenceOfElementLocated(confirmResultLoc))
					.getText();
		} else if(labelName.equals(promptResultLabelName)) {
			return Waits.waiter()
					.until(ExpectedConditions.presenceOfElementLocated(promptResultLoc))
					.getText();
		}
		return null;
	}
}
