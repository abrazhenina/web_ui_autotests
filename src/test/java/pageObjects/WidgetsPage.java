package pageObjects;

import base.BaseForm;
import base.elements.*;
import org.openqa.selenium.By;
import utils.StringUtil;
import utils.TimeUtil;

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
	private Form calendarWindow;
	private Dropdown monthSelect;
	private Dropdown yearSelect;
	private Form calendar7Days;
	private Label day29;
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
		calendarWindow = new Form("calendarWindow", By.className("react-datepicker__month-container"));
		monthSelect = new Dropdown("monthSelect", By.className("react-datepicker__month-select"));
		calendar7Days = new Form("calendar7Days", By.className("react-datepicker__week"));
		yearSelect = new Dropdown("yearSelect", By.className("react-datepicker__year-select"));
		day29 = new Label("day29", By.className("react-datepicker__day--029"));
	}

	public void openDateCalendar() {
		datePickerDateInput.click();
	}

	public boolean isDateCalendarOpen() {
		return calendarWindow.isOpen();
	}

	public void pickClosest29Fev() {
		int closestLeapYear = TimeUtil.getClosestDateWith29Feb();
		yearSelect.clickElementByIntValue(Integer.toString(closestLeapYear));
		monthSelect.clickElementByIntValue("2");
		day29.click();
	}

	public boolean isDatePickerDate29Fev() {
		return datePickerDateInput.getTextFromInput().contains("02/29");
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
		return datePickerDateInput.getTextFromInput().equals(TimeUtil.getCurrentMonthDayYear());
	}

	public boolean isDatePickerDateTimeActual() {
		return dateTimePickerInput.getTextFromInput().equals(TimeUtil.getCurrentDateTime());
	}
}