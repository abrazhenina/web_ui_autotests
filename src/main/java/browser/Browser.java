package browser;

import org.openqa.selenium.WebDriver;

public class Browser {

	private static WebDriver driver;

	private Browser() {
	}

	public static WebDriver getBrowserInstance() {
		if (driver == null) {
				driver = BrowserFactory.getBrowser();
		}
		return driver;
	}

	public static void goToUrl(String url) {
		getBrowserInstance().get(url);
	}
}