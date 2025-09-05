package CucumberTest.CucumberTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xyz {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://rahulshettyacademy.com/client");
		 System.out.println(driver.getCurrentUrl());		 
		 
		 
		    driver.get("https://rahulshettyacademy.com/client");
		    driver.manage().window().maximize();
		    driver.findElement(By.id("userEmail")).sendKeys("satyadurgayanangi@gmail.com");
		    driver.findElement(By.id("userPassword")).sendKeys("Durga@123");
		    driver.findElement(By.id("login")).click();
		    System.out.println(driver.getCurrentUrl());
		    
		    System.out.println((driver.findElement(By.xpath("//button[normalize-space()='Sign Out']")).isDisplayed()));
		    
		    System.out.println(driver.findElement(By.xpath("//button[normalize-space()='Sign Out']")).getText());		    
		    
//driver.quit();
	}

}
