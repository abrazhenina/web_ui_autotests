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
	static private String alertConfirmResultLabelName;
	static private String alertConfirmResultLabelText;
	static private String alertPromptBoxBtnName;
	static private String alertPromptBoxMessage;

	public TestData (JsonObject testData) {
		map = new HashMap<>();
		alertsWindowsPageAlertBtnName = testData.get("alertsWindowsPageAlertBtnName").getAsString();
		toSeeAlertBtnName = testData.get("toSeeAlertBtnName").getAsString();
		toSeeAlertBtnAlertMessage = testData.get("toSeeAlertBtnAlertMessage").getAsString();
		alertConfirmBoxBtnName = testData.get("alertConfirmBoxBtnName").getAsString();
		alertConfirmBoxMessage = testData.get("alertConfirmBoxMessage").getAsString();
		alertConfirmResultLabelName = testData.get("alertConfirmResultLabelName").getAsString();
		alertConfirmResultLabelText = testData.get("alertConfirmResultLabelText").getAsString();
		alertPromptBoxBtnName = testData.get("alertPromptBoxBtnName").getAsString();
		alertPromptBoxMessage = testData.get("alertPromptBoxMessage").getAsString();
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
	public static String getAlertConfirmResultLabelName() {
		return alertConfirmResultLabelName;
	}
	public static String getAlertConfirmResultLabelText() {
		return alertConfirmResultLabelText;
	}

	public static String getAlertPromptBoxBtnName() {
		return alertPromptBoxBtnName;
	}

	public static String getAlertPromptBoxMessage() {
		return alertPromptBoxMessage;
	}
}