package pageObjects;

import base.BaseForm;
import base.elements.Label;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {

	private Label modalContent;
	private String modalContentName = "modalContent";
	private By modalContentLoc = By.className("modal-content");

	public RegistrationForm() {
		super("regForm", By.className("modal-dialog"));
		modalContent = new Label(modalContentName, modalContentLoc);
	}

	public boolean isRegFormContentVisible() {
		return modalContent.isVisible();
	}

	public String getModalContentText() {
		return modalContent.getText();
	}
}
