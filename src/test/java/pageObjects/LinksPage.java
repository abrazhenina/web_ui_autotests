package pageObjects;

import base.BaseForm;
import base.elements.Link;
import org.openqa.selenium.By;
import utils.Waits;

public class LinksPage extends BaseForm {
	private Link linkHome;
	private String linkHomeName = "linkHome";
	private By linkHomeLoc = By.id("simpleLink");
	private String originalWindow;
	public LinksPage() {
		super("linksPage", By.xpath("//div[@class='main-header' and contains(text(),'Links')]"));
		linkHome = new Link(linkHomeName, linkHomeLoc);
	}

	public void clickHomeLink() {
		originalWindow = getWindowID();
		int expectedNumOfWindows = 2;
		linkHome.click();
		Waits.waitForNewWindow(expectedNumOfWindows);
		changeToSecondWindowHandle(originalWindow);
	}

	public void switchToPrevPage() {
		switchToWindow(originalWindow);
	}
}
