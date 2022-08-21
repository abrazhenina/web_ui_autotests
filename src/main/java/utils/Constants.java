package utils;

public class Constants {
	private static String configPath = "src/test/resources/config.json";
	private static String testDataPath = "src/test/resources/testData.json";

	private static String downloadsFolderPath = "C:\\TestDownloads";
	public static String filePath = "C:\\sampleFile.jpeg";
	public static String fileName = "sampleFile.jpeg";
	public static String currentDateFormat = "MM/dd/yyyy";
	public static String currentDateTimeFormat = "yyyy-MM-dd";
	public static String dateTimeWithoutMonth = "d, yyyy h:mm a";

	public static String getConfigPath() {
		return configPath;
	}

	public static String getTestDataPath() {
		return testDataPath;
	}

	public static String getDownloadsFolderPath() {
		return downloadsFolderPath;
	}
}
