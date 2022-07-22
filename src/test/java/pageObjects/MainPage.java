package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import base.elements.TextBox;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

	public MainPage() {
		super("mainPage", By.cssSelector(".home-content"));
	}

	Label label;
	TextBox textBox;
	Button button = new Button("Alerts, Frame & Windows",
			By.xpath("//div[contains(@class,\"card \")]"));

	public void clickButton() {
		if (button.isDisplayed()) {
			button.clickButton();
		}
	}


}
