package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Form;
import base.elements.TextBox;
import org.openqa.selenium.By;
import utils.Constants;
import utils.Log;

import java.io.File;

public class ElementsPage extends BaseForm {
	private Button webTablesBtn = new Button("webTablesBtn", By.xpath("//span[text()='Web Tables']"));
	public Button uploadDownloadBtn = new Button("uploadDownloadBtn", By.xpath("//span[text()='Upload and Download']"));
	public Form uploadDownloadForm = new Form("uploadDownloadForm", By.xpath("//div[@class='main-header' and contains(text(),'Upload')]"));
	public Button downloadBtn = new Button("", By.id("downloadButton"));
	private Button uploadBtn = new Button("uploadBtn", By.id("uploadFile"));
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

	public void clickUploadBtn() {
		Log.log().info("Click UploadButton.");
		uploadBtn.clickJS();
	}

	public boolean isUploadDownloadFormOpen() {
		return uploadDownloadForm.isOpen();
	}
}