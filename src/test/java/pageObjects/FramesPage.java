package pageObjects;

import base.BaseForm;
import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;
import utils.Log;

public class FramesPage extends BaseForm {
	private Frame upperFrame = new Frame("upperFrame", By.id("frame1"));
	private Label upperTextLabel = new Label("upperTextLabel", By.id("sampleHeading"));
	private Frame lowerFrame = new Frame("lowerFrame", By.id("frame2"));
	private Label lowerTextLabel = new Label("textLabel", By.id("sampleHeading"));

	public FramesPage() {
		super("framesPage", By.xpath("//div[@class='main-header' and contains(text(),'Frames')]"));
	}

	public boolean isUpperFrameVisible() {
		Log.log().info("UpperFrame on FramesPage displayed.");
		return upperFrame.isVisible();
	}

	public boolean isLowerFrameVisible() {
		Log.log().info("LowerFrame on FramesPage displayed.");
		return upperFrame.isVisible();
	}

	public void switchToUpperFrame() {
		Log.log().info("Switch to UpperFrame.");
		upperFrame.switchToFrame();
	}

	public void switchToLowerFrame() {
		Log.log().info("Switch to LowerFrame.");
		lowerFrame.switchToFrame();
	}

	public String getTextFromUpperFrame() {
		Log.log().info("Read UpperFrame text.");
		return upperTextLabel.getText();
	}

	public String getTextFromLowerFrame() {
		Log.log().info("Read LowerFrame text.");
		return lowerTextLabel.getText();
	}

}