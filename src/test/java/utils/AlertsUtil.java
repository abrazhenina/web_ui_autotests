package utils;

import browser.Browser;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsUtil {
	private String text = "";
	public static boolean isAlertDisplayed() {
		Log.log().info("Alert opens.");
		return Waits.waiter().until(ExpectedConditions.alertIsPresent()) != null;
	}

	public static void acceptAlert() {
		Log.log().info("Click OK button.");
		Waits.waiter().until(ExpectedConditions.alertIsPresent()).accept();
	}

	public static String sendRandomStrToAlertPrompt() {
		Log.log().info("Send random string to PromptBoxAlert.");
		String randomStr = StringUtil.getRandomString();
		Waits.waiter().until(ExpectedConditions.alertIsPresent()).sendKeys(randomStr);
		return randomStr;
	}

	public static boolean isAlertStillDisplayed() {
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

	public static String getAlertText() {
		String text = Waits.waiter().until(ExpectedConditions.alertIsPresent()).getText();
		Log.log().info("Alert message is '"+text+"'");
		return text;
	}
}
