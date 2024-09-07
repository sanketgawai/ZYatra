package temp;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vis {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.yatra.com/");
		
		driver.findElement(By.xpath("//a[@id='booking_engine_visa']")).click();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		
		email.sendKeys("kaido@gmail.com");
		
		WebElement selectDestination = driver.findElement(By.xpath("//input[@id='country']"));
		selectDestination.sendKeys("Vietnam");
		
		WebElement selectVisaType = driver.findElement(By.xpath("//span[@id='visaType_title']"));
		selectVisaType.click();
		//selectVisaType.sendKeys("Vietnam 30 Days Tourist evisa");
	
	}
}
