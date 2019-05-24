package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.googlesearch.base.TestBase;
import com.qa.googlesearch.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
	}
	@Test(priority=1)
	public void verify_homepageTitle() {
		String title=homepage.homepagetitle();
		Assert.assertEquals(title, prop.getProperty("homepage_title"));
	}
	@Test(priority=2)
	public void search()
	{
		homepage.search(prop.getProperty("search_for"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
