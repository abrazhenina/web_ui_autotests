package pageObjects;

import base.elements.Frame;
import org.openqa.selenium.By;

public class NestedFramesPage extends Frame {
	private FrameParent frameParent = new FrameParent();
	private FrameChild frameChild = new FrameChild();
	public NestedFramesPage() {
		super("nestedFramesPage", By.xpath("//div[text()='Nested Frames']"));
	}

	public boolean isParentFrameOpen() {
		return frameParent.isOpen();
	}

	public boolean isChildFrameOpen() {
		return frameChild.isOpen();
	}

	public void switchToParentFrame() {
		frameParent.switchToFrame();
	}

	public void switchToChildFrame() {
		frameChild.switchToFrame();
	}

	public String getTextFromParentFrame() {
		return frameParent.getTextFromFrameLabel();
	}

	public String getTextFromChildFrame() {
		return frameChild.getTextFromFrameLabel();
	}
}