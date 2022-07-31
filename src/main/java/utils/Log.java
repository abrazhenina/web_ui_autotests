package utils;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	static Logger log;
	private Log() {
	}
	public static Logger logger() {
		if (log == null) {
			log = Logger.getLogger("TestLogger");
			PropertyConfigurator.configure("src/main/resources/log4j2.properties");
		}
		return log;
	}
}