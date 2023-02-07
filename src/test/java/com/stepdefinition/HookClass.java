package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.base.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.netty.channel.pool.FixedChannelPool.AcquireTimeoutAction;

public class HookClass extends BaseTest{
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver1(getPropertyFileValues("browserType"));
		geturl("https://www.saucedemo.com/");
		maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		boolean failed = scenario.isFailed();
		//if(failed) {
		scenario.attach(screenshot(),"image/png","Every Scenario");
		//}
		quiteWindow();
	}

}
