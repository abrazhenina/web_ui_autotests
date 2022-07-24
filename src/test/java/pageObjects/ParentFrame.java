package pageObjects;

import base.BaseForm;
import org.openqa.selenium.By;

public class ParentFrame extends BaseForm {
	public ParentFrame() {
		super("frameParent", By.id("frame1"));
	}


}
