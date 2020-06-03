package com.etailpet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.etailpet.qa.base.TestBase;

public class ChangeStorePage extends TestBase {
	
	//Object Repository
	//Search Bar inside the Change Store
	@FindBy(xpath="//input[@id='autocomplete']")
	WebElement SearchStore;
	
	//
	
	

}
