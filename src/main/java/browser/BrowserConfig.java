package browser;

import com.google.gson.JsonObject;

public class BrowserConfig {
	private static String homePageAddress;
	private static String browserName;
	private static boolean browserIncognito;
	private static boolean browserLang;
	private static boolean browserWindowMaximized;
	private static int timeout;

	public BrowserConfig(JsonObject config) {
		homePageAddress = config.get("homePageAddress").getAsString();
		browserName = config.get("browserName").getAsString();
		browserIncognito = config.get("browserIncognito").getAsBoolean();
		browserLang = config.get("browserLang").getAsBoolean();
		browserWindowMaximized = config.get("browserWindowMaximized").getAsBoolean();
		timeout = config.get("timeout").getAsInt();
	}

	public static String getHomePageAddress() {
		return homePageAddress;
	}

	public static String getBrowserName() {
		return browserName;
	}

	public static boolean getBrowserIncognito() {
		return browserIncognito;
	}

	public static boolean getBrowserLang() {
		return browserLang;
	}

	public static boolean getBrowserWindowMaximized() {
		return browserWindowMaximized;
	}

	public static int getTimeout() {
		return timeout;
	}
}