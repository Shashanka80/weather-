package pompages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class corejavavideopage 
{
//declaration
	@FindBy(xpath="//h1[text()='Core Java For Selenium Training']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//button[@aria-label='Play']")
	private WebElement playbutton;
	
	@FindBy(xpath="//button[@aria-label='Pause']")
	private WebElement pausebutton;
	
	@FindBy(xpath="//span[text()='Add To Wishlist']")
	private WebElement addtowishlisttab;
	
	//intialization
	public corejavavideopage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		
	}
	
	//utilization
	public String getpageheaderString() {
		
		return pageHeader.getText();
		
	}
	public void clickplaybutton() 
	{
	playbutton.click();	
	}
	public void clickpausebutton() {
		
		pausebutton.click();
	}
		
   public void clickaddtoWishlist() {
	   addtowishlisttab.click();
     }
	}

