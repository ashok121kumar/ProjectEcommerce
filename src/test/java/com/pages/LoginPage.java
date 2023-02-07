package com.pages;

import com.base.BaseTest;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement txtUserName;

	@FindBy(xpath="//input[@id='password']")
	private WebElement txtPasword;
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	private WebElement txtSuccessMsg;
	
	@FindBy(xpath="//h3[@data-test='error']")
	private WebElement txtErrorMsg;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPasword() {
		return txtPasword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtSuccessMsg() {
		return txtSuccessMsg;
	}

	public WebElement getTxtErrorMsg() {
		return txtErrorMsg;
	}
	
	public void login(String username,String password) {
		elementSendKeys(getTxtUserName(),username);
		elementSendKeys(txtPasword, password);
		elementclick(getBtnLogin());
	//	Alert alert = driver.switchTo().alert();
	//	alert.accept();
		

	}
	
	public void loginWithEnterKey(String username,String password) throws Exception {
		elementSendKeys(getTxtUserName(),username);
		elementSendKeys(txtPasword, password);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	//	Alert alert = driver.switchTo().alert();
	//	alert.accept();
		
	}
	
}
