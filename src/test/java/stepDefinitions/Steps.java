package stepDefinitions;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

//the exceptions that where automatically generated
//had to commented out otherwise the code wouldn't run
 

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException
	{
		
		//this method cannot be extended from base class it has to be in here to work
		
		//Reading properties
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		
		
		//In order for this to work i had to enter thelog4j jar manually
				//i have it on the desktop if i ever need it again 
				logger =Logger.getLogger("nopCommerce");//Added logger
				PropertyConfigurator.configure("log4j.properties");//Added logger
				
				
				//Browser configuration based on properties file
				String br = configProp.getProperty("browser");
				
				
				if(br.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
					driver = new ChromeDriver();
				}
				
				else if(br.equals("edge"))
				{
					System.setProperty("webdriver.msgedge.driver", configProp.getProperty("msgedgepath"));
					driver = new EdgeDriver();
				}
				else if(br.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
					driver = new EdgeDriver();
				}
				
				
				
				
				
				
				logger.info("**********Launching browser***********");
		
		
	}
	
	
	
	
	@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {
		
		
		
		lp=new LoginPage(driver);
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		logger.info("**********Getting url***********");

	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
		logger.info("**********Entering credentials***********");

	}

	@When("click on Login")
	public void click_on_login() {
		lp.clickLogin();
		logger.info("**********Click Loggin***********");

	}

	@Then("Page Title should be  {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
			logger.info("**********Login passed***********");

			Assert.assertTrue(false);
		}else
		{
			logger.info("**********Login failed***********");

			Assert.assertEquals(title,driver.getTitle());
		}
		//throw new io.cucumber.java.PendingException();
	}

	@When("user click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("**********Click on Log Out link***********");
		lp.clickLogout();
		Thread.sleep(3000);
		//throw new io.cucumber.java.PendingException();
	}

	

	@Then("close browser")
	public void close_browser() {
		logger.info("**********Close browser***********");
		driver.close();
		//throw new io.cucumber.java.PendingException();
	}

	
	//Customers feature step definitions......................
	
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		logger.info("**********View Dashboard confirmation***********");
		addCust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		logger.info("**********Click on customer menu***********");
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	   
	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
	  logger.info("**********Click on menu item***********");
	  Thread.sleep(3000);
	  addCust.clickOnCustomerMenuItem();
	  
	}
	@When("click on customers")
	public void click_on_customers() throws InterruptedException {
	logger.info("**********Click on customers***********");
	Thread.sleep(2000);
    addCust.clickOnCustomers();
	}
	
	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		logger.info("**********Click on add a new customer button***********");
		addCust.clickOnAddnew();
	    Thread.sleep(3000);
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		logger.info("**********Confirm add a new customer page***********");
	   Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() {
		logger.info("**********Entering customer info***********");
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
		
		logger.info("**********Click on save button***********");
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
   
		logger.info("**********Searching customer by email id***********");
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
		Assert.assertEquals(true,status);
		//This should be true false but for some reason it fails to assert properly so i will leave it like this for now
		//fixed in the loop limit it should have been i+1 instead of i
	
	}

	
	//Steps for searching the customer by using the first and last name.........
	
	@When("enter customers First Name")
	public void enter_customers_first_name() {
		logger.info("**********Searching customer by name***********");

		searchCust = new SearchCustomerPage(driver);
		//have to initialize at the start of each scenario
	   
		searchCust.setFirstName("Victoria");
		
	}
	@When("Enter customers Last Name")
	public void enter_customers_last_name() {
	searchCust.setLastName("Terces");
	}
	@Then("User should find Name in the Search table")
	public void user_should_find_name_in_the_search_table() {
	  boolean status =searchCust.searchCustomerByName("Victoria Terces");
	  Assert.assertEquals(true,status);
	}


	
	
	
	
}
