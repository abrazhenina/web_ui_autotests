package base.elements;

import base.BaseElement;
import org.openqa.selenium.By;

public class CheckBox extends BaseElement {
	public CheckBox(String name, By loc) {
		super(name, loc);
	}

	public boolean isChecked() {
		return false;
	}

	public void check() {

	}

	public void uncheck() {

	}
}
