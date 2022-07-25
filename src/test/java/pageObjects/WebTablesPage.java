package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class WebTablesPage extends BaseForm {
	private Button addBtn;
	private String addBtnName = "addBtn";
	private By addBtnLoc = By.id("addNewRecordButton");
	public WebTablesPage() {
		super("webTablesPage", By.xpath("//div[text()='Web Tables']"));
		addBtn = new Button(addBtnName, addBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(addBtn.getName()))
			addBtn.clickButton();
	}
}