package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.WebTable;
import org.openqa.selenium.By;
import utils.Log;

public class WebTablesPage extends BaseForm {
	private Button addBtn = new Button("addBtn", By.id("addNewRecordButton"));
	private WebTable webTableCells = new WebTable("webTableCells", By.className("rt-tbody"));
	private Button delRecordBtn = new Button("delRecordBtn", By.id("delete-record-4"));
	public WebTablesPage() {
		super("webTablesPage", By.xpath("//div[contains(text(),'Web Tables')]"));
	}

	public void clickAddBtn() {
		Log.log().info("Click AddButton that opens RegistrationFrom.");
		addBtn.click();
	}

	public boolean isRecordInTable(String userData) {
		Log.log().info(userData + "is in the table.");
		return webTableCells.isStringInTable(userData);
	}

	public boolean isRecordDeleted(String userData) {
		Log.log().info(userData + " is deleted from the table.");
		return !webTableCells.isStringInTable(userData);
	}

	public void deleteRecord() {
		Log.log().info("Delete record.");
		webTableCells.deleteRecord(delRecordBtn.getLocator());
	}
}