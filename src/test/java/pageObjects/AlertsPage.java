package pageObjects;

import base.BaseForm;
import base.elements.Button;
import browser.Browser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import utils.WaiterUtil;
import utils.Waits;

public class AlertsPage extends BaseForm {


	private By seeAlertBtnLoc = By.id("alertButton");
	private Button seeAlertBtn;
	private String seeAlertBtnName = "seeAlertBtn";
	private By alertConfirmBoxBtnLoc = By.id("confirmButton");
	private Button alertConfirmBoxBtn;
	private String alertConfirmBoxBtnName = "alertConfirmBoxBtn";

	public AlertsPage() {
		super("alertsPage", By.xpath("//div[text()='Alerts']"));
		this.seeAlertBtn = new Button(seeAlertBtnName, seeAlertBtnLoc);
		this.alertConfirmBoxBtn = new Button(alertConfirmBoxBtnName, alertConfirmBoxBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(seeAlertBtn.getName()))
			seeAlertBtn.clickButton();
		else if (buttonName.equals(alertConfirmBoxBtn.getName())) {
			alertConfirmBoxBtn.clickButton();
		}
		else System.out.println("No button found.g");
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
			WebDriver driver = Browser.getBrowserInstance();
			Alert alert = driver.switchTo().alert();
			if (alert != null) {
				return true;
			} else {
				return false;
			}
		}
		catch (NoAlertPresentException Ex)
		{
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
