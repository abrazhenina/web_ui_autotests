package pageObjects;

import base.elements.Frame;
import org.openqa.selenium.By;

public class FramesPage extends Frame {
	private FrameUpper frameUpper = new FrameUpper();
	private FrameLower frameLower = new FrameLower();

	public FramesPage() {
		super("framesPage", By.xpath("//div[@class='main-header' and contains(text(),'Frames')]"));
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
