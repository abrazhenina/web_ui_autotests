package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameUpper extends Frame {

	private Label textLabel;
	private String textLabelName = "textLabel";
	private By textLabelLoc = By.id("sampleHeading");

	public FrameUpper() {
		super("frameUpper", By.id("frame1"));
		textLabel = new Label(textLabelName, textLabelLoc);
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}
