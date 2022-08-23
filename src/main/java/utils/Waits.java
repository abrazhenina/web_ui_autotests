package utils;

import browser.Browser;
import browser.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Waits{
	private Waits () {
	}

	public static WebDriverWait waiter() {
		return new WebDriverWait(Browser.getBrowserInstance(),
				Duration.ofSeconds(BrowserConfig.getTimeout()));    
	}

	public static void waitForNewWindow(int expectedNumOfWindows) {
		Waits.waiter().until(numberOfWindowsToBe(expectedNumOfWindows));
	}
}