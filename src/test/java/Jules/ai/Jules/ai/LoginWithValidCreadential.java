package Jules.ai.Jules.ai;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithValidCreadential {
	
    public static void main(String[] args) {
        // Set up WebDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Open the URL
            driver.get("https://demo.haroldwaste.com/");

            // Fill in the login form
            WebElement emailField = driver.findElement(By.name("email"));
            emailField.sendKeys("qa@julesai.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("QaJULES2023!");

            // Click on the login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            // Validate successful login
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dashboardElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']"))
            );
            assert dashboardElement.isDisplayed();

            System.out.println("Login successful: Test passed.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

