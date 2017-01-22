package com.akamai.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver_win32_2_27\\chromedriver.exe");
		this.driver = new ChromeDriver();	
		
		ACarrersMainPage = PageFactory.initElements(driver, AkamaiCarrersMainPage.class);
		ACarrersSearchPage = PageFactory.initElements(driver, AkamaiCarrersSerachResultPage.class);
		ACarrersSearchSubPage = PageFactory.initElements(driver, AkamaiCarrersSearchResultSubPage.class);
		ACarrersMainPage.loadPage();
		ACarrersMainPage.checkPageTitel();
		ACarrersMainPage.enterSearchString("Test");
		ACarrersMainPage.selectLocation("Krakow");
		ACarrersMainPage.clickSearchButton();
		
	}

	@AfterMethod(alwaysRun = true)
	public void terdown(){
		driver.quit();		
	}
	
	
	@Test
	public void checkNumberOfResults (){	
	ACarrersSearchPage.checkNumberOfResults("11");
	}
	
	@Test
	public void checkNumberOfJobsPosted(){
	ACarrersSearchPage.numberOfResultsForString(4, "Software Development Engineer in Test");
	}
	
	@Test
	public void checkDatePostedForOffer(){
	ACarrersSearchPage.clickOnOffer("Senior Software Development Engineer in Test  - LUNA");
	ACarrersSearchSubPage.checkPosstDate("Dec 06, 2016");	
	}

}
