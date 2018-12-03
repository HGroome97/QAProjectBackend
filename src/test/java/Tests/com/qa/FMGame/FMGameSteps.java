package Tests.com.qa.FMGame;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.Teamsheetpage;
import Pages.Homepage;
import Pages.Gamepage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FMGameSteps {
	
	FMGameTest fmgt = new FMGameTest();
	ExtentTest test;
	WebDriver driver;
	Homepage homepage;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harrison\\Documents\\External\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
		fmgt.report.endTest(test);
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get("http://35.246.113.55:3000");	
		homepage = PageFactory.initElements(driver, Homepage.class);
	}

	@When("^I enter a new team name$")
	public void i_enter_a_new_team_name() {
		homepage.changeTeamName();
		homepage.clickGame();
	}

	@Then("^I can witness the team name appear in the relevant place\\.$")
	public void i_can_witness_the_team_name_appear_in_the_relevant_place() {
		test = fmgt.report.startTest("Verify Changing Teamname");
		Gamepage page = PageFactory.initElements(driver, Gamepage.class);
		
		if (page.getMenuTitle().equals("test")) {
			test.log(LogStatus.PASS, "Teamname correctly changes");
		} else {
			test.log(LogStatus.FAIL, "Failure changing teamname");
		}
		
		Assert.assertEquals("Teamname changes" , "test",  page.getMenuTitle());

	}

	@When("^I click the teamsheets tab$")
	public void i_click_the_teamsheets_tab() {
		homepage.clickTeamsheet();
	}

	@Then("^I am taken to the teamsheets page$")
	public void i_am_taken_to_the_teamsheets_page() {
		test = fmgt.report.startTest("Verify Teamsheet Link");
		Teamsheetpage page = PageFactory.initElements(driver, Teamsheetpage.class);
		
		if (page.getCheckoutTitle().equals("Squad List")) {
			test.log(LogStatus.PASS, "Teamsheet Link correctly connects");
		} else {
			test.log(LogStatus.FAIL, "Failure linking to teamsheet page");
		}
		
		Assert.assertEquals("teamsheet available" , "Squad List",  page.getCheckoutTitle());

	}

}