package pageObjects;

import base.elements.Frame;
import base.elements.Label;
import org.openqa.selenium.By;

public class FrameChild extends Frame {
	private Label textLabel = new Label("textLabel", By.xpath("//p[text()='Child Iframe']"));
	public FrameChild() {
		super("frameChild", By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
	}

	public String getTextFromFrameLabel() {
		return textLabel.getText();
	}
}
