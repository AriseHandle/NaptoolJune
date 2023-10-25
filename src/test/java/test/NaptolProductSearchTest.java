package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;
import pom.SearchResultPage;

public class NaptolProductSearchTest extends BaseTest{

	@BeforeMethod
	public void openBrowser() {
		driver =Browser.openBrowser();	
	}
	
	@Test
	public void productSearchTest() {
		NaptolHomePage naptolHomePage =new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("mobile");
		naptolHomePage.clickOnSearchButton();
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		int products =searchResultPage.getNumberOfProductDisplayedAfterSearch();
		Assert.assertTrue(products > 0);
		Assert.assertTrue(driver.getTitle().contains("mobile"));
	}
	
	@Test
	public void verifyIfProductIsVisbileInQickViewTab() {
		NaptolHomePage naptolHomePage =new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("mobile");
		naptolHomePage.clickOnSearchButton();
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		String title =searchResultPage.getProductTitle(0);
		searchResultPage.moveToDesiredProduct(driver, 0);
		searchResultPage.clickOnQuickView();
		//String actualTitle =searchResultPage.getproductTitleFromQuickViewTab();
	}
	 
	
}
