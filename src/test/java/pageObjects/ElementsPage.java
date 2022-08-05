package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Form;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
	private Button webTablesBtn;
	public Button uploadDownloadBtn;
	public Form uploadDownloadForm;
	public Button downloadBtn;
	public ElementsPage() {
		super("elementsPage", By.xpath("//div[@class='main-header' and contains(text(),'Elements')]"));
		webTablesBtn = new Button("webTablesBtn", By.xpath("//span[text()='Web Tables']"));
		uploadDownloadBtn = new Button("uploadDownloadBtn", By.xpath("//span[text()='Upload and Download']"));
		uploadDownloadForm = new Form("uploadDownloadForm", By.xpath("//div[@class='main-header' and contains(text(),'Upload')]"));
		downloadBtn = new Button("", By.id("downloadButton"));
	}

	public void clickWebTablesBtn() {
		webTablesBtn.click();
	}

	public void clickUploadDownloadBtn() {
		uploadDownloadBtn.click();
	}

	public void clickDownloadBtn() {
		downloadBtn.click();
	}

	public boolean isUploadDownloadFormOpen() {
		return uploadDownloadForm.isOpen();
	}
}
