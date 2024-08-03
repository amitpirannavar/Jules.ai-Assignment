package Jules.ai.Jules.ai;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import baseClass.base;

public class LoginFunctionality extends base{
	public WebDriver driver;
	
	public LoginFunctionality()
	{
		super();
	}
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		driver = initializeBrowser();
		driver.get("https://demo.haroldwaste.com/");
		
	}
	@Test(priority = 1)
	public void LoginWithValidCredentials () {
		
		WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@julesai.com");
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("QaJULES2023!");
        
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='help-hub-button']"))
        );
        assert dashboardElement.isDisplayed();
			
	}
	@Test(priority = 2)
	public void LoginWithOutPassword() {
		
		WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("amitpirannavar@gmail.com");
        
        //WebElement passwordField = driver.findElement(By.name("password"));
        //passwordField.sendKeys("1234567!");
        
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordwrong = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Required']")));
        
        assert passwordwrong.isDisplayed();
		
	}
	@Test(priority = 3)
	public void Login_With_Invalid_Email_Format() {
		
		WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("amitpirannavar");
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("1234567!");
        
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordwrong = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Email not valid']")));
        
        assert passwordwrong.isDisplayed();
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	

}
