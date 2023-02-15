package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddcustomerPage {

	
	public WebDriver ldriver;
	
	
	public AddcustomerPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	
	By lnkCustomers_menu =By.xpath("//*[@id=\"nopSideBarPusher\"]");  //  initial xpath =  //a[contains(@href, '#')])[7]"
	By lnkCustomers_menuitem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");  //          //li[4]/ul/li/a/p
	By lnkCustomers = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
	
	By btnAddnew = By.xpath("//div/a/i");//Add new
	
	By txtEmail=By.xpath("//*[@id=\"Email\"]");
	By txtPassword=By.xpath("//*[@id=\"Password\"]");
	By txtFirstName=By.xpath("//*[@id=\"FirstName\"]");
	By txtLastName=By.xpath("//*[@id=\"LastName\"]");

	By txtDob = By.xpath("//*[@id=\"DateOfBirth\"]");
	By txtcoName = By.xpath("//*[@id=\"Company\"]");
	
	By txtnewsletter = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	
	By btnsave = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");

	//Action methods
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu()
	{
		ldriver.findElement(lnkCustomers_menu).click();;
		
	}
	
	public void clickOnCustomerMenuItem()
	{
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnCustomers()
	{
		ldriver.findElement(lnkCustomers).click();
	}
	public void clickOnAddnew()
	{
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setCompanyName(String coname)
	{
		ldriver.findElement(txtcoName).sendKeys(coname);
	}
	
	public void setNewletter(String nletter)
	{
		ldriver.findElement(txtnewsletter).sendKeys(nletter);
	}
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnsave).click();
	}
	
	
}
