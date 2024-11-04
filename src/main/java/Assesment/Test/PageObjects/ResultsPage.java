package Assesment.Test.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
	
WebDriver driver;
	
	public ResultsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".search__results")
	public WebElement resultsPage;
	
	@FindBy(css=".results.container")
	public WebElement resultsList;
	
	@FindBy(xpath="(//*[@class='search-result'])[1]//*[@class='title']")
	public WebElement firstResultTitle;
	
	
	
	
}
