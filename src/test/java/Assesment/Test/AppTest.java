package Assesment.Test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Assesment.Test.PageObjects.FindCenter;
import Assesment.Test.PageObjects.HomePage;
import Assesment.Test.PageObjects.ResultsPage;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {

	@Test
	public void verifySearchFunctionality() {

		HomePage homePage = new HomePage(driver);
		homePage.acceptCookies();
		homePage.searchText("Employee Education in 2018: Strategies to Watch");

		ResultsPage resultsPage = new ResultsPage(driver);
		resultsPage.resultsPage.isDisplayed();
		String firstResultText = resultsPage.firstResultTitle.getText();
		assertEquals(firstResultText, "Employee Education in 2018: Strategies to Watch");

	}

	@Test
	public void verifyComments() {
		HomePage homePage = new HomePage(driver);
		homePage.acceptCookies();
		FindCenter findCenter = new FindCenter(driver);
		findCenter.navigateToCenterPage();
		Utility utility = new Utility();
		String url = utility.getURL(driver);
		boolean urlContains = url.contains("child-care-locator");
		assertTrue(urlContains);
		findCenter.searchCenter("New York");
		assertEquals(findCenter.getResultCount(), findCenter.getResultListCount());

	}

}
