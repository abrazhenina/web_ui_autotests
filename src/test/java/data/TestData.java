package data;

import com.google.gson.JsonObject;

public class TestData {
	static private String toSeeAlertBtnName;
	static private String toSeeAlertBtnAlertMessage;
	static private String confirmBoxAlertMessage;

	public TestData (JsonObject testData) {
		toSeeAlertBtnName = testData.get("toSeeAlertBtnName").getAsString();
		toSeeAlertBtnAlertMessage = testData.get("toSeeAlertBtnAlertMessage").getAsString();
		confirmBoxAlertMessage = testData.get("confirmBoxAlertMessage").getAsString();
	}

	public static String getToSeeAlertBtnName() {
		return toSeeAlertBtnName;
	}
	public static String getAlertMessage() {
		return toSeeAlertBtnAlertMessage;
	}

	public static String getConfirmBoxAlertMessage() {
		return confirmBoxAlertMessage;
	}
}