package data;

import com.google.gson.JsonObject;

import java.util.HashMap;

public class TestData {
	static private HashMap<String, String> map;
	static private String alertsWindowsPageAlertBtnName;
	static private String toSeeAlertBtnName;
	static private String toSeeAlertBtnAlertMessage;
	static private String alertConfirmBoxBtnName;
	static private String alertConfirmBoxMessage;

	public TestData (JsonObject testData) {
		map = new HashMap<>();
		alertsWindowsPageAlertBtnName = testData.get("alertsWindowsPageAlertBtnName").getAsString();
		toSeeAlertBtnName = testData.get("toSeeAlertBtnName").getAsString();
		toSeeAlertBtnAlertMessage = testData.get("toSeeAlertBtnAlertMessage").getAsString();
		alertConfirmBoxBtnName = testData.get("alertConfirmBoxBtnName").getAsString();
		alertConfirmBoxMessage = testData.get("alertConfirmBoxMessage").getAsString();
	}

	public static String getAlertsWindowsPageAlertBtnName() {
		return alertsWindowsPageAlertBtnName;
	}
	public static String getToSeeAlertBtnName() {
		return toSeeAlertBtnName;
	}
	public static String getToSeeAlertMessage() {
		return toSeeAlertBtnAlertMessage;
	}
	public static String getAlertConfirmBoxBtnName() {
		return alertConfirmBoxBtnName;
	}
	public static String getAlertConfirmBoxMessage() {
		return alertConfirmBoxMessage;
	}
}