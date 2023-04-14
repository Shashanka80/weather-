package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class corejavaforselenium 
{
	//declaration
	@FindBy(xpath="//h2[@class='list_title']")
	private WebElement pageHeader;
	@FindBy(xpath = "//a[text()=' Core Java For Selenium Trainin']")
	private WebElement coreJavaSeleniumlink;
	
	//Initialization
	public corejavaforselenium(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}
	public void clickCoreJavaforseleniumlink() {
		coreJavaSeleniumlink.click();
	}
}
