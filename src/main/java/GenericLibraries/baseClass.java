package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.SeleniumTrainingpage;
import pompages.TestingPage;
import pompages.corejavaforselenium;
import pompages.corejavavideopage;
import pompages.homepage;
import pompages.skillraryDemoAppPage;

public class baseClass
{
	protected PropertiesFileUtility property;
	protected ExcelUtilities excel;
	protected webDriverUtility web;
	protected WebDriver driver;
	protected homepage home;
	protected TestingPage testing;
	protected SeleniumTrainingpage selenium;
    protected corejavaforselenium corejava;
	protected coreseleniumPage coreJava;
	protected corejavavideopage corevideo;  
	
	
//@BeforeSuite
//@BeforeTest
@BeforeClass
public void classConfiguration() {
	property=new PropertiesFileUtility();
	excel = new ExcelUtilities();
	web = new webDriverUtility();
	
	property.propertyfileInitiaization(IConstantPath.PROPERTIES_FILE_PATH);
	excel.exceIinitialization(IConstantPath.EXCEL_FILE_PATH);
	}
@BeforeMethod
public void methodConfiguration() {
	long time=Long.parseLong(property.fetchproperty("timeouts"));
	driver=web.openApplication(property.fetchproperty("browser"), property.fetchproperty("url"), time);
	
	home = new homepage(driver);
	skillraryDemoAppPage skillrarydemo = new skillraryDemoAppPage(driver);
	corejavaforselenium coreJava  = new corejavaforselenium(driver);
	
	
	
}
@AfterMethod
@AfterClass
@AfterTest
@AfterSuite

}
