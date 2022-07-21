package tests;

import browser.Browser;
import config.Config;
import data.TestData;
import org.testng.Assert;
import pageObjects.AlertsWindowsPage;
import pageObjects.MainPage;
import utils.JsonReader;
import pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class test {
    Browser browser;
    WebDriver driver;
    WebDriverWait wait;
    String testDataPath = "src/test/resources/testData.json";
    String configPath = "src/test/resources/config.json";
    TestData testData;
    Config config;
    HomePage homePage;
    MainPage mainPage;
    AlertsWindowsPage alertsPage;

    @BeforeTest
    void setup () throws IOException {
        try {
            config = new Config(JsonReader.readJson(configPath));
            testData = new TestData(JsonReader.readJson(testDataPath));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        Browser.setParameters(config);
        driver = Browser.getBrowserInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(config.timeout));
        homePage = new HomePage(driver, config, testData);
        mainPage = new MainPage();
    }

    @Test(priority = 1)
    void testCase1() {
        // 1
        Reporter.log("Go to MainPage.", true);
        Browser.goToUrl(driver, config.homePageAddress);
        Reporter.log("MainPage is opened.", true);
        mainPage.isPageOpen();
        Reporter.log("Click AlertsPage button.", true);
        mainPage.clickButton();
    }


    @AfterTest
    void tearDown() {
        driver.quit();
    }
}