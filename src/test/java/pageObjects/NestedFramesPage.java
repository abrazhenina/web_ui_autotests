package pageObjects;

import base.BaseForm;
import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;
import utils.Log;

public class NestedFramesPage extends BaseForm {
	private Frame frameParent = new Frame("frameParent", By.id("frame1"));
	private Label parentTextLabel = new Label("parentTextLabel", By.xpath(
			"//*[contains(text(),'Parent frame')]"));
	private Frame frameChild = new Frame("frameChild", By.xpath(
				"//*[@srcdoc='<p>Child Iframe</p>']"));
	private Label childTextLabel = new Label("childTextLabel", By.xpath(
			"//*[contains(text(),'Child Iframe')]"));
	public NestedFramesPage() {
		super("nestedFramesPage",
				By.xpath("//div[contains(text(),'Nested Frames')]"));
	}

	public void switchToParentFrame() {

		frameParent.switchToFrame();
	}

	public void switchToChildFrame() {
		frameChild.switchToFrame();
	}

	public String getTextFromParentFrame() {
		Log.log().info("ParentFrame text is '" + parentTextLabel.getText() + "'.");
		return parentTextLabel.getText();
	}

	public String getTextFromChildFrame() {
		Log.log().info("ChildFrame text is '" + childTextLabel.getText() + "'.");
		return childTextLabel.getText();
	}
}