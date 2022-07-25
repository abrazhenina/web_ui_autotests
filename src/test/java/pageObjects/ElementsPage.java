package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
	private Button webTablesBtn;
	private String webTablesBtnName = "webTablesBtn";
	private By webTablesBtnLoc = By.xpath("//span[text()='Web Tables']");
	public ElementsPage() {
		super("elementsPage", By.xpath("//div[@class='main-header' and contains(text(),'Elements')]"));
		this.webTablesBtn = new Button(webTablesBtnName, webTablesBtnLoc);
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(webTablesBtn.getName()))
			webTablesBtn.click();
	}
}
