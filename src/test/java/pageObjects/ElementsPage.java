package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Form;
import base.elements.TextBox;
import org.openqa.selenium.By;
import utils.Constants;

import java.io.File;

public class ElementsPage extends BaseForm {
	private Button webTablesBtn = new Button("webTablesBtn", By.xpath("//span[text()='Web Tables']"));
	public Button uploadDownloadBtn = new Button("uploadDownloadBtn", By.xpath("//span[text()='Upload and Download']"));
	public Form uploadDownloadForm = new Form("uploadDownloadForm", By.xpath("//div[@class='main-header' and contains(text(),'Upload')]"));
	public Button downloadBtn = new Button("", By.id("downloadButton"));
	private Button uploadBtn = new Button("uploadBtn", By.id("uploadFile"));
	String fileName = "";
	public ElementsPage() {
		super("elementsPage", By.xpath("//div[@class='main-header' and contains(text(),'Elements')]"));
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

	public void clickUploadBtn() {
		uploadBtn.clickJS();
	}

	public boolean isUploadDownloadFormOpen() {
		return uploadDownloadForm.isOpen();
	}

	public boolean isFileDownloaded() {
		File f = new File(Constants.getDownloadsFolderPath());
		if(f.exists() && !f.isDirectory()) {
			fileName = f.getName();
			return true;
		}
		return false;
	}
}
