package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

//the exceptions that where automatically generated
//had to commented out otherwise the code wouldn't run
 

public class Steps {

	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {
		System.setProperty("webdriver.msgedge.driver", System.getProperty("user.dir") + "//Drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		lp=new LoginPage(driver);
		//throw new io.cucumber.java.PendingException();
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		//throw new io.cucumber.java.PendingException();
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
		//throw new io.cucumber.java.PendingException();
	}

	@When("click on Login")
	public void click_on_login() {
		lp.clickLogin();
		//new io.cucumber.java.PendingException();
	}

	@Then("Page Title should be  {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
			Assert.assertTrue(false);
		}else
		{
			Assert.assertEquals(title,driver.getTitle());
		}
		//throw new io.cucumber.java.PendingException();
	}

	@When("user click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
		//throw new io.cucumber.java.PendingException();
	}

	

	@Then("close browser")
	public void close_browser() {
		driver.close();
		//throw new io.cucumber.java.PendingException();
	}

	
}
