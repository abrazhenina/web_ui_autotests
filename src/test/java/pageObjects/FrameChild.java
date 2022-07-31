package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameChild extends Frame {
	private Label textLabel;
	public FrameChild() {
		super("frameChild", By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		textLabel = new Label("textLabel", By.xpath("//p[text()='Child Iframe']"));
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}
