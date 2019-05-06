package com.apium.poc.locators.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.apium.poc.utilities.AppiumUtility;
import com.apium.poc.utilities.GenericFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ENPopup {
	
    public WebElement agreeButton;
    public WebElement noButton;
    String locatorPropertyPath=System.getProperty("user.dir") +"/src/main/java/com/apium/poc/locators/repository/enPopup.properties";
    Properties homePageLocator = null;
	AndroidDriver<AndroidElement> driver;
    AppiumUtility initializeElement =null;
    
    public ENPopup(AndroidDriver<AndroidElement> driver)
    {
        this.driver = driver;
//        PageFactory.initElements(driver,this);
//        PageFactory.initElements(new AppiumFieldDecorator(Home_Page.driver),this);
        try {
			homePageLocator=(Properties) GenericFunctions.loadPropertiesFIle(locatorPropertyPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			initializeElements();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	private void initializeElements() throws IOException {
		// TODO Auto-generated method stub
		initializeElement = new AppiumUtility(driver);
		agreeButton=initializeElement.initializeElement(homePageLocator.getProperty("agreeButton"));
		noButton=initializeElement.initializeElement(homePageLocator.getProperty("noButton"));
	}

}
