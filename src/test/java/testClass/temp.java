package testClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class temp {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.yatra.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement cabs = driver.findElement(By.xpath("//a[@id='booking_engine_cabs']"));
		cabs.click();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		System.out.println(driver.getCurrentUrl());
		
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='ifd']"));
		driver.switchTo().frame(frame);
		
		WebElement domasticTransfer = driver.findElement(By.xpath("//select[@id='travelTypeSelect']"));
		Select s = new Select(domasticTransfer);
		s.selectByVisibleText("International Transfers");
		
		WebElement enterPickupLocation = driver.findElement(By.xpath("//input[@id='pac-input']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='kaido';",enterPickupLocation);
		
		driver.switchTo().window(addr.get(0));
		System.out.println(driver.getCurrentUrl());
		
		WebElement trivalerEconomy = driver.findElement(By.xpath("//div[@id='BE_flight_paxInfoBox']/i"));
		trivalerEconomy.click();
		
		WebElement adult = driver.findElement(By.xpath("//span[@id='adultPax']/parent::span/following-sibling::div/div/span[2]"));
		
		for(int i=0;i<=2;i++)
		{
			adult.click();
		}
		
		WebElement premiumEconomy = driver.findElement(By.xpath("//span[text()='Premium Economy']/parent::li"));
		js.executeScript("arguments[0].click()",premiumEconomy);
		
	}
}
