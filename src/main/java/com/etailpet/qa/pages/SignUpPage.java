package com.etailpet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etailpet.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	//Page Factory or Object Repository
	//SignUp button in the Sign in page
	@FindBy(xpath="//a[contains(text(),'SIGN UP')]")
	WebElement FirstSignUpBtn;
	//Firstname
	@FindBy(name="first_name")
	WebElement FirstName;
	
	//Lastname
	@FindBy(name="last_name")
	WebElement LastName;
	
	//Email
	@FindBy(id="id_email")
	WebElement EmailID;
	
	//PhoneNumber
	@FindBy(id="id_phone")
	WebElement PhoneNumber;
	
	//Password
	@FindBy(id="id_password1")
	WebElement SignInPassword;
	
	//Confirm Password
	@FindBy(id="id_password2")
	WebElement ConfirmPassword;
	
	//SignUp button.
	@FindBy(xpath="//button[contains(text(),'SIGN UP')]")
	WebElement SignUpBtn;
	
	//Logo
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement SignUpLogo;
	
	//Using Facebook Link
	@FindBy(xpath="//a[contains(@aria-label,'Facebook')]")
	WebElement SignUpFacebookBtn;
	
	//Facebook Password
	@FindBy(xpath="//input[@name='pass']")
	WebElement FacebookPassword;
	
	//Facebook Email
	@FindBy(xpath="//input[@name='email']")
	WebElement FacebookEmail;
	
	//Facebook Login button
	@FindBy(xpath="//button[@id='loginbutton']")
	WebElement FacebookLoginBtn;
	
	//Google Plus button 
	@FindBy(xpath="//a[contains(@aria-label,'Google Plus')]")
	WebElement SignUpGoogleBtn;
	
	//Google plus Email Field
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement SignUpGooglePlusEmail;
	
	//Google plus Email Field 'Next' button
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement SignUpGoogleNextBtn;
	

	//Initializing Page Factory Method.
	public SignUpPage(){
		PageFactory.initElements(driver, this);
		}
	
	//Actions
	public SignUpPage SignUpPageNavigation(){
		 FirstSignUpBtn.click();
		 return new SignUpPage();
	}	
	
	public String ValidateSignUpPageTitle(){
		return driver.getTitle();
	}
	
	public boolean SignUpImageValidation(){
		return SignUpLogo.isDisplayed();
	}
	
	public SignInPage SignUp(String FN,String LN,String mail,String PN,String Pass,String CPass){
		FirstName.sendKeys(FN);
		LastName.sendKeys(LN);
		EmailID.sendKeys(mail);
		PhoneNumber.sendKeys(PN);
		SignInPassword.sendKeys(Pass);
		ConfirmPassword.sendKeys(CPass);
		SignUpBtn.click();
		return new SignInPage();
	}
	                        
	public HomePage SignUpFacebook() throws InterruptedException{
		SignUpFacebookBtn.click();
		FacebookEmail.sendKeys("sivaprakash340640@gmail.com");
		FacebookPassword.sendKeys("thomas001");
		FacebookLoginBtn.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		return new HomePage();
	}
	
	public HomePage SignUpGooglePlus() throws InterruptedException{
		SignUpGoogleBtn.click();
		SignUpGooglePlusEmail.sendKeys("me.sivaprakasam@gmail.com");
		SignUpGoogleNextBtn.click();
		Thread.sleep(5000);		
		System.out.println(driver.getTitle());
		return new HomePage();
	}
	
	
	}

	
	
       
