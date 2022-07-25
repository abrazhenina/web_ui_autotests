package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameLower extends Frame {
	private Label textLabel;
	private String textLabelName = "textLabel";
	private By textLabelLoc = By.id("sampleHeading");
	public FrameLower() {
		super("frameLower", By.id("frame2"));
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}