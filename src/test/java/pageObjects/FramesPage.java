package pageObjects;

import base.BaseForm;
import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;
import utils.Log;

public class FramesPage extends BaseForm {
	private Frame frameUpper = new Frame("frameUpper", By.id("frame1"));
	private Label upperTextLabel = new Label("upperTextLabel", By.id("sampleHeading"));
	private Frame frameLower = new Frame("frameLower", By.id("frame2"));
	private Label lowerTextLabel = new Label("textLabel", By.id("sampleHeading"));

	public FramesPage() {
		super("framesPage", By.xpath("//div[@class='main-header' and contains(text(),'Frames')]"));
	}

	public boolean isUpperFrameVisible() {
		Log.log().info("UpperFrame on FramesPage displayed.");
		return frameUpper.isVisible();
	}

	public boolean isLowerFrameVisible() {
		Log.log().info("LowerFrame on FramesPage displayed.");
		return frameUpper.isVisible();
	}

	public void switchToUpperFrame() {
		Log.log().info("Switch to UpperFrame.");
		frameUpper.switchToFrame();
	}

	public void switchToLowerFrame() {
		Log.log().info("Switch to LowerFrame.");
		frameLower.switchToFrame();
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