package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	@FindBy(id = "teamnameInput")
	private WebElement nameInput;
	@FindBy(id = "addMoneyBtn")
	private WebElement changeNameButton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/button[2]")
	private WebElement playPageButton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/button[3]")
	private WebElement teamsheetPageButton;
	
	
	public void clickGame() {
		playPageButton.click();
	}
	public void clickTeamsheet() {
		teamsheetPageButton.click();
	}
	
	public void changeTeamName() {
		nameInput.sendKeys("test");
		changeNameButton.click();
	}
}
