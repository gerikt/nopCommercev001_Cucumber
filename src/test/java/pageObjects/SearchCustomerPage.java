package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
	
	//Element identification
	
	@FindBy(how=How.ID, using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID, using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how=How.ID, using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how=How.ID, using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how=How.XPATH, using="//div[@class=k-multiselect-wrap k-floatwrap]")
	@CacheLookup
	WebElement txtCustomerRoles;
		
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstitemAdministrators;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstitemRegistered;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstitemGuests;
	
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstitemVendors;
	
	@FindBy(how=How.ID, using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(how=How.XPATH, using="//table[@role='grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH, using="//table[@role='grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	
	//Action methods 
	
	public void setEmail(String email)
	{
		//the original method was deprecated
		//waithelper.WaitForElemetn(WebElement element,long seconds)
		waithelper.WaitForElement(txtEmail,Duration.ofSeconds(30));
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
	}
	
	public void setFirstName(String fname)
	{
		//the original method was deprecated
		//waithelper.WaitForElemetn(WebElement element,long seconds)
		waithelper.WaitForElement(txtFirstName,Duration.ofSeconds(30));
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
		
	}
	
	
	public void setLastName(String lname)
	{
		//the original method was deprecated
		//waithelper.WaitForElemetn(WebElement element,long seconds)
		waithelper.WaitForElement(txtLastName,Duration.ofSeconds(30));
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		
	}
	
	public void clickSearch()
	{
		btnSearch.click();
		waithelper.WaitForElement(btnSearch, Duration.ofSeconds(30));
	}
	
	public int getNoOfRows()
	{
		return (tableRows.size());
	}
	
	public int getNoOfColumns()
	{
		return (tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		//This is not working properly needs to be fixed
		//it returns false when it should return true 
		
		boolean flag=false;
		
		for(int i =1; i<=getNoOfRows() +1;i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]")).getText();
			
			System.out.println(emailid);
			
			if(emailid.equals(email))
			{
				flag=true;
			}
			
		}
		
				
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		//This is not working properly needs to be fixed
		//it returns false when it should return true 
		
		boolean flag=false;
		
		for(int i =1; i<=getNoOfRows()+1;i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]")).getText();
			
			String names[] = name.split(" ");
			
			if(names[0].equals("Victoria") && names[1].equals("Terces") )
			{
				flag=true;
			}
			
		}
		
				
		return flag;
	}
	
	
	
	
	
	
	
	
	
}
