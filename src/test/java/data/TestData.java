package data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import utils.JsonReader;

import java.util.HashMap;

public class TestData {
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
	static private int userNum;

	static private String userFirstName;
	static private String userLastName;
	static private String userEmail;
	static private int userAge;
	static private int userSalary;
	static private String userDepartment;
	static private int pickDateDay;
	static private int pickDateMonth;

	public TestData (JsonObject testData) {
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
		userNum = testData.get("userNum").getAsInt();
		usersTableJSONObj = testData.get("usersTable").getAsJsonArray();
		userFirstName = JsonReader.getStringFromJSONArray(usersTableJSONObj, userNum, "firstName");
		userLastName = JsonReader.getStringFromJSONArray(usersTableJSONObj, userNum, "lastName");
		userEmail = JsonReader.getStringFromJSONArray(usersTableJSONObj, userNum, "email");
		userAge = JsonReader.getIntFromJSONArray(usersTableJSONObj, userNum, "age");
		userSalary = JsonReader.getIntFromJSONArray(usersTableJSONObj, userNum, "salary");
		userDepartment = JsonReader.getStringFromJSONArray(usersTableJSONObj, userNum, "department");
		pickDateDay = testData.get("pickDateDay").getAsInt();
		pickDateMonth = testData.get("pickDateMonth").getAsInt();
	}

	public static int getPickDateDay() {
		return pickDateDay;
	}
	public static int getPickDateMonth() {
		return pickDateMonth;
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
	public static int getUserNum() {
		return userNum;
	}
	public static String getUserFirstName() {
		return userFirstName;
	}
	public static String getUserLastName() {
		return userLastName;
	}
	public static String getUserEmail() {
		return userEmail;
	}
	public static int getUserAge() {
		return userAge;
	}
	public static int getUserSalary() {
		return userSalary;
	}
	public static String getUserDepartment() {
		return userDepartment;
	}
}