package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameParent extends Frame {
	private Label textLabel;
	private String textLabelName = "textLabel";
	private By textLabelLoc = By.xpath("//body[text()='Parent frame']");
	public FrameParent() {
		super("frameParent", By.id("frame1"));
		textLabel = new Label(textLabelName, textLabelLoc);
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}