package firstTest;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Resume {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Eloy/Desktop/Java-Workspace/JavaTest/bin/firstTest/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.youtube.com");
		
		// Refresh tab
		driver.navigate().refresh();
		// Back
		//driver.navigate().back();
		
		// Get Title
		//String title = driver.getTitle();
		
		// Get current url
		//String currentUrl = driver.getCurrentUrl();
		
		// Get all the pageSource (html, etc)
		//String pageSource = driver.getPageSource();
		
		
		WebElement searchInput = driver.findElement(By.id("masthead-search-term"));
		searchInput.sendKeys("Elvis");
		WebElement searchButton = driver.findElement(By.id("search-btn"));
		searchButton.click();
		
		
		WebElement contenedorDeVideos = driver.findElement(By.className("item-section"));
		System.out.println(driver.getPageSource());
		
		
		 
	}

}
