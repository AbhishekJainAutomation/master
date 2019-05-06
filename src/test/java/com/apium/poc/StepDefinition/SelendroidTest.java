package com.apium.poc.StepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.Alert;
import com.apium.poc.config.EnvironmentSetUp;
import com.apium.poc.locators.pages.ConfirmRegistrationPage;
import com.apium.poc.locators.pages.ENPopup;
import com.apium.poc.locators.pages.HomePage;
import com.apium.poc.locators.pages.NewRegistrationPage;
import com.apium.poc.utilities.GenericFunctions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelendroidTest extends EnvironmentSetUp {
	HomePage homePageObject = null;
	NewRegistrationPage registrationPageObject = null;
	ConfirmRegistrationPage confirmationPageObject = null;
	String name, userName, email, pwd, lang, adds;
	GenericFunctions genericFunction= null;
	ENPopup enPopUpObject=null;

	@Before
	public void beforeMethod() throws IOException {
		setUpEnvironment();
		openApplication();
		genericFunction= new GenericFunctions(driver);
	}

	@After
	public void afterMethod() {
//		driver.quit();
	}
	
	@Given("^User opens Selendroid application$")
	public void user_opens_Selendroid_application() throws Throwable {
		homePageObject = new HomePage(driver);
	}

	@When("^User clicks on Create New User icon$")
	public void user_clicks_on_Create_New_User_icon() throws Throwable {
		registrationPageObject = homePageObject.click_NewRegBttn();
	}

	@When("^validate the elements on UI for home page$")
	public void validate_elements_on_home_page() throws Throwable {
		assertTrue(homePageObject.displayPopup.isDisplayed());
		assertTrue(homePageObject.displayToast.isDisplayed());
		assertTrue(homePageObject.newRegBttn.isDisplayed());
	}
	
	@When("^User provides valid details and click on submit button \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
	public void unser_provides_valid_details_and_click_on_submit_button(String name,String userName,String email,String password,String language,String addRequired,String isUsed) throws Throwable {
		this.name=name;
		this.userName=userName;
		this.email=email;
		this.pwd=password;
		this.lang=language;
		this.adds=addRequired;
		registrationPageObject.fillNewRegistrationPage(userName,email,password,name,addRequired);
		confirmationPageObject = registrationPageObject.click_NewRegBttn();
	}

	@Then("^User details should be populated correctly on verify screen$")
	public void user_details_should_be_populated_correctly_on_verify_screen() throws Throwable {
		assertEquals(confirmationPageObject.getText_nameVerText(), name);
		assertEquals(confirmationPageObject.getText_userNameVerText(), userName);
		assertEquals(confirmationPageObject.getText_emailVerText(), email);
		assertEquals(confirmationPageObject.getText_passwordVerText(), pwd);
		assertEquals(confirmationPageObject.getText_acceptAddsVerText().toLowerCase(), adds.toLowerCase());
		assertEquals(confirmationPageObject.getText_langVerText(), lang);
	}

	@When("^user clicks on Confirm button$")
	public void user_clicks_on_Confirm_button() throws Throwable {
		homePageObject = confirmationPageObject.click_finalRegisterBttn();

	}

	@Then("^homepage should be displayed$")
	public void homepage_should_be_displayed() throws Throwable {
		assertTrue(homePageObject.appTitle.isDisplayed());
	}

	
	@When("^User clicks on Display Popup button$")
	public void user_clicks_on_Display_Popup_button() throws Throwable {
	    homePageObject.click_displayPopup();
	}
	
	@When("^User clicks on EN button$")
	public void user_clicks_on_EN_button() throws Throwable {
	    homePageObject.click_EN();
	    enPopUpObject = new ENPopup(driver);
	}
	
	@When("^Popup should be displayed with Iagree and No button disabled$")
	public void validate_button_on_EN_popup() throws Throwable {
	    assertTrue(enPopUpObject.agreeButton.isDisplayed());
	    assertTrue(enPopUpObject.noButton.isDisplayed());
	}

	@When("^Agree button should have text \"(.*)\" and cancel button should have text \"(.*)\"$")
	public void agree_and_cancel_button_text_EN_popup(String agreeButtonText,String cancelButtonText) throws Throwable {
		assertEquals(enPopUpObject.agreeButton.getText(), agreeButtonText);
		assertEquals(enPopUpObject.noButton.getText(),cancelButtonText);
	}
	

	@Then("^user should be on home page on the click of cancel button$")
	public void user_should_be_able_to_cancel_ENPopup() throws Throwable {
		enPopUpObject.noButton.click();
		assertTrue(homePageObject.ENButton.isDisplayed());
	}
	
	@Then("^application should close on the click of agree button$")
	public void user_should_be_able_to_close_application_on_click_agreebutton_ENPopup() throws Throwable {
		enPopUpObject.agreeButton.click();
		assertFalse(homePageObject.ENButton.isDisplayed());
	}
	

}
