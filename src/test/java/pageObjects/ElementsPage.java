package pageObjects;

import base.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
	private Button webTablesBtn;
	public ElementsPage() {
		super("elementsPage", By.xpath("//div[@class='main-header' and contains(text(),'Elements')]"));
		this.webTablesBtn = new Button("webTablesBtn", By.xpath("//span[text()='Web Tables']"));
	}

	public void clickButton(String buttonName) {
		if (buttonName.equals(webTablesBtn.getName()))
			webTablesBtn.click();
	}
}
