package settings;

import com.google.gson.JsonObject;

public class Settings {
	public String homePageAddress;
	public String browserName;
	public boolean browserIncognito;
	public boolean browserLang;
	public boolean browserWindowMaximized;
	public int timeout;
	public int timeout1;
	public int timeout2;

	public Settings (JsonObject config) {
		homePageAddress = config.get("homePageAddress").getAsString();
		browserName = config.get("browserName").getAsString();
		browserIncognito = config.get("browserIncognito").getAsBoolean();
		browserLang = config.get("browserLang").getAsBoolean();
		browserWindowMaximized = config.get("browserWindowMaximized").getAsBoolean();
		timeout = config.get("timeout").getAsInt();
		timeout2 = config.get("timeout2").getAsInt();
	}
}