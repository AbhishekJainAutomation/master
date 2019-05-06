package com.apium.poc.utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumUtility {

	AndroidDriver<AndroidElement> driver;
	
	public AppiumUtility(AndroidDriver<AndroidElement> driver) throws IOException
    {
        this.driver = driver;
    }
	
	public WebElement initializeElement(String xpathValue) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath(xpathValue));
	}

	public void enterText(WebElement element, String data) {
		// TODO Auto-generated method stub
		element.sendKeys(data);
	}
	
	public void clearText(WebElement element)
	{
		element.clear();
	}

}
