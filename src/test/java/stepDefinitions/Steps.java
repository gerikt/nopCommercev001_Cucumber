package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

//the exceptions that where automatically generated
//had to commented out otherwise the code wouldn't run
 

public class Steps extends BaseClass {

	
	
	
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

	
	//Customers feature step definitions......................
	
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    
		addCust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	   
	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
	  Thread.sleep(3000);
	  addCust.clickOnCustomerMenuItem();
	  
	}
	@When("click on customers")
	public void click_on_customers() throws InterruptedException {
	Thread.sleep(2000);
    addCust.clickOnCustomers();
	}
	
	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
	    Thread.sleep(3000);
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	   Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() {
		
		String email= randomestring()+ "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setFirstName("John");
		addCust.setLastName("mollins");
		addCust.setCompanyName("Samsung");
		//addCust.setNewletter("Documento");
		addCust.setDob("01/01/2000");
	    
	}
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickOnSave();
		Thread.sleep(3000);
	   
	}
	@Then("User can view configuration message {string}")
	public void user_can_view_configuration_message(String msg) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().
	    		contains("The new customer has been added successfully."));
	}
	
	
	// Search customer by email..............................

	@When("Enter customers Email")
	public void enter_customers_email() {
   
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
   
		searchCust.clickSearch();
		Thread.sleep(3000);
	}
	@Then("User should find Email in the Search table")
	public void user_should_find_email_in_the_search_table() {
   ;
		boolean status =searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	
	
	
	
}
