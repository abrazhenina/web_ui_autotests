package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Form;
import base.elements.Label;
import base.elements.TextBox;
import browser.Browser;
import org.openqa.selenium.By;
import utils.Log;

public class ElementsPage extends BaseForm {
	private Button webTablesBtn = new Button("webTablesBtn", By.xpath("//span[text()='Web Tables']"));
	public Button uploadDownloadBtn = new Button("uploadDownloadBtn", By.xpath("//span[text()='Upload and Download']"));
	public Form uploadDownloadForm = new Form("uploadDownloadForm", By.xpath("//div[@class='main-header' and contains(text(),'Upload')]"));
	public Button downloadBtn = new Button("", By.id("downloadButton"));
	private TextBox uploadFileInput = new TextBox("uploadFileInput", By.id("uploadFile"));

	private Label uploadedFileLabel = new Label("uploadedFileLabel", By.id("uploadedFilePath"));
	public ElementsPage() {
		super("elementsPage", By.xpath("//div[@class='main-header' and contains(text(),'Elements')]"));
	}

	public void clickWebTablesBtn() {
		Log.log().info("Click WebTablesPageButton.");
		webTablesBtn.click();
	}

	public void clickUploadDownloadBtn() {
		Log.log().info("Click UploadDownloadButton.");
		uploadDownloadBtn.click();
	}

	public void clickDownloadBtn() {
		Log.log().info("Click DownloadButton.");
		downloadBtn.click();
	}

	public void sendFilePathToUploadInput(String filePath) {
		Log.log().info("Send filePath to UploadInput.");
		Browser.getBrowserInstance().findElement(uploadFileInput.getLocator()).sendKeys(filePath);
	}

	public boolean isUploadDownloadFormOpen() {
		return uploadDownloadForm.isOpen();
	}

	public boolean isFileNameDisplayedInUploadLabel(String fileName) {
		Log.log().info("FileName is displayed in the UploadInputLabel.");
		String name = Browser.getBrowserInstance().findElement(uploadedFileLabel.getLocator()).getTagName();
		return uploadedFileLabel.getText().contains(fileName);
	}
}