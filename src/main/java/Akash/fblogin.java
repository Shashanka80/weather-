package Akash;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fblogin {
	public static void main(String[] args) {
		//this code is to run different version of chrome browser
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/login/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("email")).sendKeys("Akash Swamy");
		driver.findElement(By.id("pass")).sendKeys("Quality@2020");
		driver.findElement(By.id("email")).click();
		driver.close();
		


		

	}

}
