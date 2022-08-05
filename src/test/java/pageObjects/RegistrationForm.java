package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import base.elements.TextBox;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {
	private Label modalContent = new Label("modalContent", By.className("modal-content"));
	private TextBox firstNameInput = new TextBox("firstNameInput", By.id("firstName"));
	private TextBox lastNameInput = new TextBox("lastNameInput", By.id("lastName"));
	private TextBox emailInput = new TextBox("emailInput", By.id("userEmail"));
	private TextBox ageInput = new TextBox("ageInput", By.id("age"));
	private TextBox salaryInput = new TextBox("salaryInput", By.id("salary"));
	private TextBox departmentInput = new TextBox("departmentInput", By.id("department"));
	private Button submitBtn = new Button("submitBtn", By.id("submit"));

	public RegistrationForm() {
		super("regForm", By.className("modal-dialog"));
	}


	public boolean isRegFormVisible() {
		return modalContent.isVisible();
	}

	public boolean isRegFormClosed() {
		return !modalContent.isVisible();
	}

	public void sendKeysFirstName(String keys) {
		firstNameInput.click();
		firstNameInput.sendKeys(keys);
	}

	public boolean isFirstNameFilled() {
		return firstNameInput.getTextFromModalElement(this.getLocator(), firstNameInput.getLocator()).length() > 0;
	}

	public void sendKeysLastName(String keys) {
		lastNameInput.click();
		lastNameInput.sendKeys(keys);
	}

	public boolean isLastNameFilled() {
		return lastNameInput.getTextFromModalElement(this.getLocator(), lastNameInput.getLocator()).length() > 0;
	}

	public void sendKeysEmail(String keys) {
		emailInput.click();
		emailInput.sendKeys(keys);
	}

	public void sendKeysAge(String keys) {
		ageInput.click();
		ageInput.sendKeys(keys);
	}

	public void sendKeysSalary(String keys) {
		salaryInput.click();
		salaryInput.sendKeys(keys);
	}

	public void sendKeysDepartment(String keys) {
		departmentInput.click();
		departmentInput.sendKeys(keys);
	}

	public void clickSubmit() {
		submitBtn.click();
	}
}