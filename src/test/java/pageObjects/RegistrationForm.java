package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import base.elements.TextBox;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationForm extends BaseForm {
	private Label modalContent;
	private String modalContentName = "modalContent";
	private By modalContentLoc = By.className("modal-content");
	private TextBox firstNameInput;
	private String firstNameInputName = "firstNameInput";
	private By firstNameInputLoc = By.id("firstName");
	private TextBox lastNameInput;
	private String lastNameInputName = "lastNameInput";
	private By lastNameInputLoc = By.id("lastName");
	private TextBox emailInput;
	private String emailInputName = "emailInput";
	private By emailInputLoc = By.id("userEmail");
	private TextBox ageInput;
	private String ageInputName = "ageInput";
	private By ageInputLoc = By.id("age");
	private TextBox salaryInput;
	private String salaryInputName = "salaryInput";
	private By salaryInputLoc = By.id("salary");
	private TextBox departmentInput;
	private String departmentInputName = "departmentInput";
	private By departmentInputLoc = By.id("department");
	private Button submitBtn;
	private String submitBtnName = "submitBtn";
	private By submitBtnLoc = By.id("submit");

	public RegistrationForm() {
		super("regForm", By.className("modal-dialog"));
		modalContent = new Label(modalContentName, modalContentLoc);
		firstNameInput = new TextBox(firstNameInputName, firstNameInputLoc);
		lastNameInput = new TextBox(lastNameInputName, lastNameInputLoc);
		emailInput = new TextBox(emailInputName, emailInputLoc);
		ageInput = new TextBox(ageInputName, lastNameInputLoc);
		salaryInput = new TextBox(salaryInputName, salaryInputLoc);
		departmentInput = new TextBox(departmentInputName, departmentInputLoc);
		submitBtn = new Button(submitBtnName, submitBtnLoc);
	}


	public boolean isRegFormContentVisible() {
		return modalContent.isVisible();
	}
	public boolean isRegFormContentStillVisible() {
		return modalContent.isStillVisible();
	}

	public void sendKeysFirstName(String keys) {
		firstNameInput.sendKeysToModalInput(this.getLocator(), firstNameInputLoc, keys);
		firstNameInput.sendKeys(keys);
	}

	public boolean firstNameFilled() {
		return firstNameInput.getTextFromModalElement(this.getLocator(), firstNameInputLoc).length()>0;
	}

	public void sendKeysLastName(String keys) {
		lastNameInput.sendKeys(keys);
	}

	public boolean lastNameFilled() {
		if (lastNameInput.getTextFromModalElement(this.getLocator(), lastNameInputLoc).length()>0)
			return true;
		return false;
	}
	public void sendKeysEmail(String keys) {
		firstNameInput.sendKeys(keys);
	}
	public void sendKeysAge(String keys) {
		firstNameInput.sendKeys(keys);
	}
	public void sendKeysSalary(String keys) {
		firstNameInput.sendKeys(keys);
	}

	public void sendKeysDepartment(String keys) {
		firstNameInput.sendKeys(keys);
	}

	public void clickSubmit() {
		submitBtn.clickButton();
	}
}
