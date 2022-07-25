package pageObjects;

import base.BaseForm;
import org.openqa.selenium.By;

public class WebTablesPage extends BaseForm {
	public WebTablesPage() {
		super("webTablesPage", By.xpath("//div[text()='Web Tables']"));
	}
}
