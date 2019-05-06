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

public class NewRegistrationPage {
	
	AndroidDriver<AndroidElement> driver;
	String locatorPropertyPath=System.getProperty("user.dir") +"/src/main/java/com/apium/poc/locators/repository/newRegistrationPage.properties";
    Properties newRegistrationPageLocator = null;
    static AppiumUtility appiumAction = null;
    
    public NewRegistrationPage(AndroidDriver<AndroidElement> driver)

    {
        this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//        PageFactory.initElements(driver,this);
        try {
        	newRegistrationPageLocator=(Properties) GenericFunctions.loadPropertiesFIle(locatorPropertyPath);
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
    	appiumAction = new AppiumUtility(driver);
    	driver.hideKeyboard();
    	userNameText=appiumAction.initializeElement(newRegistrationPageLocator.getProperty("userNameText"));
    	emailText=appiumAction.initializeElement(newRegistrationPageLocator.getProperty("emailText"));
    	pwdText=appiumAction.initializeElement(newRegistrationPageLocator.getProperty("pwdText"));
    	nameText=appiumAction.initializeElement(newRegistrationPageLocator.getProperty("nameText"));
    	addsChkBox=appiumAction.initializeElement(newRegistrationPageLocator.getProperty("addsChkBox"));
    	registerBttn=appiumAction.initializeElement(newRegistrationPageLocator.getProperty("registerBttn"));	
	}

//    @AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
    public WebElement userNameText;
    
//    @AndroidFindBy(accessibility = "email of the customer")
    public WebElement emailText;
    
//    @AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
    public WebElement pwdText;
    
//    @AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
    public WebElement nameText;
    
//    @AndroidFindBy(id="io.selendroid.testapp:id/input_adds")
    public WebElement addsChkBox;
    
//    @AndroidFindBy(id="io.selendroid.testapp:id/btnRegisterUser")
    public WebElement registerBttn;
    public void selectCkBox_Adds() {
    	addsChkBox.click();
	}
    
    public ConfirmRegistrationPage click_NewRegBttn()
    {
    	registerBttn.click();
    	ConfirmRegistrationPage cp= new ConfirmRegistrationPage(driver);
    	return cp;
    }

	public void fillNewRegistrationPage(String userName, String email, String pwd, String name,String adds) {
		// TODO Auto-generated method stub
		appiumAction.clearText(nameText);
		appiumAction.enterText(userNameText,userName);
		appiumAction.enterText(emailText,email);
		appiumAction.enterText(pwdText,pwd);
		appiumAction.enterText(nameText,name);
		GenericFunctions.hideKeyBoard(driver);
		if (adds.equalsIgnoreCase("TRUE")) {
			if (addsChkBox.isSelected() != true) {
				selectCkBox_Adds();
			}
		}
	}
}
