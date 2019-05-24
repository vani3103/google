package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.googlesearch.base.TestBase;
import com.qa.googlesearch.pages.HomePage;
import com.qa.googlesearch.pages.SearchResultsPage;

public class SearchResultsPageTest extends TestBase{
	HomePage homepage;
	SearchResultsPage searchresultspage;
	public SearchResultsPageTest() {
		super();
	}
@BeforeMethod
public void setup() {
initialization();
homepage=new HomePage();
searchresultspage=homepage.search(prop.getProperty("search_for"));
}
@Test(priority=1)
public void verify_pageTitle() {
	
	String title=searchresultspage.searchResultsPageTitle();
	Assert.assertEquals(title, prop.getProperty("searchResultaPage_title"));
	
}

@Test(priority=2)
public void search_results() {
	searchresultspage.fetchresults();
}

@AfterMethod
public void teardown() {
	driver.quit();
}
}
