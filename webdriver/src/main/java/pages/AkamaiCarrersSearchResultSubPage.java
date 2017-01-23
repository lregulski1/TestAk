package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BaseMethods;

public class AkamaiCarrersSearchResultSubPage extends BaseMethods{
	
	@FindBy(css=".job_post_date>.field_value") WebElement postedDate; 
	
	public AkamaiCarrersSearchResultSubPage(WebDriver driver){
		super(driver);
	} 
	// Check post date of the job offer
	public void checkPosstDate(String date){
		waitForElement(postedDate);
		Assert.assertEquals(date, postedDate.getText());	
	}
}
