package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import base.elements.TextBox;
import org.openqa.selenium.By;
import utils.Log;

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
		Log.log().info("Fill the first name.");
		firstNameInput.click();
		firstNameInput.sendKeys(keys);
	}

	public void sendKeysLastName(String keys) {
		Log.log().info("Fill the last name.");
		lastNameInput.click();
		lastNameInput.sendKeys(keys);
	}

	public void sendKeysEmail(String keys) {
		Log.log().info("Fill the email.");
		emailInput.click();
		emailInput.sendKeys(keys);
	}

	public void sendKeysAge(String keys) {
		Log.log().info("Fill the age.");
		ageInput.click();
		ageInput.sendKeys(keys);
	}

	public void sendKeysSalary(String keys) {
		Log.log().info("Fill the salary.");
		salaryInput.click();
		salaryInput.sendKeys(keys);
	}

	public void sendKeysDepartment(String keys) {
		Log.log().info("Fill the department.");
		departmentInput.click();
		departmentInput.sendKeys(keys);
	}

	public void clickSubmit() {
		Log.log().info("Press submit button.");
		submitBtn.click();
	}
}