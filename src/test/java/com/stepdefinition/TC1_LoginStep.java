package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseTest{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the SwagLabs page")
	public void userIsOnTheSwagLabsPage() {
		
	   
	}
	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String username, String password) {
		pom.getLoginPage().login(username, password);

	}
	
	
	
	@When("User should perform login {string},{string} with Enter key")
	public void userShouldPerformLoginWithEnterKey(String username, String password) throws Exception {
	  pom.getLoginPage().loginWithEnterKey(username, password);
	}
	
	@Then("User should verify after login with invalid credential error msg {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMsg(String expLoginErrorMsg) {
		
		WebElement txtErrorMsg = pom.getLoginPage().getTxtErrorMsg();
		String text=getText(txtErrorMsg);
		boolean b = text.contains(expLoginErrorMsg);
		Assert.assertTrue("verify after login with invalid credential error msg contains",b);

	}
	
	

}
