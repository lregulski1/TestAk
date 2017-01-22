package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BaseMethods;


public class AkamaiCarrersMainPage extends BaseMethods{	
	
	@FindBy(css=".ui-front>#keyword") WebElement field_search;
	@FindBy(css=".jAddFacetSearch>#jLocInputHldr") WebElement button_location;
	@FindBy(css=".search_btn>.btn_text") WebElement button_search;
	@FindBy(css="#content>#portal_content") WebElement searchContent;
	
	
	public AkamaiCarrersMainPage(WebDriver driver){
		super(driver);
		this.PAGE_URL = "https://akamaijobs.referrals.selectminds.com/";
		this.PAGE_TITLE = "Akamai Careers - Jobs";
	} 
	
	public void enterSearchString(String text){
		field_search.clear();
		field_search.sendKeys(text);
		Assert.assertEquals(field_search.getAttribute("value"), text);	
	}
	
	public void selectLocation(String location) {
		//Create a dynamic xpath for entered String
		String locator = "//li[text()[contains(.,'"+location+"')]]"; 
	    WebElement locationElement = driver.findElement(By.xpath(locator));
	    button_location.click();
	    locationElement.click();
	    //Check if location is correctly added to the list 
	    String checkIfExist =  ".//*[@id='location_facet_chzn']//li//span[text()[contains(.,'"+location+"')]]";
	    WebElement element = driver.findElement(By.xpath(checkIfExist));
	    isElementVisible(element);	    
	}
	
	public void clickSearchButton(){
		clickElement(button_search);
		//Check if Search has been processed and Search content is displayed 
		waitForElement(searchContent);
		isElementVisible(searchContent);	
	}
}
