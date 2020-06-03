package com.etailpet.qa.testcases;

import org.apache.poi.hwpf.model.SinglentonTextPiece;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestUserPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;
import com.etailpet.qa.pages.SignUpPage;

public class SignInPageTest extends TestBase{
	SignInPage signinPage;
	ShopItemPage ShopItempage;
	SignUpPage signuppage;
	GuestUserPage GuestUser;
	
	public SignInPageTest(){
		super();
	}
	
	@BeforeMethod    
	public void setUp(){
		initialization();
		signinPage= new SignInPage();  
		//GuestUser=new GuestUserPage();
		//signinPage=GuestUser.FromGuestSignIn();		
	}
	@Test(priority=1)
	public void SigninPageTitleTest(){
		String title=signinPage.ValidateSignInPageTitle();
		Assert.assertEquals(title,"Sign In | Awesome Pet's");
	}
	@Test(priority=2)
	public void etailLogoTest(){
		boolean flag=signinPage.ValidateEtailPetImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void signinTest(){
		ShopItempage=signinPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
	}
	                                     
	@Test(priority=4)                 
	public void NavigateToSignUpPageTest(){                                                   
		signuppage=signinPage.NavigateToSignUpPage();
	}
	
	@Test(priority=4)
	public void SignInFacebookTest() throws InterruptedException{
		signinPage.SignInFacebook();
	}
	
	@Test
	public void SignInGooglePlusTest() throws InterruptedException{
		signinPage.SignInGooglePlus();        
	}
	
	@AfterMethod 
	public void teardown(){
		driver.quit();
	}

}
