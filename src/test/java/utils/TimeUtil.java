package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class TimeUtil {
	public static String getCurrentMonthDayYear() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(date);
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(new Date());
		LocalDate currentDate = LocalDate.parse(date);
		Month month = currentDate.getMonth();
		String monthStr = month.toString();
		String monthCapitalized = monthStr.substring(0, 1).toUpperCase() + monthStr.substring(1).toLowerCase();
		SimpleDateFormat formatterWithoutMonth = new SimpleDateFormat("dd, yyyy h:mm a");
		String dateTimeWithoutMonth = formatterWithoutMonth.format(new Date());
		String dateTimeFull = monthCapitalized +" "+ dateTimeWithoutMonth;
		return dateTimeFull;
	}
}