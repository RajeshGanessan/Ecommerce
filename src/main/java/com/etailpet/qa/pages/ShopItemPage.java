package com.etailpet.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.etailpet.qa.base.TestBase;

public class ShopItemPage extends TestBase{
	
	SignInPage signInPage;
	HomePage homePage;
	
	//Object Repository for Shop Item Page.
	//Search Within Result
	@FindBy(xpath="//input[@name='query']")
	WebElement SearchWithinResult;
	
	//Click Search Button
	@FindBy(xpath="//i[contains(@class,'flaticon-search')]")
	WebElement SearchEnterButton;
	
	//Choose Filters
	@FindBy(xpath="//span[contains(text(),'In-store Pickup')]")
	WebElement SelectFilter;
	
	//Choose Sort By
	@FindBy(xpath="//select[contains(@name,'price-filter')]")
	WebElement SortByDropDown;
	
	//Select Category
//	@FindBy(xpath="//button[contains(@class,'btn btn-default dropdown-toggle')]")
//	WebElement SelectCategory;
	
	//Clear Filter button
	@FindBy(xpath="//a[contains(text(),'Clear Filters')]")
	WebElement ClearFilter; 
	
	//Stop Item Page Logo
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement ShopItemPageLogo;
	
	//Cartbutton
	@FindBy(xpath="//span[contains(@id,'cartCount')]")
	WebElement CartButton;
	
	//Initiating the Page Objects
	public ShopItemPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String CheckShopItemTitle(){
		return driver.getTitle();
	}
	
	public boolean CheckShopItemPageLogo(){
		return ShopItemPageLogo.isDisplayed();
	}
	
	public CartPage ClickOnCartItemLink(){
		CartButton.click();
		return new CartPage();
	}
	
	public void CheckSearchWithinResult(){
		SearchWithinResult.sendKeys("Acana");
		SearchEnterButton.click();
		
	}
	
	public void CheckFilterCheckBox(String name){ 
		driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).click();
	}
	
	public ShopItemPage CheckClearFiltersButton(String name){
		driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).click();
		ClearFilter.click();
		return new ShopItemPage();
	}
	
	public void CheckSortBy(String name){
		 Select SortBy=new Select(SortByDropDown);
		 SortBy.selectByVisibleText(name);
	}
	
	public void CheckSelectCategory(String name){
		List<WebElement> dropdown_list=driver.findElements(By.xpath("//button[contains(@class,'simplebar-scroll-content')]"));
		System.out.println("The Total Values in the drop are"+dropdown_list);   
		for(int i=0;i<dropdown_list.size();i++){        
			System.out.println(dropdown_list.get(i).getText());
			if(dropdown_list.get(i).getText().contains("Bird"))
				dropdown_list.get(i).click();
			}
		}
	
	      
	public void CheckSelectBrand(String brand){
		driver.findElement(By.xpath("//a[contains(text(),'"+brand+"')]")).click();
	}
	
	public ProductQuantityPage SelectProductBrand() throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(text(),'Acana')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Add to cart')][1]")).click();
		Thread.sleep(10000);
		return new ProductQuantityPage(); 
	}
	
	
	
	                
	
	

}
