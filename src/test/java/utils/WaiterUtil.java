package utils;

import browser.Browser;
import config.Config;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AlertsPage;

import java.time.Duration;

public class WaiterUtil {
	private static WebDriverWait wait;
	private static int timeout;

	private WaiterUtil () {
	}

	public static WebDriverWait waiter() {
		WebDriver driver = Browser.getBrowserInstance();
		timeout = Config.getTimeout();
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait;
	}
}
