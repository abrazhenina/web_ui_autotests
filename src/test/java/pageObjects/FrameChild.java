package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameChild extends Frame {
	private Label textLabel;
	private String textLabelName = "textLabel";
	private By textLabelLoc = By.xpath("//p[text()='Child Iframe']");
	public FrameChild() {
		super("frameChild", By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		textLabel = new Label(textLabelName, textLabelLoc);
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}
