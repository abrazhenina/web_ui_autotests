package pageObjects;

import base.elements.Frame;
import org.openqa.selenium.By;
import utils.Log;

public class FramesPage extends Frame {
	private FrameUpper frameUpper = new FrameUpper();
	private FrameLower frameLower = new FrameLower();

	public FramesPage() {
		super("framesPage", By.xpath("//div[@class='main-header' and contains(text(),'Frames')]"));
	}

	public boolean isUpperFrameOpen() {
		Log.log().info("UpperFrame on FramesPage displayed.");
		return frameUpper.isOpen();
	}

	public boolean isLowerFrameOpen() {
		Log.log().info("LowerFrame on FramesPage displayed.");
		return frameUpper.isOpen();
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
		return frameUpper.getTextFromFrameLabel();
	}

	public String getTextFromLowerFrame() {
		Log.log().info("Read LowerFrame text.");
		return frameLower.getTextFromFrameLabel();
	}

}