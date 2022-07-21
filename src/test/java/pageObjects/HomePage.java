package pageObjects;

import config.Config;
import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private Config config;
    private TestData testData;
    private static String homeElementLoc = ".home_cluster_ctn";
    private static String aboutBtnLoc = "a[href*='about']";
    private static String noteWorthyTabLoc = "#noteworthy_tab";
    private static String noteWorthyMenuTopSellersBtnLoc = "#noteworthy_flyout > div > a[href*=\"topsellers\"]";
    private static String homePageCommunityBtnLoc = ".content [data-tooltip-content=\".submenu_community\"]";
    private static String homePageCommunitySubmenuMarketBtnLoc = ".content .submenu_community a[href*=\"market\"]";
    private static String homePageCommunitySubmenuLoc = ".content .submenu_community";

    public HomePage(WebDriver driver, Config config, TestData testData) {
        this.driver = driver;
        this.config = config;
        this.testData = testData;
    }

    public boolean isHomeElementDisplayed() {
        return this.driver.findElement(By.cssSelector(homeElementLoc)).isDisplayed();
    }

    public boolean isHomePageAboutBtnDisplayed() {
        return this.driver.findElement(By.cssSelector(aboutBtnLoc)).isDisplayed();
    }

    public void clickAboutBtnOnHomePage() {
        this.driver.findElement(By.cssSelector(aboutBtnLoc)).click();
    }

    public boolean isNoteWorthyTabDisplayed() {
        return this.driver.findElement(By.cssSelector(noteWorthyTabLoc)).isDisplayed();
    }

    public void hoverOverNoteWorthyTab() {
        WebElement noteworthyTab = this.driver.findElement(By.cssSelector(noteWorthyTabLoc));
        new Actions(this.driver).moveToElement(noteworthyTab).perform();
        new WebDriverWait(this.driver, Duration.ofSeconds(this.config.timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector(noteWorthyMenuTopSellersBtnLoc)));
    }

    public boolean isTopSellersBtnDisplayed() {
        return this.driver.findElement(By.cssSelector(noteWorthyMenuTopSellersBtnLoc)).isDisplayed();
    }

    public void clickTopSellersBtn() {
        this.driver.findElement(By.cssSelector(noteWorthyMenuTopSellersBtnLoc)).click();
    }

    public boolean isHomePageCommunityBtnDisplayed() {
        return this.driver.findElement(By.cssSelector(homePageCommunityBtnLoc)).isDisplayed();
    }

    public void hoverOverHomePageCommunityBtn() {
        WebElement homePageCommunityBtn = this.driver.findElement(By.cssSelector(homePageCommunityBtnLoc));
        new Actions(this.driver).moveToElement(homePageCommunityBtn).perform();
        new WebDriverWait(this.driver, Duration.ofSeconds(this.config.timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector(homePageCommunityBtnLoc)));
    }

    public boolean isCommunitySubmenuDisplayed() {
        return this.driver.findElement(By.cssSelector(homePageCommunitySubmenuLoc)).isDisplayed();
    }

    public boolean isCommunitySubmenuMarketBtnDisplayed() {
        return this.driver.findElement(By.cssSelector(homePageCommunitySubmenuMarketBtnLoc)).isDisplayed();
    }

    public void clickCommunitySubmenuMarketBtn() {
        this.driver.findElement(By.cssSelector(homePageCommunitySubmenuMarketBtnLoc)).click();
    }
}