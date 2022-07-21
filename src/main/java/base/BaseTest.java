package base;

import config.Config;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
	protected WebDriver driver;
	protected Config config;

	public BaseTest(WebDriver driver, Config config) {
		this.driver = driver;
		this.config = config;
	}

	void beforeTestRun() {

	}

	void beforeTestMethod() {

	}

	void afterTestRun() {

	}

	void afterTestMethod() {

	}

	// вызывает из Utils и сохраняет в лог
	void logInfo() {

	}
}
