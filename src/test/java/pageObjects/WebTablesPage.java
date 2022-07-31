package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.WebTable;
import org.openqa.selenium.By;

public class WebTablesPage extends BaseForm {
	private Button addBtn;
	private WebTable webTableCells;
	private Button delRecordBtn;
	public WebTablesPage() {
		super("webTablesPage", By.xpath("//div[text()='Web Tables']"));
		addBtn = new Button("addBtn", By.id("addNewRecordButton"));
		webTableCells = new WebTable("webTableCells", By.className("rt-tbody"));
		delRecordBtn = new Button("delRecordBtn", By.id("delete-record-4"));
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(addBtn.getName()))
			addBtn.click();
	}

	public boolean isRecordInTable(String userData) {
		return webTableCells.isStringInTable(userData);
	}

	public boolean isRecordDeleted(String userData) {
		return webTableCells.isStringDeletedFromTable(userData);
	}

	public void deleteRecord() {
		webTableCells.deleteRecord(delRecordBtn.getLocator());
	}

}