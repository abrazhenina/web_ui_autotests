package browser;

import org.openqa.selenium.WebDriver;
import utils.Log;

public class Browser {

	private static WebDriver driver = null;

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

	public static void setDriverNull() {
		driver = null;
	}
}







