package com.cucumber.framework.Helper.JavaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.framework.Helper.Logger.LoggerHelper;

import org.apache.log4j.Logger;

public class JavaScriptHelper {
	
	private WebDriver driver;
	private Logger Log= LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver)
	{
		this.driver=driver;
		Log.debug("JavaScriptHelper : " + this.driver.hashCode());
	}
	
	public Object executeScript(String script)
	{
		JavascriptExecutor exe= (JavascriptExecutor) driver;
		Log.info(script);
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args)
	{
		JavascriptExecutor exe= (JavascriptExecutor) driver;
		Log.info(script);
		return exe.executeScript(script,args);
	}
	
	public void scrollToElement(WebElement element)
	{
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
		Log.info(element);
	}
	
	public void scrollToElementAndClick(WebElement element)
	{
		scrollToElement(element);
		element.click();
		Log.info(element);
	}
	
	public void scrollIntoView(WebElement element)
	{
		executeScript("arguments[0].scrollIntoView()", element);
		Log.info(element);
	}
	
	public boolean scrollIntoViewAndClick(WebElement element)
	
	{
		boolean flag=false;
		try
		{
			scrollIntoView(element);
			if(element.isDisplayed())
			{
				element.click();
				Log.info(element);
				flag=true;
			}
		}
		
		
			catch (RuntimeException e)
			{
				System.out.println(e.getMessage());
				Log.info("Throwing run time exception for Element is not displayed for elemenet  " + element.getTagName().toString());
				//exception_Msg=e.getMessage()+ element.getTagName().toString();
				
			}
		return flag;
	}
}
