package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseMethods;


public class AkamaiCarrersMainPage extends BaseMethods{	
	
	@FindBy(css=".ui-front>#keyword") WebElement field_search;
	@FindBy(css=".jAddFacetSearch>#jLocInputHldr") WebElement button_location;
	@FindBy(css=".search_btn>.btn_text") WebElement button_search;
	@FindBy(css="#content>#portal_content") WebElement searchContent;
	
	// set base configuration for class 
	public AkamaiCarrersMainPage(WebDriver driver){
		super(driver);
		this.PAGE_URL = "https://akamaijobs.referrals.selectminds.com/";
		this.PAGE_TITLE = "Akamai Careers - Jobs";
	} 
	// Type search String to the Search Box
	public void enterSearchString(String text){
		sendText(field_search, text);	
	}
	// Select Location from the location field
	public void selectLocation(String location) {
		//Create a dynamic xpath for entered String
		String locator = "//li[text()[contains(.,'"+location+"')]]"; 
	    WebElement locationElement = driver.findElement(By.xpath(locator));
	    clickElement(button_location);
	    clickElement(locationElement);
	    //Check if location is correctly added to the list 
	    String checkIfExist =  ".//*[@id='location_facet_chzn']//li//span[text()[contains(.,'"+location+"')]]";
	    WebElement element = driver.findElement(By.xpath(checkIfExist));
	    isElementDisplayed(element);	    
	}
	// Click on the Search button
	public void clickSearchButton(){
		clickElement(button_search);
		//Check if Search has been processed and Search content is displayed 
		waitForElement(searchContent);
		isElementDisplayed(searchContent);	
	}
}
