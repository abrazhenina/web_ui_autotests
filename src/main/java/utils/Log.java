package utils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	static Logger log;
	private Log() {
	}
	public static Logger log() {
		if (log == null) {
			BasicConfigurator.configure();
			log = Logger.getLogger(Log.class);
			PropertyConfigurator.configure("src/main/resources/log4j2.properties");
		}
		return log;
	}
}