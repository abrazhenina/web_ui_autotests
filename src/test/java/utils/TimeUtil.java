package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class TimeUtil {
	public static String getCurrentMonthDayYear() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.currentDateFormat);
		return formatter.format(date);
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.currentDateTimeFormat);
		String date = formatter.format(new Date());
		LocalDate currentDate = LocalDate.parse(date);
		Month month = currentDate.getMonth();
		String monthStr = month.toString();
		String monthCapitalized = monthStr.substring(0, 1).toUpperCase() + monthStr.substring(1).toLowerCase();
		SimpleDateFormat formatterWithoutMonth = new SimpleDateFormat(Constants.dateTimeWithoutMonth);
		String dateTimeWithoutMonth = formatterWithoutMonth.format(new Date());
		return monthCapitalized +" "+ dateTimeWithoutMonth;
	}

	public static int getClosestDateWith29Feb() {
		int yearBack = LocalDate.now().getYear();
		int yearForward = yearBack;
		String leapYearBack = yearBack + "-01-01";
		while(!LocalDate.parse(leapYearBack).isLeapYear()) {
			yearBack--;
			leapYearBack = yearBack + "-01-01";
		}
		leapYearBack = yearBack + "-02-29";

		String leapYearForward = yearForward + "-01-01";
		while(!LocalDate.parse(leapYearForward).isLeapYear()) {
			yearForward++;
			leapYearForward = yearForward + "-01-01";
		}
		leapYearForward = yearForward + "-02-29";

		int yearBackDiff = LocalDate.now().until(LocalDate.parse(leapYearBack))
				.getYears();
		int yearForwardDiff = LocalDate.now().until(LocalDate.parse(leapYearForward))
				.getYears();

		if (Math.abs(yearBackDiff) == yearForwardDiff) {
			int monthBackDiff = LocalDate.now().until(LocalDate.parse(leapYearBack))
					.getMonths();
			int monthForwardDiff = LocalDate.now().until(LocalDate.parse(leapYearForward))
					.getMonths();
			if(Math.abs(monthBackDiff) == monthForwardDiff) {
				int dayBackDiff = LocalDate.now().until(LocalDate.parse(leapYearBack))
						.getDays();
				int dayForwardDiff = LocalDate.now().until(LocalDate.parse(leapYearForward))
						.getDays();
				if (Math.abs(dayBackDiff) < dayForwardDiff) {
					return LocalDate.parse(leapYearBack).getYear();
				} else
					return LocalDate.parse(leapYearForward).getYear();
			}
			else if(Math.abs(monthBackDiff) < monthForwardDiff)
				return LocalDate.parse(leapYearBack).getYear();
			else
				return LocalDate.parse(leapYearForward).getYear();
		} else if(Math.abs(yearBackDiff) < yearForwardDiff)
			return LocalDate.parse(leapYearBack).getYear();
		else
			return LocalDate.parse(leapYearForward).getYear();
	}
}