package com.etailpet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.etailpet.qa.base.TestBase;

public class PaymentPage extends TestBase {
	

	//Guest User Email address for Order Notification
	@FindBy(xpath="//input[@id='id_username']")
	WebElement GuestEmailNotification;
	
	//Guest user Phone Number
	@FindBy(xpath="//input[@id='id_phone']")
	WebElement GuestUserPhoneNumber;
	
	//Add a Note
	@FindBy(xpath="//textarea[@id='id_notes']")
	WebElement AddNote;
	
	//Continue Button from Guest User
	@FindBy(xpath="//button[text()='Continue']")
	WebElement ContinueBtn;
	
	//Delivery Address Details
	//First Name
	@FindBy(xpath="//input[@id='id_first_name']")
	WebElement AddressFirstName;
	
	//LastName
	@FindBy(xpath="//input[@id='id_last_name']")
	WebElement AddressLastName;
	
	//Address Line-1
	@FindBy(xpath="//input[@id='id_line1']")
	WebElement AddressLine1;
	
	//Address Line-2
	@FindBy(xpath="//input[@id='id_line2']")
	WebElement AddressLine2;   
	
	//City
	@FindBy(xpath="//input[@id='id_line4']")
	WebElement AddressCity;
	
	//State
	@FindBy(xpath="//input[@id='id_state']")
	WebElement AddressState;
	
	//Zip Code
	@FindBy(xpath="//input[@id='id_postcode']")
	WebElement AddressZipCode;
	
	//Save and Continue
	@FindBy(xpath="//button[text()='Save & Continue']")
	WebElement AddressSaveAndContinue;
	
	//Payment Section 
	//Card Holder Full Name
	@FindBy(xpath="//input[@id='id_name']")
	WebElement CardHolderName;
	
	//Card Number
	@FindBy(xpath="//input[@id='ccnumfield']")
	WebElement CardNumber;
	
	//Cvv Input
	@FindBy(xpath="//input[@id='cccvvfield']")               
	WebElement CvvNumber;
	
	//Post Code
	@FindBy(xpath="//input[@id='id_postcode']")
	WebElement PostCode;
	
	//Continue Button
	@FindBy(xpath="//button[text()='Continue']")
	WebElement PayementContinueBtn;
	
	//Complete CheckOut button
	@FindBy(xpath="//button[@class='btn btn-default data-loader']")
	WebElement CompleteCheckOut;
	
	//Store Pick-Up Object Repository
	@FindBy(xpath="//span[text()='Store Pickup']")
	WebElement SelectStorePickUp;
	
	//Continue as a Guest User Button
	@FindBy(xpath="//button[text()='Continue as guest']")
	WebElement ContinueAsGuestBtn;
	
	//Ship To Me Object Repository
	@FindBy(xpath="//span[text()='Ship to Me']")
	WebElement SelectShipToMeBtn;
	
	//Frequent Buyers Continue button
	@FindBy(xpath="//div[@class='col-sm-4 mb-10']")
	WebElement FrequentBuyerContinueBtn;
	
	//Auto-Order Continue button
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement AutoOrderContinueBtn;
	
	//Expire Month and Year
	@FindBy(xpath="//input[@name='exp-date']")
	WebElement ExpireMonth;
	
	//Cvv Number
	@FindBy(xpath="//input[@name='cvc']")
	WebElement Cvv;
	
	//Selecting the delivery method radio check box
	@FindBy(xpath="//span[text()='Home Delivery']")
	WebElement SelectHomeDelivery;
	
	
	
	//Initializing the Page Objects
	public PaymentPage(){                                                        
		PageFactory.initElements(driver, this);
	}
	
	public String PaymentPageTitle(){
		return driver.getTitle();
	}
	
	public void GuestUserHomeDeliveryPayment(String Email,String Phone,String FirstName,String LastName,
			String addressLine1,String addressLine2,String City,String State,
			String ZipCode,String HolderName,String cardNumber,String ExpirationMonth,String ExpirationYear,String cvvNumber,String postCode){
		GuestEmailNotification.sendKeys(Email);
		GuestUserPhoneNumber.sendKeys(Phone);
		AddNote.sendKeys("This is Note");
		ContinueBtn.click();
		AddressFirstName.sendKeys(FirstName);
		AddressLastName.sendKeys(LastName);
		AddressLine1.sendKeys(addressLine1);
		AddressLine2.sendKeys(addressLine2);
		AddressCity.sendKeys(City);
		AddressState.sendKeys(State);
		AddressZipCode.sendKeys(ZipCode);
		AddressSaveAndContinue.click();
		CardHolderName.sendKeys(HolderName);
		CardNumber.sendKeys(cardNumber);
		Select select=new Select(driver.findElement(By.id("ccexpirymonth")));
		select.selectByVisibleText(ExpirationMonth);
		Select select1=new Select(driver.findElement(By.id("ccexpiryyear")));
		select1.selectByVisibleText(ExpirationYear);
		CvvNumber.sendKeys(cvvNumber);
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click();
		CompleteCheckOut.click();                                                  
	}
	
	public void GuestUserStorePickUpPayment(String Email,String Phone,String HolderName,
			String cardNumber,String ExpirationYear,String cvvNumber,String postCode){
		GuestEmailNotification.sendKeys(Email);
		GuestUserPhoneNumber.sendKeys(Phone);
		AddNote.sendKeys("This is Note");
		ContinueBtn.click();
		CardHolderName.sendKeys(HolderName);
		CardNumber.sendKeys(cardNumber);
		Select select=new Select(driver.findElement(By.id("ccexpirymonth")));
		select.selectByVisibleText(cardNumber);
		Select select1=new Select(driver.findElement(By.id("ccexpiryyear")));
		select1.selectByVisibleText(ExpirationYear);
		CvvNumber.sendKeys(cvvNumber);
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click();
		CompleteCheckOut.click();
	}
	
		
	public void GuestShipToMePayment(String Email,String Phone,String FirstName,String LastName,
			String addressLine1,String addressLine2,String City,String State,
			String ZipCode,String HolderName,String cardNumber,String ExpirationMonth,String ExpirationYear,String cvvNumber,String postCode){
		GuestEmailNotification.sendKeys(Email);
		GuestUserPhoneNumber.sendKeys(Phone);
		AddNote.sendKeys("This is Note");
		ContinueBtn.click();
		AddressFirstName.sendKeys(FirstName);
		AddressLastName.sendKeys(LastName);
		AddressLine1.sendKeys(addressLine1);
		AddressLine2.sendKeys(addressLine2);
		AddressCity.sendKeys(City);
		AddressState.sendKeys(State);
		AddressZipCode.sendKeys(ZipCode);
		AddressSaveAndContinue.click();
		CardHolderName.sendKeys(HolderName);
		CardNumber.sendKeys(cardNumber);
		Select select=new Select(driver.findElement(By.id("ccexpirymonth")));
		select.selectByVisibleText(ExpirationMonth);
		Select select1=new Select(driver.findElement(By.id("ccexpiryyear")));
		select1.selectByVisibleText(ExpirationYear);
		CvvNumber.sendKeys(cvvNumber);
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click();
		CompleteCheckOut.click();

	}	
	
	public void RegUserHomeDelivery(String FirstName,
			String LastName,String addressLine1,String addressLine2,String City,String State,String 
			zipCode,String HolderName,String cardNumber,String expireMonth,String cvv,String postCode){
		//SelectHomeDelivery.click();
		AddNote.sendKeys("Home Delivery");
		ContinueBtn.click();
		AddressFirstName.sendKeys(FirstName);
		AddressLastName.sendKeys(LastName);
		AddressLine1.sendKeys(addressLine1);
		AddressLine2.sendKeys(addressLine2);
		AddressCity.sendKeys(City);
		AddressState.sendKeys(State);
		AddressZipCode.sendKeys(zipCode);
		AddressSaveAndContinue.click();
		FrequentBuyerContinueBtn.click();
		CardHolderName.sendKeys(HolderName);
		CardNumber.sendKeys(cardNumber);
		ExpireMonth.sendKeys(expireMonth);
		Cvv.sendKeys(cvv);
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click();
		CompleteCheckOut.click();
		
	}
	
	
	
}
