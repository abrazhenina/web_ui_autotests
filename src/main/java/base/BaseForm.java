package base;

import base.elements.Label;
import org.openqa.selenium.By;

public abstract class BaseForm {
	String name;
	By loc;

	public BaseForm(String name, By loc) {

	}

	public boolean isPageOpen() {
		return false;
	}

	public String getName() {
		return null;
	}

	public By getLocator() {
		return null;
	}

	public Label getPageLabel() {
	return null;
	}

}
