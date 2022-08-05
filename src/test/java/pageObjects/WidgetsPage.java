package pageObjects;

import base.BaseForm;
import base.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import utils.StringUtil;
import utils.TimeUtil;

public class WidgetsPage extends BaseForm {
	private Form sliderForm = new Form("sliderForm", By.xpath("//div[text()='Slider']"));
	private Button sliderBtn = new Button("sliderBtn", By.xpath("//span[text()='Slider']"));
	private TextBox sliderInput = new TextBox("sliderInput", By.id("sliderValue"));
	private Slider slider = new Slider("slider", By.className("range-slider--primary"));
	private Button datePickerBtn = new Button("datePickerBtn",  By.xpath("//span[text()='Date Picker']"));
	private Form datePickerForm = new Form("datePickerForm", By.xpath("//div[text()='Date Picker']"));
	private TextBox datePickerDateInput = new TextBox("datePickerDateInput", By.id("datePickerMonthYearInput"));
	private TextBox dateTimePickerInput = new TextBox("dateTimePickerInput", By.id("dateAndTimePickerInput"));
	private Form calendarWindow = new Form("calendarWindow", By.className("react-datepicker__month-container"));
	private Dropdown monthSelect = new Dropdown("monthSelect", By.className("react-datepicker__month-select"));
	private Dropdown yearSelect = new Dropdown("yearSelect", By.className("react-datepicker__year-select"));
	private Label day29 = new Label("day29", By.className("react-datepicker__day--029"));
	private Button progressBarBtn = new Button("progressBarBtn", By.xpath("//span[text()='Progress Bar']"));
	private Form progressBarForm = new Form("progressBar", By.xpath("//div[text()='Progress Bar']"));
	private Button startStopBtn = new Button("startStopBtn", By.id("startStopButton"));
	private Label progressBar = new Label("progressBar", By.xpath("//div[@id='progressBar']//div"));
	private Label pageHeader = new Label("pageHeader", By.className("main-header"));
	private String randomNumStr;
	private int sliderNum = 0;

	public WidgetsPage() {
		super("widgetsPage", By.xpath("//div[text()='Widgets']"));
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
	public boolean isProgressBarFormOpen() {
		return progressBarForm.isOpen();
	}

	public void clickDatePickerBtn() {
		datePickerBtn.click();
	}

	public void clickSliderBtn() {
		sliderBtn.click();
		if(!sliderBtn.isElementClassValueActive()) {
			sliderBtn.click();
		}
	}

	public void clickProgressBarBtn() {
		clickBlankSpaceOnPage();
		this.scrollDown();
		try {
			progressBarBtn.click();
		} catch (ElementClickInterceptedException e) {
			this.scrollDown();
			progressBarBtn.click();
		}
	}

	public void clickStartBtn() {
		startStopBtn.click();
	}

	public void clickStopBtnAt28Percent() {
		int percent = getProgressBarTextInt();
		while(percent < 28) {
			percent = getProgressBarTextInt();
		}
		startStopBtn.click();
	}

	public void clickBlankSpaceOnPage() {
		pageHeader.click();
	}
	public int getProgressBarTextInt() {
		return progressBar.getAriaValueNowInt();
	}

	public boolean isProgressBarValueBetween28And30() {
		if(progressBar.getAriaValueNowInt() >= 28 && progressBar.getAriaValueNowInt() <=30)
			return true;
		return false;
	}

	public boolean isSliderNumEqualToGeneratedNum() {
		return randomNumStr.equals(sliderInput.getTextFromInput());
	}

	public boolean isDatePickerDateActual() {
		return datePickerDateInput.getTextFromInput().equals(TimeUtil.getCurrentMonthDayYear());
	}

	public boolean isDatePickerDateTimeActual() {
		return dateTimePickerInput.getTextFromInput().equals(TimeUtil.getCurrentDateTime());
	}

	public void moveSliderToZero() {
		slider.click();
		sliderNum = Integer.parseInt(sliderInput.getTextFromInput());
		for(int i=0; i<=sliderNum; i++) {
			slider.moveSliderToLeft();
		}
	}

	public void setRandomNumToSlider() {
		randomNumStr = StringUtil.getRandomNumString0to100();
		int randomNum = Integer.parseInt(randomNumStr);
		for(int i=0; i<randomNum; i++) {
			slider.moveSliderToRight();
		}
	}
}