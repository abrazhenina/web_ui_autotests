package pageObjects;

import base.BaseForm;
import base.elements.Button;
import base.elements.Form;
import base.elements.Label;
import base.elements.TextBox;
import org.openqa.selenium.By;
import utils.StringUtil;
import utils.TimeUtil;
import utils.Waits;

public class WidgetsPage extends BaseForm {
	private Form sliderForm;
	private Button sliderBtn;
	private TextBox sliderInput;
	private Label slider;
	private Label sliderPopUpLabel;
	private String randomNumStr;
	private Button datePickerBtn;
	private Form datePickerForm;
	private TextBox datePickerDateInput;
	private TextBox dateTimePickerInput;
	private String openDatePickerWindowClassValue = "react-datepicker-ignore-onclickoutside";
	private Label calendarWindow;
	public WidgetsPage() {
		super("widgetsPage", By.xpath("//div[text()='Widgets']"));
		sliderBtn = new Button("sliderBtn", By.xpath("//span[text()='Slider']"));
		sliderForm = new Form("sliderForm", By.xpath("//div[text()='Slider']"));
		sliderInput = new TextBox("sliderInput", By.id("sliderValue"));
		slider = new Label("slider", By.className("range-slider--primary"));
		sliderPopUpLabel = new Label("sliderPopUpLabel", By.className("range-slider__tooltip__label"));
		datePickerBtn = new Button("datePickerBtn",  By.xpath("//span[text()='Date Picker']"));
		datePickerForm = new Form("datePickerForm", By.xpath("//div[text()='Date Picker']"));
		datePickerDateInput = new TextBox("datePickerDateInput", By.id("datePickerMonthYearInput"));
		dateTimePickerInput = new TextBox("dateTimePickerInput", By.id("dateAndTimePickerInput"));
		calendarWindow = new Label("calendarWindow", By.className("react-datepicker__month-container"));
	}

	public String pickDate(int day, int month) {
		datePickerDateInput.click();

		return "";
	}

	public boolean isSliderFormOpen() {
		return sliderForm.isOpen();
	}

	public boolean isDatePickerFormOpen() {
		return datePickerForm.isOpen();
	}

	public void clickSliderBtn() {
		sliderBtn.click();
	}

	public void clickDatePickerBtn() {
		datePickerBtn.click();
	}

	public void sendRandomNumToSliderInput() {
		randomNumStr = StringUtil.getRandomNumString0to100();
		sliderInput.clearInput();
		sliderInput.sendKeys(randomNumStr);
	}

	public boolean isSliderLabelNumEqualToNumSentToSliderInput() {
		slider.moveToElement();
		System.out.println("'"+randomNumStr+"'");
		System.out.println("'"+sliderPopUpLabel.getText()+"'");
		if(sliderPopUpLabel.isDisplayed()) {
			return (randomNumStr.equals(sliderPopUpLabel.getText()));
		}
		return false;
	}

	public boolean isDatePickerDateActual() {
		String dataFromInput = datePickerDateInput.getTextFromInput();
		if(dataFromInput.equals(TimeUtil.getCurrentMonthDayYear())) {
			return true;
		}
		return false;
	}

	public boolean isDatePickerDateTimeActual() {
		String dataFromInput = dateTimePickerInput.getTextFromInput();
		if(dataFromInput.equals(TimeUtil.getCurrentDateTime())) {
			return true;
		}
		return false;
	}
}