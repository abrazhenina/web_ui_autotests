package utils;

import browser.Browser;
import browser.BrowserConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Waits{
	private static WebDriverWait wait;
	private static int timeout;

	private Waits () {
	}

	public static WebDriverWait waiter() {
		WebDriver driver = Browser.getBrowserInstance();
		timeout = BrowserConfig.getTimeout();
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait;
	}

	public static void waitForNewWindow(int expectedNumOfWindows) {
		Waits.waiter().until(numberOfWindowsToBe(expectedNumOfWindows));
	}
}