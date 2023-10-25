package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	@FindBy (xpath = "//div[@class='grid_Square ']")private List<WebElement> products;
	
	@FindBy (xpath = "//a[@href='#QuickView']")private WebElement quickView;
	
	@FindBy (xpath = "//div[@class='item_title']//a")private List<WebElement> productTitle;

	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfProductDisplayedAfterSearch() {
		return products.size();
	}
	
	public void moveToDesiredProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index));
		actions.perform();
	}
	
	public void clickOnDesiredProduct(int index) {
		products.get(index).click();
	}
	
	public String getProductTitle(int index) {
	return	productTitle.get(index).getText();
	}
	
	public void clickOnQuickView() {
		quickView.click();
	}
	
	

}
