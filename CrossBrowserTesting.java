package day11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	
WebDriver driver;
		
		@Parameters({"MyBrowser","MyUrl"})
		@Test
		public void parameterTest1(String browser, String url) {
			
			
			
			if(browser.contains("Chrome")) {
				driver=new ChromeDriver();
			}
			
			
			else if(browser.contains("IE")) {

				driver=new InternetExplorerDriver();
				//driver.quit();
			}
			
			else if(browser.contains("FireFox")) {
				driver=new FirefoxDriver();

			}
			
			else {
				System.out.println("Sorry current browser >>>"+browser + "  is not supported by our framework please use FireFox, Google Chrome, Internet Explorer");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");
			driver.quit();
		}
	}


