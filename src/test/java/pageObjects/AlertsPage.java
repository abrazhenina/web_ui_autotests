package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import browser.Browser;
import data.TestData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;
import utils.StringUtil;
import utils.Waits;

public class AlertsPage extends BaseForm {
	private Button seeAlertBtn = new Button("seeAlertBtn", By.id("alertButton"));
	private Button confirmBoxBtn = new Button("alertConfirmBoxBtn", By.id("confirmButton"));
	private Label confirmResultLabel = new Label("alertConfirmResultLabel", By.id("confirmResult"));
	private Button promptBoxBtn = new Button("alertPromptBoxBtn", By.id("promtButton"));
	private Label promptResultLabel = new Label("alertPromptResultLabel", By.id("promptResult"));
	String text = "text";
	String randomStr;
	public AlertsPage() {
		super("alertsPage", By.xpath("//div[text()='Alerts']"));
	}

	public void clickSeeAlertBtn() {
		Log.log().info("Click 'Button to see alert'");
		seeAlertBtn.click();
	}

	public void clickConfirmBoxBtn() {
		Log.log().info("Click 'On button click, confirm box will appear'");
		confirmBoxBtn.click();
	}

	public void clickPromptBoxBtn() {
		Log.log().info("Click 'On button click, prompt box will appear'");
		promptBoxBtn.click();
	}

	public boolean isAlertDisplayed() {
		Log.log().info("Alert opens.");
		return Waits.waiter().until(ExpectedConditions.alertIsPresent()) != null;
	}

	public boolean isAlertStillDisplayed() {
		try
		{
			Browser.getBrowserInstance().switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException Ex) {
			Log.log().info("Alert closed.");
			return false;
		}
	}

	public void acceptAlert() {
		Log.log().info("Click OK button.");
		Waits.waiter().until(ExpectedConditions.alertIsPresent()).accept();
	}

	public String sendRandomStrToAlertPrompt() {
		Log.log().info("Send random string to PromptBoxAlert.");
		randomStr = StringUtil.getRandomString();
		Waits.waiter().until(ExpectedConditions.alertIsPresent()).sendKeys(randomStr);
		return randomStr;
	}

	public String getAlertText() {
		text = Waits.waiter().until(ExpectedConditions.alertIsPresent()).getText();
		Log.log().info("Alert message is '"+text+"'");
		return text;
	}

	public String getConfirmResultText() {
		text = Waits.waiter().until(ExpectedConditions.presenceOfElementLocated(
				confirmResultLabel.getLocator())).getText();
		Log.log().info("Alert message is '"+text+"'");
		return text;
	}

	public String getPromptResultText() {
		text = Waits.waiter().until(ExpectedConditions.presenceOfElementLocated(
				promptResultLabel.getLocator())).getText();
		Log.log().info("Alert message is '"+text+"'");
		return text;
	}

	public boolean isStrInAlertText() {
		return StringUtil.strContainsSub(getPromptResultText(), randomStr);
	}
}