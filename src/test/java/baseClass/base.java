package baseClass;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	
	
	public WebDriver initializeBrowser() {
		String browserName = "Firefox";
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		 else if(browserName.equalsIgnoreCase("Firefox")){
				driver = new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
   }
}
