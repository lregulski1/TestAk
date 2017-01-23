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
	
	
	// Set driver
	public BaseMethods(WebDriver driver){
		this.driver = driver;
	}
	// Get PAGE_URL from the class
	public String getPageUrl(){
		return PAGE_URL;
	}
	// Get PAGE_TITLE from the class 
	public String getPageTitle(){
		return PAGE_TITLE;
	}
	// Load the PAGE_URL
	public void loadPage(){
		driver.get(getPageUrl());
	}
	// Check the PAGE_URL
	public void checkPageTitel(){
		Assert.assertEquals(driver.getTitle(), getPageTitle());
	}
	// Check is some element is displayed 
	public boolean isElementDisplayed(WebElement element){
	        return element.isDisplayed();
	    }
	// Wait for element
	public void waitForElement(WebElement element){
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	// Click on element
	public void clickElement(WebElement element){
		waitForElement(element);
		element.click();
	}
	// Send text to element
	public void sendText(WebElement element, String text){
		waitForElement(element);
		element.clear();
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"), text);	
	}
	
}
