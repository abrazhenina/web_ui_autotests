package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import base.elements.TextBox;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
	public MainPage() {
		super("mainPage", By.id("MainPage"));
	}

	Label label;
	TextBox textBox;
	Button button;
}
