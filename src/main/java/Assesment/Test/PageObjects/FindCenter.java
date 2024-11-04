package Assesment.Test.PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindCenter {
	WebDriver driver;

	public FindCenter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[@class='nav-item displayed-desktop']//a[contains(text(),'Find a Center')])[2]")
	public WebElement findACenter;

	@FindBy(id = "addressInput")
	public WebElement locationInput;

	@FindBy(css= ".resultsNumber")
	public WebElement resultsCount;
	
	@FindBy(css =".centerResult")
	public List<WebElement> resultList;


	public void navigateToCenterPage()
	{
		findACenter.click();
	}
	

	
	public void searchCenter(String text)
	{
		try {
		locationInput.click();
		locationInput.sendKeys(text);
		Thread.sleep(2000);
		locationInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public int getResultCount()
	{
		String a = resultsCount.getText();
		return Integer.parseInt(resultsCount.getText());
	}
	
	public int getResultListCount()
	{
		return resultList.size();
	}






}
