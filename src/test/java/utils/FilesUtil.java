package utils;

import java.io.File;

public class FilesUtil {

	public static boolean isFileDownloaded() {
		Log.log().info("The file downloaded.");
		File f = new File(Constants.getDownloadsFolderPath());
		if(f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}
}
