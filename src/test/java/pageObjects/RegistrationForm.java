package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import base.elements.TextBox;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {
	private Label modalContent;
	private TextBox firstNameInput;
	private TextBox lastNameInput;
	private TextBox emailInput;
	private TextBox ageInput;
	private TextBox salaryInput;
	private TextBox departmentInput;
	private Button submitBtn;
	public RegistrationForm() {
		super("regForm", By.className("modal-dialog"));
		modalContent = new Label("modalContent", By.className("modal-content"));
		firstNameInput = new TextBox("firstNameInput", By.id("firstName"));
		lastNameInput = new TextBox("lastNameInput", By.id("lastName"));
		emailInput = new TextBox("emailInput", By.id("userEmail"));
		ageInput = new TextBox("ageInput", By.id("age"));
		salaryInput = new TextBox("salaryInput", By.id("salary"));
		departmentInput = new TextBox("departmentInput", By.id("department"));
		submitBtn = new Button("submitBtn", By.id("submit"));
	}


	public boolean isRegFormVisible() {
		return modalContent.isVisible();
	}
	public boolean isRegFormClosed() {
		return !modalContent.isStillVisible();
	}

	public void sendKeysFirstName(String keys) {
		firstNameInput.sendKeys(keys);
	}

	public boolean firstNameFilled() {
		return !firstNameInput.getText().isEmpty();
	}

	public void sendKeysLastName(String keys) {
		lastNameInput.sendKeys(keys);
	}

	public boolean lastNameFilled() {
		return lastNameInput.getTextFromModalElement(this.getLocator(), lastNameInput.getLocator()).length() > 0;
	}
	public void sendKeysEmail(String keys) {
		emailInput.sendKeys(keys);
	}
	public void sendKeysAge(String keys) {
		ageInput.sendKeys(keys);
	}
	public void sendKeysSalary(String keys) {
		salaryInput.sendKeys(keys);
	}

	public void sendKeysDepartment(String keys) {
		departmentInput.sendKeys(keys);
	}

	public void clickSubmit() {
		submitBtn.click();
	}
}
