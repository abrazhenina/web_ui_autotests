package browser;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {

    private static WebDriver driver;
    private static String browserName;
    private static boolean browserIncognito;
    private static boolean browserLang;
    private static boolean browserWindowMaximized;

    private Browser() {
    }

    public static void setParameters(Config config) {
        browserName = config.browserName;
        browserIncognito = config.browserIncognito;
        browserLang = config.browserLang;
        browserWindowMaximized = config.browserWindowMaximized;
    }

    public static WebDriver getBrowserInstance() {
        if (driver == null) {
            switch (browserName.toLowerCase()) {
                case "chrome" -> {
                    ChromeOptions opt = new ChromeOptions();
                    if (browserIncognito) {opt.addArguments("--incognito");}
                    if (browserLang) {opt.addArguments("--lang=en");}
                    if (browserWindowMaximized) {opt.addArguments("--start-maximized");}
                    return getChromeInstance(opt);
                }
                case "firefox" -> {
                    FirefoxOptions opt = new FirefoxOptions();
                    if (browserIncognito) {opt.addArguments("--incognito");}
                    if (browserLang) {opt.addArguments("--lang=en");}
                    if (browserWindowMaximized) {opt.addArguments("--start-maximized");}
                    return getFirefoxInstance(opt);
                }
                default -> {
                    driver = WebDriverManager.chromedriver().create();
                }
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
    public static void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }
}