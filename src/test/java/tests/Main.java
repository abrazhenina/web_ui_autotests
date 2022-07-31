package tests;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class Main {

	public static void main(String args[]) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(new Date());
		LocalDate currentDate = LocalDate.parse(date);
		Month month = currentDate.getMonth();
		String monthStr = month.toString();
		String monthCapitalized = monthStr.substring(0, 1).toUpperCase() + monthStr.substring(1).toLowerCase();
		SimpleDateFormat formatterWithoutMonth = new SimpleDateFormat("dd, yyyy h:mm a");
		String dateTimeWithoutMonth = formatterWithoutMonth.format(new Date());
		String dateTimeFull = monthCapitalized +" "+ dateTimeWithoutMonth;
		System.out.println(dateTimeFull);
	}
}
