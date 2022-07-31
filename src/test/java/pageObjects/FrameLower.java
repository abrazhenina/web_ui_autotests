package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameLower extends Frame {
	private Label textLabel;
	public FrameLower() {
		super("frameLower", By.id("frame2"));
		textLabel = new Label("textLabel", By.id("sampleHeading"));
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}