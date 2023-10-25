package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;

public class NaptolHomePageTest extends BaseTest {
	
	@BeforeMethod
	public void openBrowser() {
		driver =Browser.openBrowser();	
	}
	
	@Test
	public void NaptolLoginTest() throws InterruptedException {
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.clickOnLoginOrRegister();
		naptolHomePage.enterMobileNumber("8871680585");
		naptolHomePage.clickOnContinue();
		Thread.sleep(30000);
		Assert.assertTrue(naptolHomePage.isLogoutDisplayed());
		Assert.assertEquals(naptolHomePage.getUserName(),"Subodh");
	}
	
}
