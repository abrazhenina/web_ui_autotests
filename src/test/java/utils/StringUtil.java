package utils;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class StringUtil {
	public static String getRandomString() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

	public static String getRandomNumString0to100() {
		Random random = new Random();
		return Integer.toString(
				random.ints(0, 100)
				.findFirst().getAsInt());
	}

	public static boolean strContainsSub(String mainStr, String subStr) {
		return mainStr.contains(subStr);
	}
}