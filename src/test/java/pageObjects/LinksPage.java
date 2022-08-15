package pageObjects;

import base.BaseForm;
import base.elements.Link;
import org.openqa.selenium.By;
import utils.Log;
import utils.Waits;

public class LinksPage extends BaseForm {
	private Link linkHome = new Link("linkHome",  By.id("simpleLink"));
	private String originalWindow;
	public LinksPage() {
		super("linksPage", By.xpath("//div[@class='main-header' and contains(text(),'Links')]"));

	}

	public void clickHomeLink() {
		Log.log().info("Click HomeLink.");
		Log.log().info("New tab with MainPage opens.");
		originalWindow = getWindowID();
		int expectedNumOfWindows = 2;
		linkHome.click();
		Waits.waitForNewWindow(expectedNumOfWindows);
		changeToSecondWindowHandle(originalWindow);
	}

	public void switchToPrevPage() {
		Log.log().info("Switch to previous tab.");
		switchToWindow(originalWindow);
	}

	public boolean isLinksPageOpen() {
		Log.log().info("LinksPage opens.");
		return isOpen();
	}
}
