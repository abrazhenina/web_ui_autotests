package browser;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {

    private static WebDriver driver;
    private static String browserName;
    private static String homePageAddress;
    private static boolean browserIncognito;
    private static boolean browserLang;
    private static boolean browserWindowMaximized;

    private Browser() {
    }

    public static WebDriver getBrowserInstance(Config config) {
        homePageAddress = config.homePageAddress;
        String browserName = config.browserName;
        browserIncognito = config.browserIncognito;
        browserLang = config.browserLang;
        browserWindowMaximized = config.browserWindowMaximized;


        if (driver == null) {
            switch (browserName.toLowerCase()) {
                case "chrome" -> {
                    ChromeOptions opt = new ChromeOptions();
                    if (browserIncognito) {
                        opt.addArguments("--incognito");
                    }
                    if (browserLang) {
                        opt.addArguments("--lang=en");
                    }
                    if (browserWindowMaximized) {
                        opt.addArguments("--start-maximized");
                    }
                    driver = WebDriverManager.chromedriver().capabilities(opt).create();
                }
                case "firefox" -> {
                    FirefoxOptions opt = new FirefoxOptions();
                    if (browserIncognito) {
                        opt.addArguments("--incognito");
                    }
                    if (browserLang) {
                        opt.addArguments("--lang=en");
                    }
                    if (browserWindowMaximized) {
                        opt.addArguments("--start-maximized");
                    }
                    driver = WebDriverManager.firefoxdriver().capabilities(opt).create();
                }
                default -> {
                    driver = WebDriverManager.chromedriver().create();
                }
            }
        }
        return driver;
    }

    public static void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }
}