package data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

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
	static private String alertPromptResultLabelName;
	static private String nestedFramesBtnName;
	static private String nestedFramesParentFrameName;
	static private String nestedFramesChildFrameName;
	static private String nestedFramesParentFrameText;
	static private String nestedFramesChildFrameText;
	static private JsonArray usersTableJSONObj;
	//static private

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
		alertPromptResultLabelName = testData.get("alertPromptResultLabelName").getAsString();
		nestedFramesBtnName = testData.get("nestedFramesBtnName").getAsString();
		nestedFramesParentFrameName = testData.get("nestedFramesParentFrameName").getAsString();
		nestedFramesChildFrameName = testData.get("nestedFramesChildFrameName").getAsString();
		nestedFramesParentFrameText = testData.get("nestedFramesParentFrameText").getAsString();
		nestedFramesChildFrameText = testData.get("nestedFramesChildFrameText").getAsString();
		usersTableJSONObj = testData.get("usersTable").getAsJsonArray();
		System.out.println(usersTableJSONObj);
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
	public static String getAlertPromptResultLabelName() {
		return alertPromptResultLabelName;
	}

	public static String getNestedFramesBtnName() {
		return nestedFramesBtnName;
	}

	public static String getNestedFramesParentFrameName() {
		return nestedFramesParentFrameName;
	}

	public static String getNestedFramesChildFrameName() {
		return nestedFramesChildFrameName;
	}

	public static String getNestedFramesParentFrameText() {
		return nestedFramesParentFrameText;
	}

	public static String getNestedFramesChildFrameText() {
		return nestedFramesChildFrameText;
	}
}