package com.etailpet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestUserPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;

public class ShopItemTest extends TestBase {
	ShopItemPage shopItemPage;
	SignInPage signinpage;
	HomePage homePage;
	GuestUserPage GuestUser;
	       
	public ShopItemTest(){                         
		super();                   
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		signinpage=new SignInPage();
		shopItemPage=new ShopItemPage();
		homePage=new HomePage();
		GuestUser=new GuestUserPage();
		signinpage=GuestUser.FromGuestSignIn();		
		shopItemPage=signinpage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		//shopItemPage=homePage.ClickOnShopItemLink();
	}
	
	@Test(priority=1)
	public void VerifyShopItemLogoTest(){
		Assert.assertTrue(shopItemPage.CheckShopItemPageLogo());
	}
	
	@Test(priority=2)
	public void VerifyShopItemTitleTest(){
		String Title=shopItemPage.CheckShopItemTitle();
		System.out.println("The Title is"+Title);
		Assert.assertEquals(Title,"Products | Awesome Pet's");
	}
	
	@Test(priority=3)
	public void VerifySearchWithResultsTest(){
		shopItemPage.CheckSearchWithinResult();
	}
	
	@Test(priority=4)
	public void VerifyCheckFilterCheckBoxTest(){
		shopItemPage.CheckFilterCheckBox("Home Delivery");
	}
	
	@Test(priority=5)
	public void ClearCheckFilterTest(){
		shopItemPage.CheckClearFiltersButton("Home Delivery");
	}
	
	@Test(priority=6)
	public void CheckSortByTest(){
		shopItemPage.CheckSortBy("Name: A to Z");
	}
	
	
	@Test(priority=7)
	public void CheckSelectBrandTest(){
		shopItemPage.CheckSelectBrand("Acana");
	}
	
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
	

}
