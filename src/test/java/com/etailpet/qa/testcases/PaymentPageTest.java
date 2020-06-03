package com.etailpet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.CartPage;
import com.etailpet.qa.pages.GuestUserPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.PaymentPage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;
import com.etailpet.qa.util.TestUtil;

public class PaymentPageTest extends TestBase{
	
	PaymentPage Paymentpage;
	SignInPage signinpage;
	HomePage homePage;
	ShopItemPage ShopItem;
	GuestUserPage GuestUser;
	CartPage cartpage; 
	
	String sheetName="GuestHomeDeliveryPayment";
	String sheetName1="RegUserHomeDeliveryPayment";
	public  PaymentPageTest(){             
		super();
	}
	  
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();
		signinpage=new SignInPage();
		homePage=new HomePage();
		ShopItem=new ShopItemPage();
		//GuestUser=new GuestUserPage();
		//signinpage=GuestUser.FromGuestSignIn();
		ShopItem=signinpage.signIn(prop.getProperty("username"),prop.getProperty("password"));
		cartpage=ShopItem.ClickOnCartItemLink();  
		Paymentpage=cartpage.ProceedToCheckOutButton();  
	}
	
	@Test(priority=1)
	public void PaymentPageTitleTest(){
		String Title=Paymentpage.PaymentPageTitle();
		System.out.println("The Title of the page is "+Title);
		Assert.assertEquals(Title,"Promotion Code | Checkout | Awesome Pet's","The Title of the page is not matching");
	}
	
	@DataProvider
	public Object[][] getGuestUserHomeDeliveryPayment(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getGuestUserHomeDeliveryPayment")
	public void GuestHomeDeliveryPaymentTest(String Email,String Phone,String FirstName,String LastName,
			String addressLine1,String addressLine2,String City,String State,
			String ZipCode,String HolderName,String cardNumber,String ExpirationMonth,String ExpirationYear,String cvvNumber,String postCode){
		Paymentpage.GuestUserHomeDeliveryPayment(Email, Phone, FirstName, LastName, addressLine1, addressLine2, 
				City, State, ZipCode, HolderName, cardNumber, ExpirationMonth, ExpirationYear, cvvNumber, postCode);
	}
	
	@DataProvider       
	public Object[][] RegUserHomeDeliveryPaymentData(){
		Object data[][]=TestUtil.getTestData(sheetName1);
		return data;
	}
	
	@Test(priority=3,dataProvider="RegUserHomeDeliveryPaymentData")
	public void RegUserHomeDeliveryPaymentTest(String FirstName,String LastName,String addressLine1,String addressLine2,String City,String State,
			String Zipcode,String HolderName,String cardNumber,String expireMonth,String cvv,String postCode){
		Paymentpage.RegUserHomeDelivery(FirstName, LastName, addressLine1, addressLine2, City, State,
				Zipcode, HolderName, cardNumber, expireMonth, cvv, postCode);
	}                
	
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}

}  
