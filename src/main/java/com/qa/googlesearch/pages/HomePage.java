package com.qa.googlesearch.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.googlesearch.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(name="btnK")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_isSearchBtnPresent() {
		return searchBtn.isDisplayed();
	}
	
	public String homepagetitle() {
		return driver.getTitle();
	}
	
	public SearchResultsPage search(String query)
	{
		searchBox.sendKeys(query+Keys.ENTER);
		return new SearchResultsPage();
	}

}
