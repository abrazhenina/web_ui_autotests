package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
	private static WebDriver driver;
	private static String browserName;
	private static boolean browserIncognito;
	private static boolean browserLang;
	private static boolean browserWindowMaximized;

	private BrowserFactory() {
	}

	public static WebDriver getBrowser() {
			browserName = BrowserConfig.getBrowserName();
			browserIncognito = BrowserConfig.getBrowserIncognito();
			browserLang = BrowserConfig.getBrowserLang();
			browserWindowMaximized = BrowserConfig.getBrowserWindowMaximized();
			switch (browserName.toLowerCase()) {
				case "chrome" -> {
					ChromeOptions opt = new ChromeOptions();
					opt.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
					if (browserIncognito) {
						opt.addArguments("--incognito");
					}
					if (browserLang) {
						opt.addArguments("--lang=en");
					}
					if (browserWindowMaximized) {
						opt.addArguments("--start-maximized");
					}
					return getChromeInstance(opt);
				}
				case "firefox" -> {
					FirefoxOptions opt = new FirefoxOptions();
					opt.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
					if (browserIncognito) {
						opt.addArguments("-private");}
					if (browserLang) {
						opt.addArguments("--lang=en");
					}
					if (browserWindowMaximized) {
						opt.addArguments("--start-maximized");
					}
					return getFirefoxInstance(opt);
				}
				default -> {
					driver = WebDriverManager.chromedriver().create();
				}
			}
			return driver;
	}

	public static WebDriver getChromeInstance(ChromeOptions opt) {
		return WebDriverManager.chromedriver().capabilities(opt).create();
	}

	public static WebDriver getFirefoxInstance(FirefoxOptions opt) {
		return WebDriverManager.firefoxdriver().capabilities(opt).create();
	}
}