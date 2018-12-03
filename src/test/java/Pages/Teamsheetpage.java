package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Teamsheetpage {
	
	@FindBy(xpath = "//*[@id=\"SquadList\"]/span")
	private WebElement squadTitle;
	
	public String getCheckoutTitle() {
		return squadTitle.getText();
	}
}
