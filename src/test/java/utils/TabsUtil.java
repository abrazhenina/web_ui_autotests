package utils;

import browser.Browser;
import org.openqa.selenium.WebDriver;

public class TabsUtil {
	public static String originalWindow;

	public static String getWindowID() {
		return Browser.getBrowserInstance().getWindowHandle();
	}

	public static void changeToSecondWindowHandle() {
		WebDriver driver = Browser.getBrowserInstance();
		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public static void switchToWindow(String window) {
		Browser.getBrowserInstance().switchTo().window(window);
	}

	public static void closeTab() {
		WebDriver driver = Browser.getBrowserInstance();
		driver.close();
		driver.switchTo().window(originalWindow);
	}

	public static void closeCurrentTab() {
		Log.log().info("Close this tab.");
		closeTab();
	}

	public static void switchToPrevPage() {
		Log.log().info("Switch to previous tab.");
		switchToWindow(originalWindow);
	}
}