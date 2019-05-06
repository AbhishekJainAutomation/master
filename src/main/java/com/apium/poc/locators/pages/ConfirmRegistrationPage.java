package com.apium.poc.locators.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.apium.poc.utilities.AppiumUtility;
import com.apium.poc.utilities.GenericFunctions;

public class ConfirmRegistrationPage {
	
	AndroidDriver<AndroidElement> driver;
	String locatorPropertyPath=System.getProperty("user.dir") +"/src/main/java/com/apium/poc/locators/repository/confirmRegistrationPage.properties";
    Properties confirmRegistrationPageLocator = null;
    
    public ConfirmRegistrationPage(AndroidDriver<AndroidElement> driver)
    {
        this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//        PageFactory.initElements(driver,this);
        try {
        	confirmRegistrationPageLocator=(Properties) GenericFunctions.loadPropertiesFIle(locatorPropertyPath);
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
    	AppiumUtility initializeElement = new AppiumUtility(driver);
    	driver.hideKeyboard();
    	NameVerText=initializeElement.initializeElement(confirmRegistrationPageLocator.getProperty("NameVerText"));
    	userNameVerText=initializeElement.initializeElement(confirmRegistrationPageLocator.getProperty("userNameVerText"));
    	emailVerText=initializeElement.initializeElement(confirmRegistrationPageLocator.getProperty("emailVerText"));
    	progDataVerText=initializeElement.initializeElement(confirmRegistrationPageLocator.getProperty("progDataVerText"));
    	acceptAddsVerText=initializeElement.initializeElement(confirmRegistrationPageLocator.getProperty("acceptAddsVerText"));
    	passwordVerText=initializeElement.initializeElement(confirmRegistrationPageLocator.getProperty("passwordVerText"));	
    	finalRegisterBttn=initializeElement.initializeElement(confirmRegistrationPageLocator.getProperty("finalRegisterBttn"));	
	}

    
//    @AndroidFindBy(id="io.selendroid.testapp:id/label_name_data")
    public WebElement NameVerText;
//    @AndroidFindBy(id="io.selendroid.testapp:id/label_username_data")
    public WebElement userNameVerText;
//    @AndroidFindBy(id="io.selendroid.testapp:id/label_email_data")
    public WebElement emailVerText;
//    @AndroidFindBy(id="io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
    public WebElement progDataVerText;
//    @AndroidFindBy(id="io.selendroid.testapp:id/label_acceptAdds_data")
    public WebElement acceptAddsVerText;
//    @AndroidFindBy(id="io.selendroid.testapp:id/label_password_data")
    public WebElement passwordVerText;
//    @AndroidFindBy(id="io.selendroid.testapp:id/buttonRegisterUser")
    public WebElement finalRegisterBttn;

    
    public String getText_nameVerText()
    {
    	return NameVerText.getText();
    }
    public String getText_passwordVerText()
    {
    	return passwordVerText.getText();
    }
    public String getText_userNameVerText()
    {
    	return userNameVerText.getText();
    }
    public String getText_emailVerText()
    {
    	return emailVerText.getText();
    }
    public String getText_langVerText()
    {
    	return progDataVerText.getText();
    }
    public String getText_acceptAddsVerText()
    {
    	return acceptAddsVerText.getText();
    }
    
    
    public HomePage click_finalRegisterBttn()
    {
    	finalRegisterBttn.click();
    	HomePage hp= new HomePage(driver);
    	return hp;
    }

}
