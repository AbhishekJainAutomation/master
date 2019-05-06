package com.apium.poc.locators.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.apium.poc.utilities.AppiumUtility;
import com.apium.poc.utilities.GenericFunctions;

public class HomePage {
	
	AndroidDriver<AndroidElement> driver;

	String locatorPropertyPath=System.getProperty("user.dir") +"/src/main/java/com/apium/poc/locators/repository/homePage.properties";
    Properties homePageLocator = null;
    AppiumUtility initializeElement =null;
	public HomePage(AndroidDriver<AndroidElement> driver)
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
		newRegBttn=initializeElement.initializeElement(homePageLocator.getProperty("newRegBttn"));
		appTitle=initializeElement.initializeElement(homePageLocator.getProperty("appTitle"));
		displayToast=initializeElement.initializeElement(homePageLocator.getProperty("displayToast"));
		displayPopup=initializeElement.initializeElement(homePageLocator.getProperty("displayPopup"));
		ENButton=initializeElement.initializeElement(homePageLocator.getProperty("ENButton"));
	}

//	@AndroidFindBy(xpath="//*[@resource-id='io.selendroid.testapp:id/startUserRegistration']")
//    @AndroidFindBy(id="io.selendroid.testapp:id/startUserRegistration")
    public WebElement newRegBttn;
    
//    @AndroidFindBy(id = "android:id/title")
    public WebElement appTitle;
    
//    @AndroidFindBy(id = "io.selendroid.testapp:id/showToastButton")
    public WebElement displayToast;
    
//    @AndroidFindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
    public WebElement displayPopup;
    public WebElement ENButton;
    
    
    public NewRegistrationPage click_NewRegBttn()
    {
    	newRegBttn.click();
    	NewRegistrationPage rp= new NewRegistrationPage(driver);
    	return rp;
    }
    
    public void click_displayToast()
    {
    	displayToast.click();
    }
    
    public void click_EN()
    {
    	ENButton.click();
    }
    public void click_displayPopup()
    {
    	displayPopup.click();
    }
    
    

}
