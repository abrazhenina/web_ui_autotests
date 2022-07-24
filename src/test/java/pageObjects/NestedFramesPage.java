package pageObjects;

import base.BaseForm;
import base.elements.Frame;
import browser.Browser;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {
	private ParentFrame frameParent;
	public NestedFramesPage() {
		super("nestedFramesPage", By.xpath("//div[text()='Nested Frames']"));
		frameParent = new ParentFrame();
	}

	public boolean isFrameOpen() {
		return frameParent.isPageOpen();
	}

	public void switchToNestedFrame ()

}