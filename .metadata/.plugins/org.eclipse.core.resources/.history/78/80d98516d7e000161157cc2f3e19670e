package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class BaseMethods {
	
	public WebDriver driver;
	public String PAGE_URL;
	public String PAGE_TITLE;
	
	public BaseMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageUrl(){
		return PAGE_URL;
	}
	public String getPageTitle(){
		return PAGE_TITLE;
	}
	
	public void loadPage(){
		driver.get(getPageUrl());
	}
	public void checkPageTitel(){
		Assert.assertEquals(driver.getTitle(), getPageTitle());
	}

	 public boolean isElementVisible(WebElement element){
	        return element.isDisplayed();
	    }
	 
	public void waitForElement(WebElement element){
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	
	public void clickElement(WebElement element){
		element.click();
	}
	
}
