package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameUpper extends Frame {

	private Label textLabel = new Label("textLabel", By.id("sampleHeading"));

	public FrameUpper() {
		super("frameUpper", By.id("frame1"));

	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}
