package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Gamepage {
	
	@FindBy(id="titleHeader")
	private WebElement pageTitle;
	
	public String getMenuTitle() {
		return pageTitle.getText();
	}
}
