package com.etailpet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestUserPage;

public class GuestUserPageTest extends TestBase {
	
	GuestUserPage GuestUser;
	
	public GuestUserPageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		GuestUser=new GuestUserPage();
	}           
	
	@Test
	public void VerifyGuestUserTitle(){
		String title=GuestUser.GuestPageTitle();
		Assert.assertEquals(title,"Shop Now | Awesome Pet's","The Title of the page is not matched");
	}
	
	@Test
	public void VerifyGuestUserLogo(){
		boolean logo=GuestUser.GuestPageLogo();         
		Assert.assertTrue(logo);
	}
	
	@Test
	public void GuestUserSignInTest(){
		GuestUser.FromGuestSignIn();
	}
	
	@Test
	public void VerifyGuestFlowTest() throws InterruptedException{
		GuestUser.GuestFlow(prop.getProperty("Location"),prop.getProperty("Product"),prop.getProperty("DeliveryMethod"));
	}
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
	

}
