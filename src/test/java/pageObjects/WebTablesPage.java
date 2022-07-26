package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Label;
import base.elements.WebTable;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaiterUtil;
import utils.Waits;

import java.util.List;

public class WebTablesPage extends BaseForm {
	private Button addBtn;
	private String addBtnName = "addBtn";
	private By addBtnLoc = By.id("addNewRecordButton");
	private WebTable webTableCells;
	private String webTableCellsName = ".rt-tbody .rt-td";
	private By webTableCellsLoc = By.className("rt-tbody");
	public WebTablesPage() {
		super("webTablesPage", By.xpath("//div[text()='Web Tables']"));
		addBtn = new Button(addBtnName, addBtnLoc);
		webTableCells = new WebTable(webTableCellsName, webTableCellsLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(addBtn.getName()))
			addBtn.click();
	}

	public boolean isUserInTable(String userData) {
		return webTableCells.isStringInTable(userData);
	}

}