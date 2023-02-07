package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseTest{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginSucccessMsg) {
		WebElement txtSuccessMsg = pom.getLoginPage().getTxtSuccessMsg();
		String attribute = getText(txtSuccessMsg);
		Assert.assertEquals("verify after login success message", expLoginSucccessMsg, attribute);  
	   
	}

}
