package pageObjects;

import base.elements.Frame;
import org.openqa.selenium.By;

public class NestedFramesPage extends Frame {
	private FrameParent frameParent;
	private FrameChild frameChild;
	public NestedFramesPage() {
		super("nestedFramesPage", By.xpath("//div[text()='Nested Frames']"));
		frameParent = new FrameParent();
		frameChild = new FrameChild();
	}

	public boolean isParentFrameOpen() {
		return frameParent.isPageOpen();
	}

	public boolean isChildFrameOpen() {
		return frameChild.isPageOpen();
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