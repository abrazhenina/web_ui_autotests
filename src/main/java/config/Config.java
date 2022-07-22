package config;

import com.google.gson.JsonObject;

public class Config {
	public static String homePageAddress;
	public static String browserName;
	public static boolean browserIncognito;
	public static boolean browserLang;
	public static boolean browserWindowMaximized;
	public static int timeout;
	public static int timeout1;
	public static int timeout2;

	public Config (JsonObject config) {
		homePageAddress = config.get("homePageAddress").getAsString();
		browserName = config.get("browserName").getAsString();
		browserIncognito = config.get("browserIncognito").getAsBoolean();
		browserLang = config.get("browserLang").getAsBoolean();
		browserWindowMaximized = config.get("browserWindowMaximized").getAsBoolean();
		timeout = config.get("timeout").getAsInt();
		timeout1 = config.get("timeout1").getAsInt();
		timeout2 = config.get("timeout2").getAsInt();
	}
}