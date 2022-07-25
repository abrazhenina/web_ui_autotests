package pageObjects;

import base.elements.Frame;
import org.openqa.selenium.By;

public class FramesPage extends Frame {
	private FrameUpper frameUpper;
	private FrameLower frameLower;

	public FramesPage() {
		super("framesPage", By.xpath("//div[@class='main-header' and contains(text(),'Frames')]"));
		frameUpper = new FrameUpper();
		frameLower = new FrameLower();
	}

	public boolean isUpperFrameOpen() {
		return frameUpper.isOpen();
	}

	public boolean isLowerFrameOpen() {
		return frameUpper.isOpen();
	}

	public void switchToUpperFrame() {
		frameUpper.switchToFrame();
	}

	public void switchToLowerFrame() {
		frameLower.switchToFrame();
	}

	public String getTextFromUpperFrame() {
		return frameUpper.getTextFromFrameLabel();
	}

	public String getTextFromLowerFrame() {
		return frameLower.getTextFromFrameLabel();
	}

}
