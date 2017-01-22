package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BaseMethods;


public class AkamaiCarrersSerachResultPage extends BaseMethods{
	
	

	@FindBy(css="#jobs_filters_title>.number_of_results>.total_results") WebElement searchResult;
	@FindBy(css="#content>#job_details_content") WebElement page_jobDetails;
		
	public AkamaiCarrersSerachResultPage(WebDriver driver){
		super(driver);
		this.PAGE_TITLE ="Job Search Results - Akamai Careers";
	} 
	
	
	public void checkNumberOfResults(String number){
		waitForElement(searchResult);
		Assert.assertEquals(searchResult.getText(), number);
	}
	
	
	public void numberOfResultsForString (int number, String text){
		String stringForSearchedPhrases = "//div[@class='jlr_title']//a[text()[contains(.,'"+text+"')]]";
		List<WebElement> totalResults = driver.findElements(By.xpath(stringForSearchedPhrases));
		int numberOfResults = totalResults.size();
		Assert.assertEquals(number, numberOfResults);		
	}
	
	public void clickOnOffer(String text){
		String stringForSearchedPhrases = "//div[@class='jlr_title']//a[text()[contains(.,'"+text+"')]]";
		//WebElement element = driver.findElement(By.xpath(stringForSearchedPhrases));
		waitForElement(driver.findElement(By.xpath(stringForSearchedPhrases)));
		WebElement element = driver.findElement(By.xpath(stringForSearchedPhrases));
		clickElement(element);
		//Check if jobs details page is open
		isElementVisible(page_jobDetails);
	}		
}
