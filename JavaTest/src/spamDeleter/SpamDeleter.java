package spamDeleter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpamDeleter {
	
	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Eloy/Desktop/Java-Workspace/JavaTest/bin/firstTest/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://mail.google.com/");

		
		driver.findElement(By.id("identifierId")).sendKeys("eloymazza.ra@gmail.com");
		WebElement nextButton = driver.findElement(By.className("CwaK9"));
		nextButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".Xb9hP > input")).sendKeys("altairezzio");
		driver.findElement(By.id("passwordNext")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=':2q']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String preDividend = driver.findElement(By.xpath("//*[@id=':ir']/span/span[2]")).getText();
		System.out.println(preDividend);
		preDividend = preDividend.replace(".", "");	
		int dividendo = Integer.parseInt(preDividend);
		
		int divisor = Integer.parseInt(driver.findElement(By.xpath("//*[@id=':ir']/span/span[1]/span[2]")).getText());
		int cont = (int) Math.floor(dividendo/divisor);
		System.out.println(cont);
		
		
		for (int i = 0; i < cont; i++) {
			driver.findElement(By.xpath("//*[@id=':36']/div[1]/span/div")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[3]/div/div")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
