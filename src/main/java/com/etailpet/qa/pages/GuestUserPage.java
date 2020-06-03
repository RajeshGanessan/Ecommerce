package com.etailpet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etailpet.qa.base.TestBase;

public class GuestUserPage extends TestBase {
	
	//Sign in button 
	@FindBy(xpath="//a[contains(text(),' Sign In')]")
	WebElement SignInBtn;
	
	//Logo
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement GuestPageLogo;
	
	//Change Store button
	@FindBy(xpath="//a[contains(text(),'Change Store')]")
	WebElement GuestChangeStore;
	
	//Clicking inside Store Location **Pass the store name as variable**
	@FindBy(xpath="//a[contains(text(),'Awesome Florida')]")
	WebElement GuestChangeStoreLocation;
	
	//Selecting the store location
	@FindBy(xpath="//a[contains(text(),'SHOP THIS STORE')]")
	WebElement GuestSelectStore;
	
	//Click the Shop Item button
	@FindBy(xpath="//a[contains(text(),'SHOP ITEMS')]")
	WebElement GuestShopItem;	
	
	//Selecting products
	@FindBy(xpath="//a[@class='btn brand-bg-green cart-btn'][1]")
	WebElement GuestSelectProduct;
	
	//Entering the Quantity
	@FindBy(xpath="//input[@id='id_quantity']")
	WebElement GuestProductQuantity;
	
	//Click Add To Cart
	@FindBy(xpath="//button[@class='btn add-cart-btn']")
	WebElement GuestAddToCartBtn;
	
	//Floating View Cart button
	@FindBy(xpath="//b[contains(text(),'VIEW CART')]")
	WebElement GuestViewCartBtn;
	
	//Proceed to CheckOut button
	@FindBy(xpath="//a[@id='add-cart-btn']")
	WebElement GuestCheckOutBtn;
	
	
	// Guest User Email address for Order Notification
	@FindBy(xpath = "//input[@id='id_username']")
	WebElement GuestEmailNotification;

	// Guest user Phone Number
	@FindBy(xpath = "//input[@id='id_phone']")
	WebElement GuestUserPhoneNumber;

	// Add a Note
	@FindBy(xpath = "//textarea[@id='id_notes']")
	WebElement AddNote;

	// Continue Button from Guest User
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement GuestContinueBtn;

	// Delivery Address Details
	// First Name
	@FindBy(xpath = "//input[@id='id_first_name']")
	WebElement AddressFirstName;

	// LastName
	@FindBy(xpath = "//input[@id='id_last_name']")
	WebElement AddressLastName;

	// Address Line-1
	@FindBy(xpath = "//input[@id='id_line1']")
	WebElement AddressLine1;

	// Address Line-2
	@FindBy(xpath = "//input[@id='id_line2']")
	WebElement AddressLine2;

	// City
	@FindBy(xpath = "//input[@id='id_line4']")
	WebElement GuestAddressCity;

	// State
	@FindBy(xpath = "//input[@id='id_state']")
	WebElement GuestAddressState;

	// Zip Code
	@FindBy(xpath = "//input[@id='id_postcode']")
	WebElement GuestAddressZipCode;

	// Save and Continue
	@FindBy(xpath = "//button[text()='Save & Continue']")
	WebElement AddressSaveAndContinue;

	// Payment Section
	// Card Holder Full Name
	@FindBy(xpath = "//input[@id='id_name']")
	WebElement CardHolderName;

	// Card Number
	@FindBy(xpath = "//input[@id='ccnumfield']")
	WebElement CardNumber;

	// Cvv Input
	@FindBy(xpath = "//input[@id='cccvvfield']")
	WebElement CvvNumber;

	// Post Code
	@FindBy(xpath = "//input[@id='id_postcode']")
	WebElement PostCode;

	// Continue Button
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement PayementContinueBtn;

	// Complete CheckOut button
	@FindBy(xpath = "//button[@class='btn btn-default data-loader']")
	WebElement CompleteCheckOut;	
	
	//Initializing the Page Objects                                                                      
	public GuestUserPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public SignInPage FromGuestSignIn(){
		SignInBtn.click();
		return new SignInPage();
	}
	
	public boolean GuestPageLogo(){
		return GuestPageLogo.isDisplayed();
	}                                  
	
	public String GuestPageTitle(){
		return driver.getTitle();
	}
	
	public void GuestFlow(String StoreName,String ProductName,String DeliveryMethod) throws InterruptedException{
		GuestChangeStore.click();
		driver.findElement(By.xpath("//a[contains(text(),'"+StoreName+"')]")).click();
		GuestSelectStore.click();
		GuestShopItem.click();
		driver.findElement(By.xpath("//a[contains(text(),'"+ProductName+"')]")).click();	
		GuestSelectProduct.click();
		System.out.println(driver.getTitle());
		GuestProductQuantity.clear();
		GuestProductQuantity.sendKeys("3");
		GuestAddToCartBtn.click();
		Thread.sleep(3000);
		GuestViewCartBtn.click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[contains(text(),'"+DeliveryMethod+"')]"));
		if(DeliveryMethod=="Home Delivery"){
			GuestEmailNotification.sendKeys();
			
		}
		
		
		
		}
	
	

}
