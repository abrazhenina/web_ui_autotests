package pageObjects;

import base.elements.Frame;
import org.openqa.selenium.By;
import utils.Log;

public class NestedFramesPage extends Frame {
	private FrameParent frameParent = new FrameParent();
	private FrameChild frameChild = new FrameChild();
	public NestedFramesPage() {
		super("nestedFramesPage", By.xpath("//div[contains(text(),'Nested Frames')]"));
	}

	public boolean isParentFrameOpen() {
		Log.log().info("ParentFrame displayed on NestedFramesPage.");
		return frameParent.isOpen();
	}

	public boolean isChildFrameOpen() {
		Log.log().info("ChildFrame displayed on NestedFramesPage.");
		return frameChild.isOpen();
	}

	public void switchToParentFrame() {
		frameParent.switchToFrame();
	}

	public void switchToChildFrame() {
		frameChild.switchToFrame();
	}

	public String getTextFromParentFrame() {
		Log.log().info("ParentFrame text is '" + frameParent.getTextFromFrameLabel() + "'.");
		return frameParent.getTextFromFrameLabel();
	}

	public String getTextFromChildFrame() {
		Log.log().info("ChildFrame text is '" + frameChild.getTextFromFrameLabel() + "'.");
		return frameChild.getTextFromFrameLabel();
	}
}