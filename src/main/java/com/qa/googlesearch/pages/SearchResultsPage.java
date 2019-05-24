package com.qa.googlesearch.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.googlesearch.base.TestBase;

public class SearchResultsPage extends TestBase {
	@FindBy(xpath="//div[@class='TbwUpd']")
	List<WebElement>links_found;

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String searchResultsPageTitle() {
		return driver.getTitle();
	}
	
	public void fetchresults() {
		for(WebElement link:links_found) {
			System.out.println(link.getText());
		}
	}
	
}
