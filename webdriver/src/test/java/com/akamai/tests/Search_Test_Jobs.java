package com.akamai.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.configuration;
import pages.AkamaiCarrersMainPage;
import pages.AkamaiCarrersSearchResultSubPage;
import pages.AkamaiCarrersSerachResultPage;

public class Search_Test_Jobs {
	
	public WebDriver driver;
	AkamaiCarrersMainPage ACarrersMainPage;
	AkamaiCarrersSerachResultPage ACarrersSearchPage;
	AkamaiCarrersSearchResultSubPage ACarrersSearchSubPage;

	
	@BeforeMethod(alwaysRun = true)
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", configuration.chromeWebDriverPath);
		this.driver = new ChromeDriver();	
		
		ACarrersMainPage = PageFactory.initElements(driver, AkamaiCarrersMainPage.class);
		ACarrersSearchPage = PageFactory.initElements(driver, AkamaiCarrersSerachResultPage.class);
		ACarrersSearchSubPage = PageFactory.initElements(driver, AkamaiCarrersSearchResultSubPage.class);
		//load page 'PAGE_URL' from AkamaiCarrersMainPage class
		ACarrersMainPage.loadPage();
		ACarrersMainPage.checkPageTitel();
		// send'test' to search box
		ACarrersMainPage.enterSearchString("test");
		// select 'Krakow' on the location field 
		ACarrersMainPage.selectLocation("Krakow");
		// click select button
		ACarrersMainPage.clickSearchButton();
		
	}

	@AfterMethod(alwaysRun = true)
	public void terdown(){
		driver.quit();		
	}
	
	
	@Test
	public void checkNumberOfResults (){	
		//Check if total number of result is: "11"
	ACarrersSearchPage.checkNumberOfResults("11");
	}
	
	@Test
	public void checkNumberOfJobsPosted(){
		//Check if there are 4 offers for: 'Software Development Engineer in Test'
	ACarrersSearchPage.numberOfResultsForString(4, "Software Development Engineer in Test");
	}
	
	@Test
	public void checkDatePostedForOffer(){
		//Check the date of publication for 'Senior Software Development Engineer in Test  - LUNA' offer 
	ACarrersSearchPage.clickOnOffer("Senior Software Development Engineer in Test  - LUNA");
	ACarrersSearchSubPage.checkPosstDate("Dec 06, 2016");	
	}

}
