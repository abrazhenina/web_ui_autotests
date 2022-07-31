package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameParent extends Frame {
	private Label textLabel;
	public FrameParent() {
		super("frameParent", By.id("frame1"));
		textLabel = new Label("textLabel", By.xpath("//body[text()='Parent frame']"));
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}