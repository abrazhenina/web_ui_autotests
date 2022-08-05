package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.WebTable;
import org.openqa.selenium.By;

public class WebTablesPage extends BaseForm {
	private Button addBtn = new Button("addBtn", By.id("addNewRecordButton"));
	private WebTable webTableCells = new WebTable("webTableCells", By.className("rt-tbody"));
	private Button delRecordBtn = new Button("delRecordBtn", By.id("delete-record-4"));
	public WebTablesPage() {
		super("webTablesPage", By.xpath("//div[text()='Web Tables']"));
	}

	public void clickAddBtn() {
		addBtn.click();
	}

	public boolean isRecordInTable(String userData) {
		return webTableCells.isStringInTable(userData);
	}

	public boolean isRecordDeleted(String userData) {
		return !webTableCells.isStringInTable(userData);
	}

	public void deleteRecord() {
		webTableCells.deleteRecord(delRecordBtn.getLocator());
	}
}