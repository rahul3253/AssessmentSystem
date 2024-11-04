package Assesment.Test.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='#subnav-search-desktop-top']")
	public WebElement searchIcon;
	
	@FindBy(xpath="(//*[contains(@placeholder, 'Type to Search')])[2]")
	public WebElement searchField;
	
	@FindBy(xpath="(//*[contains(@class, 'btn-search')])[2]")
	public WebElement searchBtn;
	
	
	@FindBy(id ="onetrust-accept-btn-handler")
	public WebElement acceptCookies;
	
	
	@FindBy(id ="onetrust-reject-all-handler")
	public WebElement rejectCookies;
	
	
	public void acceptCookies()
	{
		acceptCookies.click();
	}
	
	
	public void rejectCookies()
	{
		rejectCookies.click();
	}
	
	public void searchText(String text)
	{
		try {
		searchIcon.click();
		//Thread.sleep(2000);
		searchField.click();
		searchField.sendKeys(text);
		//Thread.sleep(2000);
		searchBtn.click();
		//Thread.sleep(2000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	
	
}
